package me.terato.tennis_game.score.display;

import me.terato.tennis_game.score.PlayerScore;
import me.terato.tennis_game.score.ScoreSystem;

public interface ScoreDisplay {

    void displayScore();
    void displayWinner();
    void displayDeuce();
}
