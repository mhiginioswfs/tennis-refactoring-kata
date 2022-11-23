package com.smallworldfs.tennis;

import static com.smallworldfs.tennis.ScoreBoardFormatter.formatterFor;

public class TennisGame {

    private final ScoreBoard scoreBoard;

    /**
     * @deprecated Names are not used
     */
    public TennisGame(String player1Name, String player2Name) {
        scoreBoard = new ScoreBoard();
    }

    public String getScore() {
        return formatterFor(scoreBoard).apply(scoreBoard);
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            scoreBoard.incScore1();
        } else {
            scoreBoard.incScore2();
        }
    }
}
