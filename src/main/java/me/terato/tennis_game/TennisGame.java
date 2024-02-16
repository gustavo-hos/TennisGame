package me.terato.tennis_game;

import me.terato.tennis_game.exception.InvalidGameInputException;

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
            try {
                var input = scanner.next();
                validInput(input);

                game.playPoint(input);

            } catch (InvalidGameInputException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private boolean validInput(String input) throws InvalidGameInputException {
        if(input == null || input.length() != 1 ||
                (!input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("B")))
            throw new InvalidGameInputException(input + " is not a valid input.");

        return true;
    }
}
