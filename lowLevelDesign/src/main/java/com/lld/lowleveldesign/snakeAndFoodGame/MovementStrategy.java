package com.lld.lowleveldesign.snakeAndFoodGame;

import ch.qos.logback.core.joran.sanity.Pair;

public interface MovementStrategy {
    public Position getNextPosition(String direction, Position currentPosition);
}
