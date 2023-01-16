import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BowlingTest {

    @ParameterizedTest()
    @MethodSource("provideStringsForBowlingTest")
    public void bowlingTest(String game, Integer expected){
        Integer actual = Bowling.bowlingGame(game);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForBowlingTest() {
        return Stream.of(
                Arguments.of("X X X X X X X X X X X X", 300),
                Arguments.of("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-", 90),
                Arguments.of("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5", 150)
                );
    }
}
