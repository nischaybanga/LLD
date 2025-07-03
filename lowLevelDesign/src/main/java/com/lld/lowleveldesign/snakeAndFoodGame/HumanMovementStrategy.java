package com.lld.lowleveldesign.snakeAndFoodGame;

import ch.qos.logback.core.joran.sanity.Pair;

public class HumanMovementStrategy implements MovementStrategy{
    @Override
    public Position getNextPosition(String direction, Position currentPosition){
        int row=currentPosition.getRow();
        int col=currentPosition.getColumn();
        System.out.printf("Direction: %s\n",direction);
        if (direction.equalsIgnoreCase("W")){
            return new Position(row-1,col);
        }else if (direction.equalsIgnoreCase("S")){
            return new Position(row+1,col);
        }else if (direction.equalsIgnoreCase("A")){
            return new Position(row,col-1);
        }else if (direction.equalsIgnoreCase("D")){
//            System.out.printf("in d");
            return new Position(row,col+1);
        }
        return null;
    }
}
