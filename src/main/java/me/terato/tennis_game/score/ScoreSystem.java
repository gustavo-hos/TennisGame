package me.terato.tennis_game.score;

public record ScoreSystem(PlayerScore playerOne, PlayerScore playerTwo) {

    private static final int ADVANTAGE_DIFFERENCE = 1;
    private static final int WINNER_DIFFERENCE = 2;
    private static final int POINTS_TO_DEUCE = 3;
    private static final int POINTS_TO_WIN = 4;

    public void winPoint(String player) {
        updatePlayersScore(player);
        handleAdvantage();
    }

    public boolean isDeuce() {
        int serverScore = playerOne().getScore();
        int receiverScore = playerTwo().getScore();

        return serverScore == POINTS_TO_DEUCE && serverScore == receiverScore;
    }

    public String checkAdvantage() {
        return isDeuce() ? checkScore(ADVANTAGE_DIFFERENCE) : null; // To be in advantage, only a one-point difference is necessary.
    }

    public String checkWinner() {
        if(isDeuce())
            return checkScore(WINNER_DIFFERENCE); // To be the winner, only a two-point difference is necessary, in case of deuce.

        if(playerOne().getScore() == POINTS_TO_WIN)
            return playerOne().getPlayer();
        else if(playerTwo().getScore() == POINTS_TO_WIN)
            return playerTwo().getPlayer();

        return null;
    }

    private String checkScore(int scoreDiff) {
        int p1Score = playerOne().getScore();
        int p2Score = playerTwo().getScore();

        if ((p1Score > 3 || p2Score > 3) && Math.abs(p1Score - p2Score) == scoreDiff) {
            return (p1Score > p2Score) ? playerOne().getPlayer() : playerTwo().getPlayer();
        }

        return null;
    }

    private void updatePlayersScore(String player) {
        if (this.playerOne.getPlayer().equals(player))
            this.playerOne.increaseScore();
        else
            this.playerTwo.increaseScore();
    }

    private void handleAdvantage() {
        String pAdvantage = checkAdvantage();
        if (pAdvantage != null) {
            if (pAdvantage.equals(playerOne().getPlayer())) {
                playerTwo.decreaseScore();
            } else if (pAdvantage.equals(playerTwo().getPlayer())) {
                playerOne.decreaseScore();
            }
        }
    }
}
