package com.lld.lowleveldesign.snakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDemoPlay {
    public static void main(String[] args){
        List<Player> players=new ArrayList<>();
        players.add(new Player("Nischay"));
        players.add(new Player("Nikita"));
        Map<Integer,Jumpers>snakes=new HashMap<>();
        Map<Integer,Jumpers>ladders=new HashMap<>();
        Game game=new Game(new Board(100,snakes,ladders),players,new Dice(1));
        game.play();
    }
}
