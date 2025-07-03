package com.lld.lowleveldesign.ticTacToe;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Board {
    private int row;
    private int column;
    private Symbol[][] grid;
    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        grid = new Symbol[row][column];
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                grid[i][j]=Symbol.EMPTY;
            }
        }
    }

    public void makeMove(Position position, Symbol symbol){
        if (position.getRow()>=this.row||position.getColumn()>=this.column){
            return;
        }
        grid[position.getRow()][position.getColumn()]=symbol;
    }

    public boolean isValidMove(Position position){
        if (position.getRow()>=this.row||position.getColumn()>=this.column){
            return false;
        }
        return grid[position.getRow()][position.getColumn()] == Symbol.EMPTY;
    }

    public void checkGameStateAndSwitchState(GameContext context, Player currentPlayer) {
        for (int i = 0; i < row; i++) {
            if (grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                context.next(true,currentPlayer);
                return;
            }
        }
        for (int i = 0; i < column; i++) {
            Symbol[] column = new Symbol[row];
            for (int j = 0; j < row; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.next(true,currentPlayer);
                return;
            }
        }
        Symbol[] diagonal1 = new Symbol[Math.min(row, column)];
        Symbol[] diagonal2 = new Symbol[Math.min(row, column)];
        for (int i = 0; i < Math.min(row, column); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][column - 1 - i];
        }
        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            context.next(true,currentPlayer);
            return;
        }
        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            context.next(true,currentPlayer);
            return;
        }
        boolean isGameTied=true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == Symbol.EMPTY) {
                    isGameTied=false;
                }
            }
        }
        if (isGameTied) {
            context.setCurrentState(new GameTieState());
        }
        context.next(false,currentPlayer);
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < column - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < row - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
}
