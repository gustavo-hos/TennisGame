package me.terato;

public class Main {

    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();

        tennisGame.play("ABABAA");
        tennisGame.resetScore();

        tennisGame.play("AABBAA");
        tennisGame.resetScore();

        tennisGame.play("AAABBA");
        tennisGame.resetScore();

        tennisGame.play("BABABB");
        tennisGame.resetScore();

        tennisGame.play("BABBAB");
        tennisGame.resetScore();

        tennisGame.play("BBABAB");
        tennisGame.resetScore();

        tennisGame.play("ABABABBABABABB");
        tennisGame.resetScore();

        tennisGame.play("ABABABABABABAA");
        tennisGame.resetScore();

        tennisGame.play("AAABBBAA");
        tennisGame.resetScore();

        tennisGame.play("BBBAAABB");
        tennisGame.resetScore();
    }
}
