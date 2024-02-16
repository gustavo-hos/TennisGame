package me.terato.tennis_game;

import me.terato.tennis_game.score.PlayerScore;
import me.terato.tennis_game.score.ScoreSystem;
import me.terato.tennis_game.score.display.ScoreDisplay;
import me.terato.tennis_game.score.display.StdOutScoreDisplay;

public class Game {

    private final ScoreDisplay scoreDisplay;
    private final ScoreSystem scoreSystem;
    private boolean gameEnded;

    public Game() {
        var p1 = new PlayerScore("A");
        var p2 = new PlayerScore("B");
        this.scoreSystem = new ScoreSystem(p1, p2);
        this.scoreDisplay = new StdOutScoreDisplay(scoreSystem);

    }

    public void playPoint(String input) {
        scoreSystem.winPoint(input);

        if(scoreSystem.checkWinner() != null) {
            scoreDisplay.displayWinner();
            this.gameEnded = true;

            return;
        }

        scoreDisplay.displayScore();

        if(scoreSystem.isDeuce())
            scoreDisplay.displayDeuce();
    }

    public ScoreSystem getScoreSystem() {
        return scoreSystem;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
}
