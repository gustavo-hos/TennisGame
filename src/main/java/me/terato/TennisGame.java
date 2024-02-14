package me.terato;

public class TennisGame {
    private int p1Score;

    private int p2Score;

    private boolean isGameFinished;

    public TennisGame() {
        resetScore();
    }

    public void resetScore() {
        this.p1Score = 0;
        this.p2Score = 0;
        isGameFinished = false;
    }

    public void play(String input) {
        if(isGameFinished)
            throw new IllegalStateException("Please, reset the score before playing again!");

        for (char currentPlayer : input.toCharArray()) {
            updateScores(currentPlayer);
            printCurrentScore();
            checkIsDeuce();
            checkIsAdvantage();
        }

        printWinner();
    }

    private void updateScores(char move) {
        if (move == 'A') {
            p1Score++;
        } else if (move == 'B') {
            p2Score++;
        }
    }

    private void printCurrentScore() {
        // following the example in README, it's not supposed to
        // print the scores when players are in advantage of points.
        // also, we could use calculateWonPoints(player1) <= 40 && calculateWonPoints(player2) <= 40
        if(p1Score <= 3 && p2Score <= 3)
            System.out.printf("Player A : %s / Player B : %s%n", calculateWonPoints(p1Score), calculateWonPoints(p2Score));
    }

    private void checkIsDeuce() {
        if (p1Score >= 3 && p2Score >= 3 && p1Score == p2Score) {
            System.out.println("The game is in Deuce!");
        }
    }

    private void checkIsAdvantage() {
        if (p1Score >= 3 && p2Score >= 3 && Math.abs(p1Score - p2Score) == 1) {
            if (p1Score > p2Score) {
                System.out.println("Player A is in advantage");
            } else {
                System.out.println("Player B is in advantage");
            }
        }
    }

    private void printWinner() {
        if (p1Score > p2Score) {
            System.out.println("Player A wins the game!\n");
        } else if (p2Score > p1Score){
            System.out.println("Player B wins the game!\n");
        } else {
            System.out.println("No winners.\n");
        }

        isGameFinished = true;
    }

    private int calculateWonPoints(int score) {
        return switch (score) {
            case 0 -> 0;
            case 1 -> 15;
            case 2 -> 30;
            case 3 -> 40;
            default -> 40 + (score - 3);
        };
    }

}