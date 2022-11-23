package com.smallworldfs.tennis;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Score {

    ZERO(0, "Love"),
    FIFTY(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty");

    private static final Map<Integer, Score> LOOKUP = computeLookup();

    private static Map<Integer, Score> computeLookup() {
        return Arrays.stream(Score.values()).collect(Collectors.toMap(Score::getScore, Function.identity()));
    }


    private int score;
    private String text;

    Score(int score, String text) {
        this.score = score;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }

    public static Score fromNumericScore(int score) {
        return LOOKUP.get(score);
    }
}
