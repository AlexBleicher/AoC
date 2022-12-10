package AoC2022.Day10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

    public static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("addx 15\n" +
                        "addx -11\n" +
                        "addx 6\n" +
                        "addx -3\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx -8\n" +
                        "addx 13\n" +
                        "addx 4\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx -35\n" +
                        "addx 1\n" +
                        "addx 24\n" +
                        "addx -19\n" +
                        "addx 1\n" +
                        "addx 16\n" +
                        "addx -11\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 21\n" +
                        "addx -15\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -3\n" +
                        "addx 9\n" +
                        "addx 1\n" +
                        "addx -3\n" +
                        "addx 8\n" +
                        "addx 1\n" +
                        "addx 5\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -36\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx 7\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "addx 6\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 7\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx -13\n" +
                        "addx 13\n" +
                        "addx 7\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx -33\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 8\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 2\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 17\n" +
                        "addx -9\n" +
                        "addx 1\n" +
                        "addx 1\n" +
                        "addx -3\n" +
                        "addx 11\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -13\n" +
                        "addx -19\n" +
                        "addx 1\n" +
                        "addx 3\n" +
                        "addx 26\n" +
                        "addx -30\n" +
                        "addx 12\n" +
                        "addx -1\n" +
                        "addx 3\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -9\n" +
                        "addx 18\n" +
                        "addx 1\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 9\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 2\n" +
                        "addx -37\n" +
                        "addx 1\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "addx 15\n" +
                        "addx -21\n" +
                        "addx 22\n" +
                        "addx -6\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx -10\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 20\n" +
                        "addx 1\n" +
                        "addx 2\n" +
                        "addx 2\n" +
                        "addx -6\n" +
                        "addx -11\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop", 13140),
                Arguments.of("addx 1\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 6\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 5\n" +
                        "addx -14\n" +
                        "noop\n" +
                        "addx 19\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx 4\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx -27\n" +
                        "addx 20\n" +
                        "addx -30\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx 4\n" +
                        "addx -3\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx -9\n" +
                        "addx 1\n" +
                        "addx 11\n" +
                        "noop\n" +
                        "addx -20\n" +
                        "addx 7\n" +
                        "addx 23\n" +
                        "addx 2\n" +
                        "addx 3\n" +
                        "addx -2\n" +
                        "addx -34\n" +
                        "addx -2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx -9\n" +
                        "addx -7\n" +
                        "addx 21\n" +
                        "noop\n" +
                        "addx 8\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 3\n" +
                        "addx -2\n" +
                        "addx 5\n" +
                        "addx -37\n" +
                        "noop\n" +
                        "addx 35\n" +
                        "addx -31\n" +
                        "addx 1\n" +
                        "addx 4\n" +
                        "addx -1\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "addx 1\n" +
                        "addx 5\n" +
                        "addx -2\n" +
                        "addx 7\n" +
                        "addx -2\n" +
                        "addx -2\n" +
                        "addx 10\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -19\n" +
                        "addx 20\n" +
                        "addx -38\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 7\n" +
                        "addx 2\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "addx -3\n" +
                        "addx 2\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 5\n" +
                        "noop\n" +
                        "addx 7\n" +
                        "addx -2\n" +
                        "addx 7\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -5\n" +
                        "addx 6\n" +
                        "addx -36\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx 3\n" +
                        "addx -2\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "addx -16\n" +
                        "addx 21\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx -8\n" +
                        "addx 12\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop", 0)
        );
    }

    public static Stream<Arguments> task2() {
        return Stream.of(
                Arguments.of("addx 15\n" +
                        "addx -11\n" +
                        "addx 6\n" +
                        "addx -3\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx -8\n" +
                        "addx 13\n" +
                        "addx 4\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "addx -1\n" +
                        "addx -35\n" +
                        "addx 1\n" +
                        "addx 24\n" +
                        "addx -19\n" +
                        "addx 1\n" +
                        "addx 16\n" +
                        "addx -11\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 21\n" +
                        "addx -15\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -3\n" +
                        "addx 9\n" +
                        "addx 1\n" +
                        "addx -3\n" +
                        "addx 8\n" +
                        "addx 1\n" +
                        "addx 5\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -36\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx 7\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "addx 6\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 7\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx -13\n" +
                        "addx 13\n" +
                        "addx 7\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx -33\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 8\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 2\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 17\n" +
                        "addx -9\n" +
                        "addx 1\n" +
                        "addx 1\n" +
                        "addx -3\n" +
                        "addx 11\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -13\n" +
                        "addx -19\n" +
                        "addx 1\n" +
                        "addx 3\n" +
                        "addx 26\n" +
                        "addx -30\n" +
                        "addx 12\n" +
                        "addx -1\n" +
                        "addx 3\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -9\n" +
                        "addx 18\n" +
                        "addx 1\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 9\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 2\n" +
                        "addx -37\n" +
                        "addx 1\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "addx 15\n" +
                        "addx -21\n" +
                        "addx 22\n" +
                        "addx -6\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx -10\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 20\n" +
                        "addx 1\n" +
                        "addx 2\n" +
                        "addx 2\n" +
                        "addx -6\n" +
                        "addx -11\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop", "##..##..##..##..##..##..##..##..##..##..\n" +
                        "###...###...###...###...###...###...###.\n" +
                        "####....####....####....####....####....\n" +
                        "#####.....#####.....#####.....#####.....\n" +
                        "######......######......######......####\n" +
                        "#######.......#######.......#######....."),
                Arguments.of("addx 1\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 6\n" +
                        "addx -1\n" +
                        "addx 5\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 5\n" +
                        "addx -14\n" +
                        "noop\n" +
                        "addx 19\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx 4\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx -27\n" +
                        "addx 20\n" +
                        "addx -30\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx 4\n" +
                        "addx -3\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx -9\n" +
                        "addx 1\n" +
                        "addx 11\n" +
                        "noop\n" +
                        "addx -20\n" +
                        "addx 7\n" +
                        "addx 23\n" +
                        "addx 2\n" +
                        "addx 3\n" +
                        "addx -2\n" +
                        "addx -34\n" +
                        "addx -2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx -9\n" +
                        "addx -7\n" +
                        "addx 21\n" +
                        "noop\n" +
                        "addx 8\n" +
                        "noop\n" +
                        "addx -1\n" +
                        "addx 3\n" +
                        "addx -2\n" +
                        "addx 5\n" +
                        "addx -37\n" +
                        "noop\n" +
                        "addx 35\n" +
                        "addx -31\n" +
                        "addx 1\n" +
                        "addx 4\n" +
                        "addx -1\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "addx 1\n" +
                        "addx 5\n" +
                        "addx -2\n" +
                        "addx 7\n" +
                        "addx -2\n" +
                        "addx -2\n" +
                        "addx 10\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -19\n" +
                        "addx 20\n" +
                        "addx -38\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 7\n" +
                        "addx 2\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "addx -3\n" +
                        "addx 2\n" +
                        "addx 2\n" +
                        "noop\n" +
                        "addx 3\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 5\n" +
                        "noop\n" +
                        "addx 7\n" +
                        "addx -2\n" +
                        "addx 7\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx -5\n" +
                        "addx 6\n" +
                        "addx -36\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx 3\n" +
                        "addx -2\n" +
                        "addx 2\n" +
                        "addx 5\n" +
                        "addx 2\n" +
                        "addx 1\n" +
                        "noop\n" +
                        "addx 4\n" +
                        "addx -16\n" +
                        "addx 21\n" +
                        "noop\n" +
                        "noop\n" +
                        "addx 1\n" +
                        "addx -8\n" +
                        "addx 12\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop\n" +
                        "noop", "")
        );
    }

    @ParameterizedTest
    @MethodSource
    public void task1(String input, long expected) {
        Day10 testObject = new Day10(input);
        long result = testObject.task1();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource
    public void task2(String input, String expected) {
        Day10 testObject = new Day10(input);
        String result = testObject.task2();

        assertEquals(expected, result);
    }
}