package me.terato.tennis_game;

public class PlayerScore {

    private final Player player;
    private int score;

    public PlayerScore(Player player) {
        this.player = player;
        this.score = 0;
    }

    public Player getPlayer() {
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
}
