package com.lld.lowleveldesign.snakeAndFoodGame;

public abstract class FoodItem {
    public int row, column;
    public int points;
    public FoodItem(int row, int column) {
        this.row = row;
        this.column = column;
    }

}
