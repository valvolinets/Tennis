package org.val.local;

public class Game {
    private String playerOne;
    private String playerTwo;
    private int scoreOne;
    private int scoretwo;

    public Game(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void whoScores(String name) {
        if (name == playerOne) {
            scoreOne++;
        } else {
            scoretwo++;
        }
    }
}