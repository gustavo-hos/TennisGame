package me.terato.tennis_game.score;

public record ScoreSystem(PlayerScore playerOne, PlayerScore playerTwo) {

    private static final int ADVANTAGE_DIFFERENCE = 1;
    private static final int WINNER_DIFFERENCE = 2;
    private static final int POINTS_TO_DEUCE = 3;
    private static final int POINTS_TO_WIN = 4;

    public void winPoint(String player) {
        var pAdvantage = checkAdvantage();

        if (this.playerOne.getPlayer().equals(player)) {
            this.playerOne.increaseScore();

            if (pAdvantage != null && pAdvantage.equals(playerTwo().getPlayer()) && playerTwo().getScore() > POINTS_TO_DEUCE)
                playerTwo.decreaseScore();

        } else {
            this.playerTwo.increaseScore();

            if (pAdvantage != null && pAdvantage.equals(playerOne().getPlayer()) && playerOne().getScore() > POINTS_TO_DEUCE)
                playerOne.decreaseScore();
        }
    }

    public boolean isDeuce() {
        int p1 = playerOne().getScore();
        int p2 = playerTwo().getScore();

        return p1 >= POINTS_TO_DEUCE && p1 == p2;
    }

    public String checkAdvantage() {
        return checkScore(ADVANTAGE_DIFFERENCE);
    }

    public String checkWinner() {
        if(playerOne().getScore() >= POINTS_TO_DEUCE && playerTwo().getScore() >= POINTS_TO_DEUCE)
            return checkScore(WINNER_DIFFERENCE);

        if (playerOne().getScore() == POINTS_TO_WIN && playerTwo().getScore() < POINTS_TO_DEUCE) {
            return playerOne().getPlayer();
        } else if (playerTwo().getScore() == POINTS_TO_WIN && playerOne().getScore() < POINTS_TO_DEUCE) {
            return playerTwo().getPlayer();
        }

        return null;
    }

    private String checkScore(int scoreDiff) {
        int p1Score = playerOne().getScore();
        int p2Score = playerTwo().getScore();

        if ((p1Score > POINTS_TO_DEUCE || p2Score > POINTS_TO_DEUCE) && Math.abs(p1Score - p2Score) == scoreDiff) {
            return (p1Score > p2Score) ? playerOne().getPlayer() : playerTwo().getPlayer();
        }

        return null;
    }
}
