package com.lld.lowleveldesign.snakeAndLadder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
    private String name;
    private static int idCounter = 1;
    private int id;
    private int currentCell;
    public Player(String name) {
        this.name = name;
        this.currentCell=0;
        this.id = idCounter++;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getCurrentCell(){
        return currentCell;
    }
    public void setCurrentCell(int currentCell){
        this.currentCell = currentCell;
    }
}
