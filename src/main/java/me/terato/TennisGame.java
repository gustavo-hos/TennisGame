package me.terato;

public class TennisGame {
    public static void main(String[] args) {
        var tennisGame = new TennisGame();

        tennisGame.play("ABABAB");
    }

    public String play(String input) {
        int player1 = 0;
        int player2 = 0;

        for (char move : input.toCharArray()) {
            if (move == 'A') {
                player1++;
            } else if (move == 'B') {
                player2++;
            }

            if(player1 <= 3 && player2 <= 3)
                System.out.printf("Player A : %d / Player B : %d%n", calculateWonPoints(player1), calculateWonPoints(player2));

            if (player1 >= 3 && player2 >= 3 && Math.abs(player1 - player2) == 1) {
                if (player1 > player2) {
                    System.out.println("Player A is in advantage");
                } else {
                    System.out.println("Player B is in advantage");
                }
            }
        }

        if (player1 > player2) {
            System.out.println("Player A wins the game!");
            return "A";
        } else if (player2 > player1){
            System.out.println("Player B wins the game!");
            return "B";
        } else {
            throw new RuntimeException("Invalid game, no winners!");
        }
    }

    private int calculateWonPoints(int actualScore) {
        return switch (actualScore) {
            case 0 -> 0;
            case 1 -> 15;
            case 2 -> 30;
            case 3 -> 40;
            default -> 40 + (actualScore - 3);
        };
    }
}