package com.lld.lowleveldesign.ticTacToe;

import lombok.Data;

@Data
public class GameContext {
    private GameState currentState;
    public GameContext() {
        currentState = new XTurnState();
    }
    public void next (boolean hasWon, Player currentPlayer){
        currentState.next(this,hasWon,currentPlayer);
    }

    public void setCurrentState(GameState state) {
        this.currentState = state;
    }

    public GameState getCurrentState() {
        return this.currentState;
    }

}
