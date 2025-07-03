package com.lld.lowleveldesign.snakeAndLadder;

import java.util.List;

public class Game {
    private Board board;
    private  List<Player> players;
    private  Dice dice;
    Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }
    public void play() {
        int i=-1;
        while(true){
//            System.out.printf("i before-> %d\n",i);
            int currentPlayerIndex=getCurrentPlayerIndex(i);
//            System.out.printf("i after-> %d\n",currentPlayerIndex);
            int number=dice.roll();
            Player player=players.get(currentPlayerIndex);
            System.out.printf("Player %s rolled a %d\n", player.getName(),number);
            int landingCell=number+player.getCurrentCell();
            int positionAfterJumper=board.getJumperPosition(landingCell);
            if (positionAfterJumper==-1){
                if (landingCell>=board.getNumberOfCells()){
                    landingCell=player.getCurrentCell();
                }
                player.setCurrentCell(landingCell);
                System.out.printf("Current position of %s is %d\n", player.getName(),landingCell);
                boolean isGameOver=board.isGameOver(landingCell);
                if (isGameOver){
                    System.out.printf("Player %s won!!\n", player.getName());
                    return;
                }
                i=currentPlayerIndex;
                continue;
            }
            landingCell=positionAfterJumper;
            if (landingCell>=board.getNumberOfCells()){
                landingCell=player.getCurrentCell();
            }
            System.out.printf("Current position of %s is %d\n", player.getName(),landingCell);
            player.setCurrentCell(landingCell);
            boolean isGameOver=board.isGameOver(landingCell);
            if (isGameOver){
                System.out.printf("Player %s won!!\n", player.getName());
                return;
            }
            i=currentPlayerIndex;
        }
    }

    public int getCurrentPlayerIndex(int i) {
        if (i==players.size()-1){
            return 0;
        }
        i++;
        return i;
    }
}
