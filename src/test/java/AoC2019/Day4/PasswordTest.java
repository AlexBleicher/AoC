package AoC2019.Day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordTest {

    @ParameterizedTest
    @MethodSource
    void neverDecreases(int input, boolean expectedResult) {
        Password testObject = new Password(input);
        boolean testResult = testObject.neverDecreases();

        assertEquals(expectedResult, testResult);
    }

    public static Stream<Arguments> neverDecreases() {
        return Stream.of(
                Arguments.of(111111, true),
                Arguments.of(123789, true),
                Arguments.of(120009, false),
                Arguments.of(223450, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void hasDouble(int input, boolean expectedResult) {
        Password testObject = new Password(input);
        boolean testResult = testObject.hasDouble();

        assertEquals(expectedResult, testResult);
    }

    public static Stream<Arguments> hasDouble() {
        return Stream.of(
                Arguments.of(111111, true),
                Arguments.of(223450, true),
                Arguments.of(123789, false),
                Arguments.of(101010, false)
        );
    }

}