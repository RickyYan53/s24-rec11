package edu.cmu.cs.cs214.rec11.plugin;

import java.util.*;

import edu.cmu.cs.cs214.rec11.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec11.framework.core.GamePlugin;

import edu.cmu.cs.cs214.rec11.games.TicTacToe;
import edu.cmu.cs.cs214.rec11.games.TicTacToe.Player;

/**
 */
public class TTTPlugin implements GamePlugin<Player> {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    

    private static final String GAME_NAME = "Tic Tac Toe";
    private static final String UNKNOWN_SQUARE_STRING = "";
    private static final String BLANK_SQUARE_STRING = "";
    private static final String PLAYER_WON_MSG = "Player X won!";
    private static final String GAME_DRAW_MSG = "Player somebody won!";

    private GameFramework framework;
    private int firstIndexSelected;

    private TicTacToe TTTgame;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return WIDTH;
    }

    @Override
    public int getGridHeight() {
        return HEIGHT;
    }

    @Override
    public void onRegister(GameFramework f) {
        framework = f;
    }

    @Override
    public void onNewGame() {
        this.TTTgame = new TicTacToe();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                framework.setSquare(i, j, UNKNOWN_SQUARE_STRING);
            }
        }
        framework.setFooterText("You are playing Tic Tac Toe!");
    }

    @Override
    public void onNewMove() {
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return TTTgame.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }

    @Override
    public void onMovePlayed(int x, int y) {
        String cur = TTTgame.currentPlayer().toString();
        this.TTTgame.play(x, y);
        framework.setSquare(x, y, cur);
    }

    @Override
    public boolean isGameOver() {
        return TTTgame.isOver();
    }

    @Override
    public String getGameOverMessage() {
        return PLAYER_WON_MSG;
    }

    @Override
    public Player currentPlayer() {
        return TTTgame.currentPlayer();
    }

    @Override
    public void onGameClosed() {
    }
}
