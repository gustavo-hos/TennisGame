import me.terato.TennisGame;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * In this project, I will be employing Test-Driven Development (TDD)
 * to enhance the efficiency and reliability of the code
 * <br>
 * This class is designed to test the output produced by the application.
 * Therefore, any changes to the output strings in the code will cause the
 * test to fail. In this example, since the method is a void method, we
 * typically test the program flow (whether the parameters have been passed
 * correctly) rather than the output produced by the method.
 */
public class TestTennisGame {

    static final String[] TEST_SCENARIO_1 = {"ABABAA", """
            Player A : 15 / Player B : 0
            Player A : 15 / Player B : 15
            Player A : 30 / Player B : 15
            Player A : 30 / Player B : 30
            Player A : 40 / Player B : 30
            Player A wins the game!"""};

    static final String[] TEST_SCENARIO_2 = {"AABBAA", """
            Player A : 15 / Player B : 0
            Player A : 30 / Player B : 0
            Player A : 30 / Player B : 15
            Player A : 30 / Player B : 30
            Player A : 40 / Player B : 30
            Player A wins the game!"""};

    static final String[] TEST_SCENARIO_3 = {"AAABBA", """
            Player A : 15 / Player B : 0
            Player A : 30 / Player B : 0
            Player A : 40 / Player B : 0
            Player A : 40 / Player B : 15
            Player A : 40 / Player B : 30
            Player A wins the game!"""};

    static final String[] TEST_SCENARIO_4 = {"BABABB", """
            Player A : 0 / Player B : 15
            Player A : 15 / Player B : 15
            Player A : 15 / Player B : 30
            Player A : 30 / Player B : 30
            Player A : 30 / Player B : 40
            Player B wins the game!"""};

    static final String[] TEST_SCENARIO_5 = {"BABBAB", """
            Player A : 0 / Player B : 15
            Player A : 15 / Player B : 15
            Player A : 15 / Player B : 30
            Player A : 15 / Player B : 40
            Player A : 30 / Player B : 40
            Player B wins the game!"""};

    static final String[] TEST_SCENARIO_6 = {"BBABAB", """
            Player A : 0 / Player B : 15
            Player A : 0 / Player B : 30
            Player A : 15 / Player B : 30
            Player A : 15 / Player B : 40
            Player A : 30 / Player B : 40
            Player B wins the game!"""};

    static final String[] TEST_SCENARIO_7 = {"ABABABBABABABB", """
            Player A : 15 / Player B : 0
            Player A : 15 / Player B : 15
            Player A : 30 / Player B : 15
            Player A : 30 / Player B : 30
            Player A : 40 / Player B : 30
            Player A : 40 / Player B : 40
            The game is in Deuce!
            Player B is in advantage
            The game is in Deuce!
            Player B is in advantage
            The game is in Deuce!
            Player B is in advantage
            The game is in Deuce!
            Player B is in advantage
            Player B wins the game!"""};

    static final String[] TEST_SCENARIO_8 = {"ABABABABABABAA", """
            Player A : 15 / Player B : 0
            Player A : 15 / Player B : 15
            Player A : 30 / Player B : 15
            Player A : 30 / Player B : 30
            Player A : 40 / Player B : 30
            Player A : 40 / Player B : 40
            The game is in Deuce!
            Player A is in advantage
            The game is in Deuce!
            Player A is in advantage
            The game is in Deuce!
            Player A is in advantage
            The game is in Deuce!
            Player A is in advantage
            Player A wins the game!"""};

    static final String[] TEST_SCENARIO_9 = {"AAABBBAA", """
            Player A : 15 / Player B : 0
            Player A : 30 / Player B : 0
            Player A : 40 / Player B : 0
            Player A : 40 / Player B : 15
            Player A : 40 / Player B : 30
            Player A : 40 / Player B : 40
            The game is in Deuce!
            Player A is in advantage
            Player A wins the game!"""};

    static final String[] TEST_SCENARIO_10 = {"BBBAAABB", """
            Player A : 0 / Player B : 15
            Player A : 0 / Player B : 30
            Player A : 0 / Player B : 40
            Player A : 15 / Player B : 40
            Player A : 30 / Player B : 40
            Player A : 40 / Player B : 40
            The game is in Deuce!
            Player B is in advantage
            Player B wins the game!"""};

    @Test
    public void testTennisGameScenario1() throws IllegalAccessException {
        Field[] fields = TestTennisGame.class.getDeclaredFields();

        int testScenario = 1;
        for (Field f : fields) {
            String input = String.valueOf(Array.get(f.get(null), 0));
            String expectedOutput = String.valueOf(Array.get(f.get(null), 1));

            System.err.println(testScenario + "# test scenario: check if game produces the following result ->\n" + expectedOutput);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            TennisGame game = new TennisGame();
            game.play(input);

            assertThat(outContent.toString(), containsString(expectedOutput));

            System.setOut(System.out);

            testScenario++;
        }

    }

}
