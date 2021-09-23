package AoC2019.Day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    @ParameterizedTest
    @MethodSource
    void task1(String input, int expectedResult) {
        Day4 testObject = new Day4(input);
        int testResult = testObject.task1();

        assertEquals(expectedResult, testResult);
    }

    public static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("153517-630395", 1729)
        );
    }

    @ParameterizedTest
    @MethodSource
    void task2(String input, int expectedResult) {
        Day4 testObject = new Day4(input);
        int testResult = testObject.task2();

        assertEquals(expectedResult, testResult);
    }

    public static Stream<Arguments> task2() {
        return Stream.of(
                Arguments.of("153517-630395", 1172)
        );
    }
}