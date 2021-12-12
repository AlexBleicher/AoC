package AoC2021.Day12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {

    @ParameterizedTest
    @MethodSource
    void task1(String input, int expectedResult) {
        Day12 testObject = new Day12(input);
        int result = testObject.task1();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("start-A\n" +
                        "start-b\n" +
                        "A-c\n" +
                        "A-b\n" +
                        "b-d\n" +
                        "A-end\n" +
                        "b-end", 10),
                Arguments.of("dc-end\n" +
                        "HN-start\n" +
                        "start-kj\n" +
                        "dc-start\n" +
                        "dc-HN\n" +
                        "LN-dc\n" +
                        "HN-end\n" +
                        "kj-sa\n" +
                        "kj-HN\n" +
                        "kj-dc", 19),
                Arguments.of("fs-end\n" +
                        "he-DX\n" +
                        "fs-he\n" +
                        "start-DX\n" +
                        "pj-DX\n" +
                        "end-zg\n" +
                        "zg-sl\n" +
                        "zg-pj\n" +
                        "pj-he\n" +
                        "RW-he\n" +
                        "fs-DX\n" +
                        "pj-RW\n" +
                        "zg-RW\n" +
                        "start-pj\n" +
                        "he-WI\n" +
                        "zg-he\n" +
                        "pj-fs\n" +
                        "start-RW", 226),
                Arguments.of("ln-nr\n" +
                        "ln-wy\n" +
                        "fl-XI\n" +
                        "qc-start\n" +
                        "qq-wy\n" +
                        "qc-ln\n" +
                        "ZD-nr\n" +
                        "qc-YN\n" +
                        "XI-wy\n" +
                        "ln-qq\n" +
                        "ln-XI\n" +
                        "YN-start\n" +
                        "qq-XI\n" +
                        "nr-XI\n" +
                        "start-qq\n" +
                        "qq-qc\n" +
                        "end-XI\n" +
                        "qq-YN\n" +
                        "ln-YN\n" +
                        "end-wy\n" +
                        "qc-nr\n" +
                        "end-nr", 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void task2(String input, int expectedResult) {
        Day12 testObject = new Day12(input);
        int result = testObject.task2();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task2() {
        return Stream.of(
                Arguments.of("start-A\n" +
                        "start-b\n" +
                        "A-c\n" +
                        "A-b\n" +
                        "b-d\n" +
                        "A-end\n" +
                        "b-end", 36),
                Arguments.of("dc-end\n" +
                        "HN-start\n" +
                        "start-kj\n" +
                        "dc-start\n" +
                        "dc-HN\n" +
                        "LN-dc\n" +
                        "HN-end\n" +
                        "kj-sa\n" +
                        "kj-HN\n" +
                        "kj-dc", 103),
                Arguments.of("fs-end\n" +
                        "he-DX\n" +
                        "fs-he\n" +
                        "start-DX\n" +
                        "pj-DX\n" +
                        "end-zg\n" +
                        "zg-sl\n" +
                        "zg-pj\n" +
                        "pj-he\n" +
                        "RW-he\n" +
                        "fs-DX\n" +
                        "pj-RW\n" +
                        "zg-RW\n" +
                        "start-pj\n" +
                        "he-WI\n" +
                        "zg-he\n" +
                        "pj-fs\n" +
                        "start-RW", 3509),
                Arguments.of("ln-nr\n" +
                        "ln-wy\n" +
                        "fl-XI\n" +
                        "qc-start\n" +
                        "qq-wy\n" +
                        "qc-ln\n" +
                        "ZD-nr\n" +
                        "qc-YN\n" +
                        "XI-wy\n" +
                        "ln-qq\n" +
                        "ln-XI\n" +
                        "YN-start\n" +
                        "qq-XI\n" +
                        "nr-XI\n" +
                        "start-qq\n" +
                        "qq-qc\n" +
                        "end-XI\n" +
                        "qq-YN\n" +
                        "ln-YN\n" +
                        "end-wy\n" +
                        "qc-nr\n" +
                        "end-nr", 0)
        );
    }

}