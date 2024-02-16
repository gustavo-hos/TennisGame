package me.terato.tennis_game;

public class PointCallConverter {

    public static String convertFromScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "Advantage";
        };
    }

}
