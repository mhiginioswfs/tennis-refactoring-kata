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
        if (isEndGameStage()) {
            if (scoreBoard.getScore1() == scoreBoard.getScore2()) {
                return "Deuce";
            }
            if (scoreBoard.getScore1() >= 4 && scoreBoard.getScore2() >= 0
                    && (scoreBoard.getScore1() - scoreBoard.getScore2()) >= 2) {
                return "Win for player1";
            }
            if (scoreBoard.getScore2() >= 4 && scoreBoard.getScore1() >= 0
                    && (scoreBoard.getScore2() - scoreBoard.getScore1()) >= 2) {
                return "Win for player2";
            }
            if (scoreBoard.getScore1() > scoreBoard.getScore2() && scoreBoard.getScore2() >= 3) {
                return "Advantage player1";
            }
            if (scoreBoard.getScore2() > scoreBoard.getScore1() && scoreBoard.getScore1() >= 3) {
                return "Advantage player2";
            }
        }
        if (scoreBoard.getScore1() == scoreBoard.getScore2()) {
            String score = Score.fromNumericScore(scoreBoard.getScore1()).getText();
            score += "-All";
            return score;
        }
        String player1Result = Score.fromNumericScore(scoreBoard.getScore1()).getText();
        String player2Result = Score.fromNumericScore(scoreBoard.getScore2()).getText();
        return player1Result + "-" + player2Result;
    }

    private boolean isEndGameStage() {
        return scoreBoard.getScore1() > 3 || scoreBoard.getScore2() > 3
                || (scoreBoard.getScore1() == 3 && scoreBoard.getScore2() == 3);
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
