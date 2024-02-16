package me.terato.tennis_game;

import me.terato.tennis_game.exception.InvalidGameInputException;

import java.util.Scanner;

public class GamePlayground {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var game = new Game();

        while (game.isGameEnded()) {
            String input = scanner.nex
        }
    }

    private boolean validInput(String input) throws InvalidGameInputException {
        if(input == null || input.length() != 1 ||
                (!input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("B")))
            throw new InvalidGameInputException(input + " is not a valid input.");

        return true;
    }
}
