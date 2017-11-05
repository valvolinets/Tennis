package org.val.local;

public class Game {
    private String playerOne;
    private String playerTwo;
    private int scoreOne;
    private int scoreTwo;

    public Game(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void whoScores(String name) {
        if (name == playerOne) {
            scoreOne += 1;
        } else {
            scoreTwo += 1;
        }
    }

    public String getResults() {

        String score = null;
        int tmp = 0;
        if(scoreOne == scoreTwo) {
            // Draw
            switch(scoreOne) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;

            }

        } else if(scoreOne >= 4 || scoreTwo >= 4) { // Advantage
            int advantage = scoreOne - scoreTwo;
            if (advantage == 1) {
                score = "Player 1 Advantage";
            } else if (advantage == -1) {
                score = "Player 2 Advantage";
            } else if (advantage >= 2) {
                score = "Player 1 Wins";
            } else {
                score = "Player 2 Wins";
            }

        } else {
            for (int i = 0; i < 3; i++){
            if(i == 1) tmp = scoreOne;
            else {tmp = scoreTwo;}
            switch (tmp) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        }
        return score;
    }
}