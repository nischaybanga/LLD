package com.lld.lowleveldesign.snakeAndFoodGame;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Snake {
    private Deque<Position>body;
    private Map<Position, Boolean>positionMap;
    public Snake(Deque<Position>body, Map<Position, Boolean>positionMap) {
        this.body = body;
        this.positionMap = positionMap;
    }
    public Deque<Position> getBody() {
        return body;
    }
    public void setBody(Deque<Position> body) {
        this.body = body;
    }
    public Map<Position, Boolean> getPositionMap() {
        return positionMap;
    }
    public void setPositionMap(Map<Position, Boolean> positionMap) {
        this.positionMap = positionMap;
    }
    public void move(Position nextHeadPosition,boolean hasEatenFood){
        if (!hasEatenFood){
            Position tailEnd=this.body.removeLast();
            this.positionMap.remove(tailEnd);
        }
        this.body.addFirst(nextHeadPosition);
        this.positionMap.put(nextHeadPosition, true);
    }
}
