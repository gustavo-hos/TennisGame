package me.terato.tennis_game;

import me.terato.tennis_game.Player;
import me.terato.tennis_game.PlayerScore;

public class ScoreSystem {

    private final PlayerScore playerOne;
    private final PlayerScore playerTwo;

    public ScoreSystem(PlayerScore playerOne, PlayerScore playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void winPoint(Player player) {
        if(this.playerOne.getPlayer().equals(player))
            this.playerOne.increaseScore();
        else
            this.playerTwo.increaseScore();
    }

    public PlayerScore getPlayerOne() {
        return playerOne;
    }

    public PlayerScore getPlayerTwo() {
        return playerTwo;
    }

}
