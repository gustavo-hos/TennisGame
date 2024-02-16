package me.terato.tennis_game.score;

public class PlayerScore {

    private final String player;
    private int score;

    public PlayerScore(String player) {
        this.player = player;
        this.score = 0;
    }

    public String getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score++;
    }

    public void decreaseScore() {
        this.score--;
    }

    @Override
    public String toString() {
        return "PlayerScore{" +
                "player='" + player + '\'' +
                ", score=" + score +
                '}';
    }
}
