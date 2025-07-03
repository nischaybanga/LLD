package com.lld.lowleveldesign.snakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dice {
    private int numberOfDie;

    public int roll() {
        int sum = 0;
        for (int i = 0; i < numberOfDie; i++) {
            sum += (int)(Math.random() * 6) + 1;
        }
        return sum;
    }
    public Dice (int numberOfDie){
        this.numberOfDie=numberOfDie;
    }
}
