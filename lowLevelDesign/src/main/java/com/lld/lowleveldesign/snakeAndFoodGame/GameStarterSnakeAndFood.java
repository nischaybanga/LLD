package com.lld.lowleveldesign.snakeAndFoodGame;

import java.util.*;

public class GameStarterSnakeAndFood {
    public static void main(String[] args) {
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new NormalFood(1,2));
        foodItems.add(new BonusFood(5,8));
        foodItems.add(new NormalFood(6,6));
        foodItems.add(new BonusFood(7,1));
        foodItems.add(new NormalFood(2,3));
        Deque<Position>snake = new LinkedList<>();
        snake.addFirst(new Position(1,1));
        Map<Position, Boolean> snakePosition=new HashMap<>();
        snakePosition.put(new Position(1,1),true);
        SnakeAndFoodGame game=new SnakeAndFoodGame(10,10,new Food(foodItems),new HumanMovementStrategy(),snake,snakePosition);
        Scanner scanner=new Scanner(System.in);
        int currentScore=0;
        game.printGameBoard();
        while(true){
            System.out.printf("Please enter W for up, S for down, D for right and A for left\n");
            String userInput=scanner.nextLine();
            int score=game.move(userInput);
            game.printGameBoard();
            if (score==-1){
                System.out.printf("GAME OVER!! your points were %d\n",currentScore);
                return;
            }else if (score==-2){
                System.out.printf("YOU WIN! with a score of %d\n",currentScore);
            } else{
                System.out.printf("YOU SCORED %d points with this\n",score);
                currentScore+=score;
            }
        }
    }
}
