package AoC2024.Day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    static Stream<Arguments> task1() {
        return Stream.of(Arguments.of(
                "125 17", 55312L), Arguments.of("8793800 1629 65 5 960 0 138983 85629", 0L));
    }

    static Stream<Arguments> task2() {
        return Stream.of(Arguments.of("8793800 1629 65 5 960 0 138983 85629", 0L));
    }

    @ParameterizedTest
    @MethodSource
    void task1(String s, Long e) {
        Day11 day11 = new Day11(s);
        long a = day11.task1();
        assertEquals(e, a);
    }

    @ParameterizedTest
    @MethodSource
    void task2(String s, Long e) {
        Day11 day11 = new Day11(s);
        long a = day11.task2();
        assertEquals(e, a);
    }
}