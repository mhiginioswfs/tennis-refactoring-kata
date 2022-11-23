package com.smallworldfs.tennis;

public class ScoreBoard {

    private int score1;
    private int score2;

    public String getScore1() {
        return Score.fromNumericScore(score1).getText();
    }

    public String getScore2() {
        return Score.fromNumericScore(score2).getText();
    }

    public void incScore1() {
        score1++;
    }

    public void incScore2() {
        score2++;
    }

    public boolean isEndGameStage() {
        return score1 > 3 || score2 > 3 || (score1 == 3 && score2 == 3);
    }

    public int getDifference() {
        return Math.abs(score1 - score2);
    }

    public String getWinner() {
        return score1 > score2 ? "player1" : score2 > score1 ? "player2" : "tie";
    }
}
