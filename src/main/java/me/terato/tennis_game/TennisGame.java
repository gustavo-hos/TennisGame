package me.terato.tennis_game;

import java.util.Scanner;

public class TennisGame {

    public static void main(String[] args) {
        var tennisGame = new TennisGame();

        tennisGame.play();
    }

    public void play() {
        var scanner = new Scanner(System.in);
        var game = new Game();

        System.out.println("Insert A or B to play.");

        while (!game.isGameEnded()) {

            var input = scanner.next();
            if (validInput(input))
                game.playPoint(input.toUpperCase());
            else
                System.err.println(input + " is not a valid input.");

        }
    }

    private boolean validInput(String input) {
        return input != null && input.length() == 1 &&
                (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B"));
    }
}
