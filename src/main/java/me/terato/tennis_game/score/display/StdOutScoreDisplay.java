package me.terato.tennis_game;

public class StdOutScoreDisplay implements ScoreDisplay {

    @Override
    public void display(ScoreSystem scoreSystem) {
        PlayerScore p1Score = scoreSystem.getPlayerOne();
        PlayerScore p2Score = scoreSystem.getPlayerTwo();

        System.out.printf("%s: %d / %s: %d%n", p1Score.getPlayer().name(), p1Score.getScore(),
                p2Score.getPlayer().name(), p2Score.getScore());
    }
}
