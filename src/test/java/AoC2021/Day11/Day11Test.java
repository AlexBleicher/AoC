package AoC2021.Day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    @ParameterizedTest
    @MethodSource
    void task1(String input, int expectedResult) {
        Day11 testObject = new Day11(input);
        int result = testObject.task1();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("5483143223\n" +
                        "2745854711\n" +
                        "5264556173\n" +
                        "6141336146\n" +
                        "6357385478\n" +
                        "4167524645\n" +
                        "2176841721\n" +
                        "6882881134\n" +
                        "4846848554\n" +
                        "5283751526", 1656),
                Arguments.of("5421451741\n" +
                        "3877321568\n" +
                        "7583273864\n" +
                        "3451717778\n" +
                        "2651615156\n" +
                        "6377167526\n" +
                        "5182852831\n" +
                        "4766856676\n" +
                        "3437187583\n" +
                        "3633371586", 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void task2(String input, int expectedResult) {
        Day11 testObject = new Day11(input);
        int result = testObject.task2();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task2() {
        return Stream.of(
                Arguments.of("5483143223\n" +
                        "2745854711\n" +
                        "5264556173\n" +
                        "6141336146\n" +
                        "6357385478\n" +
                        "4167524645\n" +
                        "2176841721\n" +
                        "6882881134\n" +
                        "4846848554\n" +
                        "5283751526", 195),
                Arguments.of("5421451741\n" +
                        "3877321568\n" +
                        "7583273864\n" +
                        "3451717778\n" +
                        "2651615156\n" +
                        "6377167526\n" +
                        "5182852831\n" +
                        "4766856676\n" +
                        "3437187583\n" +
                        "3633371586", 0)
        );
    }

}