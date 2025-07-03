package com.lld.lowleveldesign.ticTacToe;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext context;
    public TicTacToeGame(int row,int column, PlayerStrategy playerStrategyX, PlayerStrategy playerStrategyO, String playerXName, String playerOName) {
        this.board = new Board(row,column);
        this.playerX=new Player(playerXName,Symbol.X,playerStrategyX);
        this.playerO=new Player(playerOName,Symbol.O,playerStrategyO);
        this.currentPlayer=this.playerX;
        this.context=new GameContext();
    }
    public void play(){
        System.out.println(playerX.getName()+" is player X (he's gonna win)");
        System.out.println(playerO.getName()+" is player O");
        while(true){
            Position move=currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move,currentPlayer.getSymbol());
            board.printBoard();
            board.checkGameStateAndSwitchState(context,currentPlayer);
            if (context.getCurrentState().isGameOver()){
                GameState state=context.getCurrentState();
                if (state instanceof XWonState){
                    System.out.println(playerX.getName()+" won!!");
                }else if (state instanceof OWonState){
                    System.out.println(playerO.getName()+" won!!");
                }else{
                    System.out.println("It's a draw");
                }
                board.printBoard();
                return;
            }
            switchPlayer();
        }
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}
