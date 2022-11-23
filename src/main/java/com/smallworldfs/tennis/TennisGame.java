package com.smallworldfs.tennis;

public class TennisGame {

    private ScoreBoard scoreBoard;

    /**
     * @deprecated Names are not used
     */
    public TennisGame(String player1Name, String player2Name) {
        scoreBoard = new ScoreBoard();
    }

    public String getScore() {
        if (scoreBoard.isEndGameStage()) {
            int difference = scoreBoard.getDifference();
            if (difference == 0) {
                return "Deuce";
            }
            if (difference == 1) {
                return "Advantage " + scoreBoard.getWinner();
            }
            return "Win for " + scoreBoard.getWinner();

        }
        if (scoreBoard.getDifference() == 0) {
            return scoreBoard.getScore1() + "-All";
        }
        return scoreBoard.getScore1() + "-" + scoreBoard.getScore2();
    }

    private void addP1Score() {
        scoreBoard.incScore1();
    }

    private void addP2Score() {
        scoreBoard.incScore2();
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            addP1Score();
        } else {
            addP2Score();
        }
    }
}
