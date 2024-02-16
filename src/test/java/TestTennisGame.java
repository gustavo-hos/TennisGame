import me.terato.tennis_game.Game;
import me.terato.tennis_game.exception.InvalidGameInputException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


import java.lang.reflect.Array;
import java.lang.reflect.Field;


/**
 * In this project, I will be employing Test-Driven Development (TDD)
 * to enhance the efficiency and reliability of the code
 */
public class TestTennisGame {

    static final String[] TEST_SCENARIO_1 = {"ABABAA", "A"}; // PLAYER 1 SHOULD WIN;
    static final String[] TEST_SCENARIO_2 = {"AABBAA", "A"}; // PLAYER 1 SHOULD WIN;
    static final String[] TEST_SCENARIO_3 = {"AAABBA", "A"}; // PLAYER 1 SHOULD WIN;
    static final String[] TEST_SCENARIO_4 = {"BABABB", "B"}; // PLAYER 2 SHOULD WIN;
    static final String[] TEST_SCENARIO_5 = {"BABBAB", "B"}; // PLAYER 2 SHOULD WIN;
    static final String[] TEST_SCENARIO_6 = {"BBABAB", "B"}; // PLAYER 2 SHOULD WIN;
    static final String[] TEST_SCENARIO_7 = {"ABABABBABABABB", "B"}; // SIMULATING A DEUCE - B IS IN ADVANTAGE - PLAYER 2 SHOULD WIN;
    static final String[] TEST_SCENARIO_8 = {"ABABABABABABAA", "A"}; // SIMULATING A DEUCE - A IS IN ADVANTAGE - PLAYER 1 SHOULD WIN;
    static final String[] TEST_SCENARIO_9 = {"AAABBBAA", "A"}; // SIMULATING A DEUCE - PLAYER 1 SHOULD WIN;
    static final String[] TEST_SCENARIO_10 = {"BBBAAABB", "B"}; // SIMULATING A DEUCE - PLAYER 2 SHOULD WIN;

    @Test
    public void testTennisGame() throws IllegalAccessException, InvalidGameInputException {
        Field[] fields = TestTennisGame.class.getDeclaredFields();

        for (Field f : fields) {
            var game = new Game("A", "B");

            String input = String.valueOf(Array.get(f.get(null), 0));
            String expected = String.valueOf(Array.get(f.get(null), 1));

            game.playMultiplePoints(input);

            assertThat("Player " + expected + " should win this game.", expected, is(game.getScoreSystem().checkWinner()));
        }
    }

    @Test
    public void testTennisGameWrongInput() {

        assertThrows(InvalidGameInputException.class, () -> {
            var game = new Game("A", "B");
            game.playMultiplePoints("@#@#)$*DFJ");
        }, "Invalid input with special characters should throw InvalidGameInputException");

        assertThrows(InvalidGameInputException.class, () -> {
            var game = new Game("A", "B");
            game.playMultiplePoints("123123)ASIDJASID");
        }, "Invalid input with numbers should throw InvalidGameInputException");

    }
}
