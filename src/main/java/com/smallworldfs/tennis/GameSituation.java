package com.smallworldfs.tennis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameSituation {

    private Player player1;
    private Player player2;

    private Map<Integer, Player> players = new HashMap<>();

    public GameSituation(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        players.put(player1.getOrder(), player1);
        players.put(player2.getOrder(), player2);
    }

    public Player getPlayer1() {
        return players.get(1);
    }

    public Player getPlayer2() {
        return players.get(2);
    }

    public String getScore() {
        String score = "";
        if (Objects.equals(player1.getPoints(), player2.getPoints()) && player1.getPoints() < 4) {
            score = player1.getScore().getDescription() + "-All";
        }

        if (Objects.equals(player1.getPoints(), player2.getPoints()) && player1.getPoints() >= 3) {
            score = "Deuce";
        }

        if (!Objects.equals(player1.getPoints(), player2.getPoints())) {
            Player winningPlayer = getPlayerWithHigherScore();
            Player losingPlayer = getOpponent(winningPlayer);

            if (winningPlayer.getPoints() < 4) {
                score = player1.getScore().getDescription() + "-" + player2.getScore().getDescription();
            }

            if (losingPlayer.getPoints() >= 3) {
                score = "Advantage " + winningPlayer.getName();
            }

            if (winningPlayer.getPoints() >= 4 && losingPlayer.getPoints() >= 0 && (winningPlayer.getPoints() - losingPlayer.getPoints()) >= 2) {
                score = "Win for " + winningPlayer.getName();
            }
        }

        return score;
    }

    private Player getPlayerWithHigherScore() {
        return players.values().stream()
                .sorted(Comparator.comparingInt(Player::getPoints))
                .toList()
                .get(1);
    }

    private Player getOpponent(Player player) {
        if (player.getOrder() == 1) {
            return players.get(2);
        } else {
            return players.get(1);
        }
    }
}
