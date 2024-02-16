package me.terato.tennis_game.score.display;

import static me.terato.tennis_game.PointCallConverter.convertFromScore;
import me.terato.tennis_game.score.PlayerScore;
import me.terato.tennis_game.score.ScoreSystem;

public class StdOutScoreDisplay implements ScoreDisplay {

    private final ScoreSystem scoreSystem;

    public StdOutScoreDisplay(ScoreSystem scoreSystem) {
        this.scoreSystem = scoreSystem;
    }

    @Override
    public void displayWinner() {
        System.out.printf("Player %s wins the game!%n%n", scoreSystem.checkWinner());
    }

    @Override
    public void displayDeuce() {
        System.out.println("Deuce!");
    }

    @Override
    public void displayScore() {
        PlayerScore p1Score = scoreSystem.playerOne();
        PlayerScore p2Score = scoreSystem.playerTwo();

        System.out.printf("Player %s: %s / Player %s: %s%n", p1Score.getPlayer(), convertFromScore(p1Score.getScore()),
                p2Score.getPlayer(), convertFromScore(p2Score.getScore()));
    }
}
