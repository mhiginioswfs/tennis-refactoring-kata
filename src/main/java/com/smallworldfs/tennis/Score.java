package com.smallworldfs.tennis;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Score {
    LOVE("Love", 0),
    FIFTEEN("Fifteen", 1),
    THIRTY("Thirty", 2),
    FORTY("Forty", 3);

    private static final Map<Integer, Score> LOOKUP = createScoreLookup();
    private final String description;
    private final Integer points;

    Score(String description, Integer points) {
        this.description = description;
        this.points = points;
    }

    public static Score getScore(Integer points) {
        return LOOKUP.get(points);
    }

    public String getDescription() {
        return description;
    }

    private Integer getPoints() {
        return points;
    }

    private static Map<Integer, Score> createScoreLookup() {
        return Arrays.stream(Score.values()).collect(Collectors.toMap(Score::getPoints, Function.identity()));
    }


}
