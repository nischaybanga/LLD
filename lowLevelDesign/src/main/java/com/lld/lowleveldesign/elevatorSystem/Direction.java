package com.lld.lowleveldesign.elevatorSystem;

public enum Direction {
    UP, DOWN, IDLE;
    public static Direction parse(String direction) {
        if (direction.equalsIgnoreCase("UP")) {
            return UP;
        }else if (direction.equalsIgnoreCase("DOWN")) {
            return DOWN;
        }else if (direction.equalsIgnoreCase("IDLE")) {
            return IDLE;
        }
        return null;
    }
}
