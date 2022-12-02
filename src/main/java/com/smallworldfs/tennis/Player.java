package com.smallworldfs.tennis;

public class Player {

    private final String name;
    private final Integer order;
    private Integer points = 0;

    private Score score = Score.LOVE;

    public Player(String name, Integer order) {
        this.name = name;
        this.order = order;
    }

    public void addPoint() {
        this.points ++;
        this.score = Score.getScore(this.points);
    }

    public String getName() {
        return name;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getOrder() {
        return order;
    }

    public Score getScore() {
        return score;
    }
}
