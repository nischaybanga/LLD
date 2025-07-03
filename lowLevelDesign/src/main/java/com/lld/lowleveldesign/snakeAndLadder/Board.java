package com.lld.lowleveldesign.snakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
public class Board {
    private Map<Integer, Jumpers> snakes;
    private Map<Integer, Jumpers> ladder;
    private int numberOfCells;
    public Board(int numberOfCells, Map<Integer, Jumpers> snakes, Map<Integer, Jumpers> ladder) {
        this.numberOfCells = numberOfCells;
        this.snakes = snakes;
        this.ladder = ladder;
    }
    public int getJumperPosition(int cell){
        if (snakes!=null&&snakes.containsKey(cell)){
            return snakes.get(cell).getEnd();
        }else if(ladder!=null&&ladder.containsKey(cell)){
            return ladder.get(cell).getEnd();
        }
        return -1;
    }

    public boolean isGameOver(int cell){
        return cell == numberOfCells - 1;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }
}
