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
    private int playerOneScore;
    private int playerTwoScore;
    private String expectedScore;

    public TestGame(int playerOneScore, int playerTwoScore, String expectedScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.expectedScore = expectedScore;
    }

    public void getGameResult(Game game) {
        int highestScore = Math.max(this.playerOneScore, this.playerTwoScore);
        for(int i = 0; i < highestScore; i++) {
            if(i < this.playerOneScore)
            game.whoScores("playerOne");
            if (i < this.playerTwoScore)
            game.whoScores("playerTwo");
        }
        assertEquals(this.expectedScore, game.getResults());
    }

    // TODO parameters?
    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},

                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, "Player 1 Wins"},
                { 0, 4, "Player 2 Wins"},

                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Player 1 Wins"},
                { 1, 4, "Player 2 Wins"},

                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, "Player 1 Wins"},
                { 2, 4, "Player 2 Wins"},

                { 4, 3, "Player 1 Advantage"},
                { 3, 4, "Player 2 Advantage"},
                { 5, 4, "Player 1 Advantage"},
                { 4, 5, "Player 2 Advantage"},
                { 15, 14, "Player 1 Advantage"},
                { 14, 15, "Player 2 Advantage"},

                { 6, 4, "Player 1 Wins"},
                { 4, 6, "Player 2 Wins"},
                { 16, 14, "Player 1 Wins"},
                { 14, 16, "Player 2 Wins"},
        });
    }
    
    @Test
    public void checkResults() {
        Game game = new Game("playerOne", "playerTwo");
        getGameResult(game);
    }
}