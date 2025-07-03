package com.lld.lowleveldesign.ticTacToe;

import com.lld.lowleveldesign.snakeAndLadder.Game;

public class GameStarter {
    public static void main (String[] args) {
        TicTacToeGame game = new TicTacToeGame(3,3,new HumanPlayer("Nischay"),new HumanPlayer("Nikita"),"Nischay","Nikita");
        game.play();
    }
}
