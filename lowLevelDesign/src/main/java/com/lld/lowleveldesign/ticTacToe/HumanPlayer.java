package com.lld.lowleveldesign.ticTacToe;

import java.util.Scanner;

public class HumanPlayer implements PlayerStrategy{
    private String name;
    private Scanner scanner;

    public HumanPlayer(String playerName){
        name=playerName;
        scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        while (true){
            System.out.printf("%s, enter your move (row [0-2] and column [0-2]): ", name);
            try {
                int row=scanner.nextInt();
                int column=scanner.nextInt();
//                System.out.printf("%s, you entered row %s and column %s", name,row,column);
                Position position = new Position(row, column);
                if (board.isValidMove(position)){
                    return position;
                }
                System.out.printf("%s, not a valid move, enter your move again (row [0-2] and column [0-2]): ", name);
            }catch (Exception e){
                System.out.println("Invalid move please enter again");
                scanner.nextLine();
            }
        }
    }
}
