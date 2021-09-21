package AoC2019.Day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @ParameterizedTest
    @MethodSource
    void runIntProgram(String input, ArrayList<Integer> expectedResult) {
        Day2 testObject = new Day2(input);
        ArrayList testResult = testObject.runIntProgram();

        assertEquals(expectedResult, testResult);
    }

    static Stream<Arguments> runIntProgram() {
        return Stream.of(
                Arguments.of("1,0,0,0,99", new ArrayList<Integer>(Arrays.asList(2, 0, 0, 0, 99))),
                Arguments.of("2,3,0,3,99", new ArrayList<Integer>(Arrays.asList(2, 3, 0, 6, 99))),
                Arguments.of("2,4,4,5,99,0", new ArrayList<Integer>(Arrays.asList(2, 4, 4, 5, 99, 9801))),
                Arguments.of("1,1,1,4,99,5,6,0,99", new ArrayList<Integer>(Arrays.asList(30, 1, 1, 4, 2, 5, 6, 0, 99)))
        );
    }

    @ParameterizedTest
    @MethodSource
    void task1(String input, int expectedResult) {
        Day2 testObject = new Day2(input);
        int testResult = testObject.solveTask1();

        assertEquals(expectedResult, testResult);
    }

    static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,13,19,1,9,19,23,2,13,23,27,2,27,13,31,2,31,10,35,1,6,35,39,1,5,39,43,1,10,43,47,1,5,47,51,1,13,51,55,2,55,9,59,1,6,59,63,1,13,63,67,1,6,67,71,1,71,10,75,2,13,75,79,1,5,79,83,2,83,6,87,1,6,87,91,1,91,13,95,1,95,13,99,2,99,13,103,1,103,5,107,2,107,10,111,1,5,111,115,1,2,115,119,1,119,6,0,99,2,0,14,0", 3790689)
        );
    }

    @ParameterizedTest
    @MethodSource
    void task2(String input, int expectedresult) {
        Day2 testObject = new Day2(input);
        int testResult = testObject.solveTask2();

        assertEquals(expectedresult, testResult);
    }

    static Stream<Arguments> task2() {
        return Stream.of(
                Arguments.of("1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,13,19,1,9,19,23,2,13,23,27,2,27,13,31,2,31,10,35,1,6,35,39,1,5,39,43,1,10,43,47,1,5,47,51,1,13,51,55,2,55,9,59,1,6,59,63,1,13,63,67,1,6,67,71,1,71,10,75,2,13,75,79,1,5,79,83,2,83,6,87,1,6,87,91,1,91,13,95,1,95,13,99,2,99,13,103,1,103,5,107,2,107,10,111,1,5,111,115,1,2,115,119,1,119,6,0,99,2,0,14,0", 6533)
        );
    }
}