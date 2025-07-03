package com.lld.lowleveldesign.ticTacToe;

import lombok.*;

@NoArgsConstructor
public class Player {
    private String name;
    private Symbol symbol;
    private PlayerStrategy playerStrategy;
    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for symbol
    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    // Getter and Setter for playerStrategy
    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public Player(String name, Symbol symbol, PlayerStrategy playerStrategy){
        this.name = name;
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

}
