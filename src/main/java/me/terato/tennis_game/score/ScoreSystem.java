package me.terato.tennis_game.score;

public record ScoreSystem(PlayerScore playerOne, PlayerScore playerTwo) {

    public void winPoint(String player) {
        var pAdvantage = checkAdvantage();

        if (this.playerOne.getPlayer().equals(player)) {
            this.playerOne.increaseScore();

            if(pAdvantage != null && pAdvantage.equals(playerTwo.getPlayer()))
                this.playerTwo.decreaseScore();

        } else {
            this.playerTwo.increaseScore();

            if(pAdvantage != null && pAdvantage.equals(playerOne.getPlayer()))
                this.playerOne.decreaseScore();
        }
    }

    public boolean isDeuce() {
        int serverScore = playerOne().getScore();
        int receiverScore = playerTwo().getScore();

        return serverScore >= 3 && serverScore == receiverScore;
    }

    public String checkAdvantage() {
        return checkScore(1);
    }

    public String checkWinner() {
        return checkScore(2);
    }

    private String checkScore(int scoreDiff) {
        int p1Score = playerOne().getScore();
        int p2Score = playerTwo().getScore();

        if ((p1Score > 3 || p2Score > 3) && Math.abs(p1Score - p2Score) == scoreDiff) {
            return (p1Score > p2Score) ? playerOne().getPlayer() : playerTwo().getPlayer();
        }

        return null;
    }

    private void updatePlayerScore(String player) {
        if (this.playerOne.getPlayer().equals(player)) {
            this.playerOne.increaseScore();
        } else {
            this.playerTwo.increaseScore();
        }
    }

    private void handleAdvantage(String player) {
        String pAdvantage = checkAdvantage();
        if (pAdvantage != null) {
            if (pAdvantage.equals(playerOne.getPlayer()) && this.playerTwo.getScore() > 0) {
                this.playerTwo.decreaseScore();
            } else if (pAdvantage.equals(playerTwo.getPlayer()) && this.playerOne.getScore() > 0) {
                this.playerOne.decreaseScore();
            }
        }
    }
}
