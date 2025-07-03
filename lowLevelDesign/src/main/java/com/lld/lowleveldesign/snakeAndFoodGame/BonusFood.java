package com.lld.lowleveldesign.snakeAndFoodGame;

public class BonusFood extends FoodItem{
    public BonusFood(int row,int col) {
        super(row,col);
        points=3;
    }
}
