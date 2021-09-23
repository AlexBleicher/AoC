package AoC2019.Day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    @ParameterizedTest
    @MethodSource
    void calculatemanhattenDistance(int x, int y, int expectedResult) {
        Coordinate testObject = new Coordinate(x, y);
        int testResult = testObject.calculateManhattanDistanceToOrigin();

        assertEquals(expectedResult, testResult);
    }


    public static Stream<Arguments> calculatemanhattenDistance() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(-1, -1, 2),
                Arguments.of(-1, 1, 2)
        );
    }


}