package me.terato.tennis_game;

import me.terato.tennis_game.exception.InvalidGameInputException;
import me.terato.tennis_game.score.PlayerScore;
import me.terato.tennis_game.score.ScoreSystem;
import me.terato.tennis_game.score.display.ScoreDisplay;
import me.terato.tennis_game.score.display.StdOutScoreDisplay;

public class Game {

    private final ScoreDisplay scoreDisplay;
    private final ScoreSystem scoreSystem;
    private boolean gameEnded;

    public Game(String p1Name, String p2name) {
        var p1 = new PlayerScore(p1Name);
        var p2 = new PlayerScore(p2name);
        this.scoreSystem = new ScoreSystem(p1, p2);
        this.scoreDisplay = new StdOutScoreDisplay(scoreSystem);
    }

    public void playSinglePoint(String input) throws InvalidGameInputException {
        if(isGameEnded())
            return;

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

    public void playMultiplePoints(String input) throws InvalidGameInputException {
        for (char move : input.toCharArray()) {
            if(isGameEnded())
                throw new InvalidGameInputException("Game ended before finishing the given plays. Input: " + input);

            playSinglePoint(String.valueOf(move));
        }
    }

    public ScoreSystem getScoreSystem() {
        return scoreSystem;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
}
