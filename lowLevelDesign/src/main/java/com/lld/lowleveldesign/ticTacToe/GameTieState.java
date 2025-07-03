package com.lld.lowleveldesign.ticTacToe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GameTieState implements GameState{
    @Override
    public void next(GameContext gameContext, boolean hasWon, Player currentPlayer){

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
