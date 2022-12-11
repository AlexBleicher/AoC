package AoC2022.Day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    public static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("Monkey 0:\n" +
                        "  Starting items: 79, 98\n" +
                        "  Operation: new = old * 19\n" +
                        "  Test: divisible by 23\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 3\n" +
                        "\n" +
                        "Monkey 1:\n" +
                        "  Starting items: 54, 65, 75, 74\n" +
                        "  Operation: new = old + 6\n" +
                        "  Test: divisible by 19\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 0\n" +
                        "\n" +
                        "Monkey 2:\n" +
                        "  Starting items: 79, 60, 97\n" +
                        "  Operation: new = old * old\n" +
                        "  Test: divisible by 13\n" +
                        "    If true: throw to monkey 1\n" +
                        "    If false: throw to monkey 3\n" +
                        "\n" +
                        "Monkey 3:\n" +
                        "  Starting items: 74\n" +
                        "  Operation: new = old + 3\n" +
                        "  Test: divisible by 17\n" +
                        "    If true: throw to monkey 0\n" +
                        "    If false: throw to monkey 1", 10605),
                Arguments.of("Monkey 0:\n" +
                        "  Starting items: 71, 56, 50, 73\n" +
                        "  Operation: new = old * 11\n" +
                        "  Test: divisible by 13\n" +
                        "    If true: throw to monkey 1\n" +
                        "    If false: throw to monkey 7\n" +
                        "\n" +
                        "Monkey 1:\n" +
                        "  Starting items: 70, 89, 82\n" +
                        "  Operation: new = old + 1\n" +
                        "  Test: divisible by 7\n" +
                        "    If true: throw to monkey 3\n" +
                        "    If false: throw to monkey 6\n" +
                        "\n" +
                        "Monkey 2:\n" +
                        "  Starting items: 52, 95\n" +
                        "  Operation: new = old * old\n" +
                        "  Test: divisible by 3\n" +
                        "    If true: throw to monkey 5\n" +
                        "    If false: throw to monkey 4\n" +
                        "\n" +
                        "Monkey 3:\n" +
                        "  Starting items: 94, 64, 69, 87, 70\n" +
                        "  Operation: new = old + 2\n" +
                        "  Test: divisible by 19\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 6\n" +
                        "\n" +
                        "Monkey 4:\n" +
                        "  Starting items: 98, 72, 98, 53, 97, 51\n" +
                        "  Operation: new = old + 6\n" +
                        "  Test: divisible by 5\n" +
                        "    If true: throw to monkey 0\n" +
                        "    If false: throw to monkey 5\n" +
                        "\n" +
                        "Monkey 5:\n" +
                        "  Starting items: 79\n" +
                        "  Operation: new = old + 7\n" +
                        "  Test: divisible by 2\n" +
                        "    If true: throw to monkey 7\n" +
                        "    If false: throw to monkey 0\n" +
                        "\n" +
                        "Monkey 6:\n" +
                        "  Starting items: 77, 55, 63, 93, 66, 90, 88, 71\n" +
                        "  Operation: new = old * 7\n" +
                        "  Test: divisible by 11\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 4\n" +
                        "\n" +
                        "Monkey 7:\n" +
                        "  Starting items: 54, 97, 87, 70, 59, 82, 59\n" +
                        "  Operation: new = old + 8\n" +
                        "  Test: divisible by 17\n" +
                        "    If true: throw to monkey 1\n" +
                        "    If false: throw to monkey 3", 0)
        );
    }

    public static Stream<Arguments> task2() {
        return Stream.of(
                Arguments.of("Monkey 0:\n" +
                        "  Starting items: 79, 98\n" +
                        "  Operation: new = old * 19\n" +
                        "  Test: divisible by 23\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 3\n" +
                        "\n" +
                        "Monkey 1:\n" +
                        "  Starting items: 54, 65, 75, 74\n" +
                        "  Operation: new = old + 6\n" +
                        "  Test: divisible by 19\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 0\n" +
                        "\n" +
                        "Monkey 2:\n" +
                        "  Starting items: 79, 60, 97\n" +
                        "  Operation: new = old * old\n" +
                        "  Test: divisible by 13\n" +
                        "    If true: throw to monkey 1\n" +
                        "    If false: throw to monkey 3\n" +
                        "\n" +
                        "Monkey 3:\n" +
                        "  Starting items: 74\n" +
                        "  Operation: new = old + 3\n" +
                        "  Test: divisible by 17\n" +
                        "    If true: throw to monkey 0\n" +
                        "    If false: throw to monkey 1", Long.parseLong("2713310158")),
                Arguments.of("Monkey 0:\n" +
                        "  Starting items: 71, 56, 50, 73\n" +
                        "  Operation: new = old * 11\n" +
                        "  Test: divisible by 13\n" +
                        "    If true: throw to monkey 1\n" +
                        "    If false: throw to monkey 7\n" +
                        "\n" +
                        "Monkey 1:\n" +
                        "  Starting items: 70, 89, 82\n" +
                        "  Operation: new = old + 1\n" +
                        "  Test: divisible by 7\n" +
                        "    If true: throw to monkey 3\n" +
                        "    If false: throw to monkey 6\n" +
                        "\n" +
                        "Monkey 2:\n" +
                        "  Starting items: 52, 95\n" +
                        "  Operation: new = old * old\n" +
                        "  Test: divisible by 3\n" +
                        "    If true: throw to monkey 5\n" +
                        "    If false: throw to monkey 4\n" +
                        "\n" +
                        "Monkey 3:\n" +
                        "  Starting items: 94, 64, 69, 87, 70\n" +
                        "  Operation: new = old + 2\n" +
                        "  Test: divisible by 19\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 6\n" +
                        "\n" +
                        "Monkey 4:\n" +
                        "  Starting items: 98, 72, 98, 53, 97, 51\n" +
                        "  Operation: new = old + 6\n" +
                        "  Test: divisible by 5\n" +
                        "    If true: throw to monkey 0\n" +
                        "    If false: throw to monkey 5\n" +
                        "\n" +
                        "Monkey 5:\n" +
                        "  Starting items: 79\n" +
                        "  Operation: new = old + 7\n" +
                        "  Test: divisible by 2\n" +
                        "    If true: throw to monkey 7\n" +
                        "    If false: throw to monkey 0\n" +
                        "\n" +
                        "Monkey 6:\n" +
                        "  Starting items: 77, 55, 63, 93, 66, 90, 88, 71\n" +
                        "  Operation: new = old * 7\n" +
                        "  Test: divisible by 11\n" +
                        "    If true: throw to monkey 2\n" +
                        "    If false: throw to monkey 4\n" +
                        "\n" +
                        "Monkey 7:\n" +
                        "  Starting items: 54, 97, 87, 70, 59, 82, 59\n" +
                        "  Operation: new = old + 8\n" +
                        "  Test: divisible by 17\n" +
                        "    If true: throw to monkey 1\n" +
                        "    If false: throw to monkey 3", 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void task1(String input, long expected) {
        Day11 testObject = new Day11(input);
        long result = testObject.task1();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource
    public void task2(String input, long expected) {
        Day11 testObject = new Day11(input);
        long result = testObject.task2();

        assertEquals(expected, result);
    }
}