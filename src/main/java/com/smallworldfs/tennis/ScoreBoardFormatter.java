package com.smallworldfs.tennis;

import java.util.function.Function;

public enum ScoreBoardFormatter {

    DEUCE((ScoreBoard scoreBoard) -> "Deuce"),
    ADVANTAGE((ScoreBoard scoreBoard) -> "Advantage " + scoreBoard.getWinner()),
    WINNER((ScoreBoard scoreBoard) -> "Win for " + scoreBoard.getWinner()),
    REGULAR_TIE((ScoreBoard scoreBoard) -> scoreBoard.getScore1() + "-All"),
    REGULAR((ScoreBoard scoreBoard) -> scoreBoard.getScore1() + "-" + scoreBoard.getScore2());

    private Function<ScoreBoard, String> formatter;

    ScoreBoardFormatter(Function<ScoreBoard, String> formatter) {
        this.formatter = formatter;
    }

    public String apply(ScoreBoard scoreBoard) {
        return formatter.apply(scoreBoard);
    }

    public static ScoreBoardFormatter formatterFor(ScoreBoard scoreBoard) {
        if (scoreBoard.isEndGameStage()) {
            return switch (scoreBoard.getDifference()) {
                case 0 -> DEUCE;
                case 1 -> ADVANTAGE;
                default -> WINNER;
            };
        }
        return scoreBoard.getDifference() == 0 ? REGULAR_TIE : REGULAR;
    }
}
