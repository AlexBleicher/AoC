package AoC2021.Day15;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {
    @ParameterizedTest
    @MethodSource
    void task1(String input, int expectedResult){
        Day15 testObject = new Day15(input);
        int result= testObject.task1();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task1(){
        return Stream.of(
                Arguments.of("1163751742\n" +
                        "1381373672\n" +
                        "2136511328\n" +
                        "3694931569\n" +
                        "7463417111\n" +
                        "1319128137\n" +
                        "1359912421\n" +
                        "3125421639\n" +
                        "1293138521\n" +
                        "2311944581", 40)
        );
    }

}