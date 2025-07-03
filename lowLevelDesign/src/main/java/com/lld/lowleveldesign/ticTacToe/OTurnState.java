package com.lld.lowleveldesign.ticTacToe;

public class OTurnState implements GameState{
    @Override
    public void next(GameContext gameContext, boolean hasWon, Player currentPlayer){
        if (hasWon){
            gameContext.setCurrentState(Symbol.X.equals(currentPlayer.getSymbol())?new XWonState():new OWonState());
            return;
        }
        gameContext.setCurrentState(new XTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
