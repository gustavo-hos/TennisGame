package me.terato.tennis_game;

import me.terato.tennis_game.scoring.ScoreSystem;

public abstract class AbstractGame {

    private final ScoreSystem scoreSystem;

    public AbstractGame(ScoreSystem scoreSystem) {
        this.scoreSystem = scoreSystem;
    }

    public ScoreSystem getScoreSystem() {
        return scoreSystem;
    }

    public abstract Player checkWinner();

    public void winPoint() {

    }

    public boolean isDeuce() {
        int serverScore = getScoreSystem().getPlayerOne().getScore();
        int receiverScore = getScoreSystem().getPlayerTwo().getScore();

        return serverScore >= 3 && serverScore == receiverScore;
    }

}
