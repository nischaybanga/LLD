package com.lld.lowleveldesign.ticTacToe;

public class XWonState implements GameState{
    @Override
    public void next(GameContext gameContext, boolean hasWon, Player currentPlayer){

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
