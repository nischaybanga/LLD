package com.lld.lowleveldesign.snakeAndFoodGame;

import java.util.List;

public class Food {
    private List<FoodItem> foodPositions;
    private int currentFoodIndex;
    public Food(List<FoodItem> foodPositions) {
        this.foodPositions = foodPositions;
        this.currentFoodIndex = 0;
    }
    public int getCurrentFoodIndex() {
        return currentFoodIndex;
    }
    public void setCurrentFoodIndex(int currentFoodIndex) {
        this.currentFoodIndex = currentFoodIndex;
    }
    public List<FoodItem> getFoodPositions() {
        return foodPositions;
    }
    public void setFoodPositions(List<FoodItem> foodPositions) {
        this.foodPositions = foodPositions;
    }

    public FoodItem getCurrentFood() {
        if (foodPositions.size() <= currentFoodIndex) {
            return null;
        }
        return foodPositions.get(currentFoodIndex);
    }
}
