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
        var p1Score = playerOne().getScore();
        var p2Score = playerTwo().getScore();

        return p1Score >= POINTS_TO_DEUCE && p1Score == p2Score;
    }

    public String checkAdvantage() {
        return checkScore(ADVANTAGE_DIFFERENCE);
    }

    public String checkWinner() {
        var p1Score = playerOne().getScore();
        var p2Score = playerTwo().getScore();

        if(p1Score >= POINTS_TO_DEUCE && p2Score >= POINTS_TO_DEUCE)
            return checkScore(WINNER_DIFFERENCE);

        if (p1Score == POINTS_TO_WIN) {
            return playerOne().getPlayer();
        } else if (p2Score == POINTS_TO_WIN) {
            return playerTwo().getPlayer();
        }

        return null;
    }

    private String checkScore(int scoreDiff) {
        var p1Score = playerOne().getScore();
        var p2Score = playerTwo().getScore();

        if ((p1Score > POINTS_TO_DEUCE || p2Score > POINTS_TO_DEUCE) && Math.abs(p1Score - p2Score) == scoreDiff) {
            return (p1Score > p2Score) ? playerOne().getPlayer() : playerTwo().getPlayer();
        }

        return null;
    }
}
