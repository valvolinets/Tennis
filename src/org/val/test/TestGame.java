package org.val.test;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

import org.junit.runners.Parameterized.Parameters;
import org.val.local.Game;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class TestGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String expectedScore;

    public TestGame(int playerOneScore, int playerTwoScore, String expectedScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.expectedScore = expectedScore;
    }

    public void getGameResult(Game game) {
        int highestScore = 3;
        for(int i = 0; i < highestScore; i++) {
            game.whoScores("playerOne");
            game.whoScores("playerTwo");
        }
        assertEquals(this.expectedScore, game.getResults());
    }

    // TODO parameters?
    
    @Test
    public void checkResults() {
        Game game = new Game("playerOne", "playerTwo");
        getGameResult(game);
    }
}