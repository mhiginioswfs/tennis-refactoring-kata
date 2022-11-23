package com.smallworldfs.tennis;

public class TennisGame {

    private int score1 = 0;
    private int score2 = 0;

    /**
     * @deprecated Names are not used
     */
    public TennisGame(String player1Name, String player2Name) {}

    public String getScore() {
        String player1Result = "";
        String player2Result = "";
        String score = "";
        if (score1 == score2 && score1 < 4) {
            score = Score.fromNumericScore(score1).getText();
            score += "-All";
        }
        if (score1 == score2 && score1 >= 3)
            score = "Deuce";

        if (score1 > 0 && score1 < 4 && score2 == 0) {
            player1Result = Score.fromNumericScore(score1).getText();
            player2Result = Score.fromNumericScore(score2).getText();
            score = player1Result + "-" + player2Result;
        }
        if (score2 > 0 && score2 < 4 && score1 == 0) {
            player1Result = Score.fromNumericScore(score1).getText();
            player2Result = Score.fromNumericScore(score2).getText();
            score = player1Result + "-" + player2Result;
        }

        if (score1 > score2 && score1 < 4) {
            player1Result = Score.fromNumericScore(score1).getText();
            player2Result = Score.fromNumericScore(score2).getText();
            score = player1Result + "-" + player2Result;
        }
        if (score2 > score1 && score2 < 4) {
            player1Result = Score.fromNumericScore(score1).getText();
            player2Result = Score.fromNumericScore(score2).getText();
            score = player1Result + "-" + player2Result;
        }

        if (score1 > score2 && score2 >= 3) {
            score = "Advantage player1";
        }

        if (score2 > score1 && score1 >= 3) {
            score = "Advantage player2";
        }

        if (score1 >= 4 && score2 >= 0 && (score1 - score2) >= 2) {
            score = "Win for player1";
        }
        if (score2 >= 4 && score1 >= 0 && (score2 - score1) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private void addP1Score() {
        score1++;
    }

    private void addP2Score() {
        score2++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            addP1Score();
        } else {
            addP2Score();
        }
    }
}
