package AoC2018.Day14.Task1;

import AoC2018.Day14.Day14;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {

    @ParameterizedTest
    @MethodSource
    void part1(int input, String expectedResult) {
        Day14 testObject = new Day14();
        String testResult = testObject.part1(input);

        assertEquals(expectedResult, testResult);
    }

    static Stream<Arguments> part1() {
        return Stream.of(
                Arguments.of(9, "5158916779"),
                Arguments.of(5, "0124515891"),
                Arguments.of(18, "9251071085"),
                Arguments.of(2018, "5941429882"),
                Arguments.of(440231, "")
        );
    }

    @ParameterizedTest
    @MethodSource
    void part2(String input, int expectedResult) {
        Day14 testObject = new Day14();
        int testResult = testObject.part2(input);

        assertEquals(expectedResult, testResult);
    }

    static Stream<Arguments> part2() {
        return Stream.of(
                Arguments.of("51589", 9),
                Arguments.of("01245", 5),
                Arguments.of("92510", 18),
                Arguments.of("59414", 2018),
                Arguments.of("440231", 0)

        );
    }
}
