package me.terato.tennis_game;

import me.terato.tennis_game.exception.InvalidGameInputException;

import java.util.Scanner;

public class TennisGame {



    public static void main(String[] args) {
        var tennisGame = new TennisGame();

        // normal win without deuce or advantage
        tennisGame.play("ABABAA");
        tennisGame.play("BABABB");

        // Player A should win with advantage, because there is a deuce
        tennisGame.play("AAABBBABAA");

        // This represents a valid match yet invalid input, as the sequence of 'BBBB' has won the game before
        // AAA could be executed, so there is nothing else to play.
        tennisGame.play("BBBBAAABB");

        // wrong input, should throw exception
        tennisGame.play("CDCDCC");

        // For more testing scenarios, please check TestTennisGame class.

        // type your own input :)
        tennisGame.play();
    }

    public void play() {
        var scanner = new Scanner(System.in);
        var game = new Game("A", "B");

        System.out.println("Insert A or B to play.");

        while (!game.isGameEnded()) {

            var input = scanner.next();

            try {
                game.playSinglePoint(input.toUpperCase());
            } catch (InvalidGameInputException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public void play(String input) {

        try {
            var game = new Game("A", "B");
            game.playMultiplePoints(input);
        } catch (InvalidGameInputException e) {
            System.err.println(e.getMessage());
        }

    }
}
