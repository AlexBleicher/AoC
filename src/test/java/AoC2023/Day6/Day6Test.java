package AoC2023.Day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    static Stream<Arguments> task1() {
        return Stream.of(Arguments.of("Time:      7  15   30\n" +
                        "Distance:  9  40  200", 288),
                Arguments.of("Time:        40     70     98     79\n" +
                        "Distance:   215   1051   2147   1005", 0));
    }

    static Stream<Arguments> task2() {
        return Stream.of(Arguments.of("Time:      7  15   30\n" +
                        "Distance:  9  40  200", 71503),
                Arguments.of("Time:        40     70     98     79\n" +
                        "Distance:   215   1051   2147   1005", 0));
    }

    @ParameterizedTest
    @MethodSource
    void task1(String i, long expected) {
        Day6 test = new Day6(i);
        long actual = test.task1();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource
    void task2(String i, long expected) {
        Day6 test = new Day6(i);
        long actual = test.task2();
        assertEquals(expected, actual);
    }
}