package com.lld.lowleveldesign.snakeAndFoodGame;

public class GameBoard {
    private int row;
    private int col;
    public GameBoard(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
