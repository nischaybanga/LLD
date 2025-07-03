package com.lld.lowleveldesign.snakeAndFoodGame;

import java.util.Deque;
import java.util.Map;

public class SnakeAndFoodGame {
    private GameBoard gameBoard;
    private Snake snake;
    private Food food;
    private MovementStrategy movementStrategy;
    public SnakeAndFoodGame(int boardRows, int boardColumns, Food food, MovementStrategy movementStrategy, Deque<Position> snakeBody, Map<Position, Boolean> positionMap) {
        this.gameBoard = new GameBoard(boardRows,boardColumns);
        this.food = food;
        this.movementStrategy = movementStrategy;
        this.snake = new Snake(snakeBody,positionMap);
    }
    public int move (String direction){
        if (areAllFoodItemsConsumed()){
            return -2;
        }
        Position currentHeadPositionSnake=snake.getBody().peekFirst();
        FoodItem foodItem=food.getCurrentFood();
//        System.out.printf("direction-> %s\n",direction);
//        System.out.printf("current head row-> %d\n",currentHeadPositionSnake.getRow());
//        System.out.printf("current head col-> %d\n",currentHeadPositionSnake.getColumn());
        Position nextHeadPosition=movementStrategy.getNextPosition(direction,currentHeadPositionSnake);
        if (isGameOver(nextHeadPosition)){
            return -1;
        }
        boolean hasEatenFoodItem=hasEatenFoodItem(nextHeadPosition,foodItem);
        snake.move(nextHeadPosition,hasEatenFoodItem);
        if (hasEatenFoodItem){
            food.setCurrentFoodIndex(food.getCurrentFoodIndex()+1);
            return foodItem.points;
        }
        return 0;
    }
    private boolean hasEatenFoodItem(Position headPosition, FoodItem foodItem){
        if (foodItem==null||headPosition==null){
            return false;
        }
        return headPosition.getRow()==foodItem.row&&headPosition.getColumn()==foodItem.column;
    }

    private boolean isGameOver(Position headPosition){
        boolean hasHitWalls=headPosition.getRow()==gameBoard.getRow()-1 || headPosition.getColumn()==gameBoard.getCol()-1||headPosition.getRow()==0||headPosition.getColumn()==0;
        if (hasHitWalls){
            return true;
        }
        return containsWrapperHashMap(snake.getPositionMap(),headPosition);
    }
    private boolean areAllFoodItemsConsumed(){
        return food.getCurrentFoodIndex()==food.getFoodPositions().size()-1;
    }

    public void printGameBoard(){
        FoodItem foodItem=food.getCurrentFood();
        int foodItemRow=-1;
        int foodItemCol=-1;
        if (foodItem!=null){
            foodItemRow=foodItem.row;
            foodItemCol=foodItem.column;
        }
        int snakeHeadRow=snake.getBody().peekFirst().getRow();
        int snakeHeadCol=snake.getBody().peekFirst().getColumn();
        for (int i=0;i<gameBoard.getRow();i++){
            for (int j=0;j<gameBoard.getCol();j++){
                boolean printedSomething=false;
                if (i==0||i==gameBoard.getRow()-1){
                    printedSomething=true;
                    System.out.print(">");
                }else if(j==0||j==gameBoard.getCol()-1){
                    printedSomething=true;
                    System.out.print("|");
                }
                if ((foodItemRow!=-1||foodItemCol!=-1)&&(i==foodItemRow&&j==foodItemCol)){
                    printedSomething=true;
                    System.out.print("0");
                }
                Position checkSnakeBodyPosition=new Position(i,j);
                if (i==snakeHeadRow&&j==snakeHeadCol){
                    printedSomething=true;
                    System.out.print(">");
                }else if (containsWrapperHashMap(snake.getPositionMap(),checkSnakeBodyPosition)){
                    printedSomething=true;
                    System.out.printf("-");
                }
                if (!printedSomething){
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
        }
    }
    boolean containsWrapperHashMap(Map<Position, Boolean>positionMap, Position position){
        for (Position key : positionMap.keySet()) {
            if (key.getRow()==position.getRow()&&key.getColumn()==position.getColumn()){
                return true;
            }
        }
        return false;
    }

}
