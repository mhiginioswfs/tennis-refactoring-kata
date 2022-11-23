package com.smallworldfs.tennis;

import static com.smallworldfs.tennis.ScoreBoardFormatter.formatterFor;

public class TennisGame {

    private ScoreBoard scoreBoard;

    /**
     * @deprecated Names are not used
     */
    public TennisGame(String player1Name, String player2Name) {
        scoreBoard = new ScoreBoard();
    }

    public String getScore() {
        return formatterFor(scoreBoard).apply(scoreBoard);
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
