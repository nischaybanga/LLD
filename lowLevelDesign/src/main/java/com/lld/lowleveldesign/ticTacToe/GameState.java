package com.lld.lowleveldesign.ticTacToe;

public interface GameState {
    public boolean isGameOver();
    public void next(GameContext context,boolean hasWon, Player currentPlayer);
}
