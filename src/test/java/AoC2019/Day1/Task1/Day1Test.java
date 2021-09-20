package AoC2019.Day1.Task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @ParameterizedTest
    @MethodSource
    void task1(String input, long expectedResult) {
        Day1 testObject = new Day1();
        long testResult = testObject.task1(input);

        assertEquals(expectedResult, testResult);
    }

    static Stream<Arguments> task1() {
        return Stream.of(
                Arguments.of("12", 2),
                Arguments.of("14", 2),
                Arguments.of("1969", 654),
                Arguments.of("100756", 33583),
                Arguments.of("106404\n" +
                        "140515\n" +
                        "142745\n" +
                        "120767\n" +
                        "79665\n" +
                        "54235\n" +
                        "127391\n" +
                        "72207\n" +
                        "70799\n" +
                        "79485\n" +
                        "103994\n" +
                        "129583\n" +
                        "132791\n" +
                        "95135\n" +
                        "121194\n" +
                        "129425\n" +
                        "64861\n" +
                        "123233\n" +
                        "132805\n" +
                        "87916\n" +
                        "111395\n" +
                        "126625\n" +
                        "113045\n" +
                        "61704\n" +
                        "65413\n" +
                        "145820\n" +
                        "75988\n" +
                        "74717\n" +
                        "115137\n" +
                        "85331\n" +
                        "86833\n" +
                        "86063\n" +
                        "85464\n" +
                        "139738\n" +
                        "103372\n" +
                        "101942\n" +
                        "52741\n" +
                        "77660\n" +
                        "112745\n" +
                        "103109\n" +
                        "106301\n" +
                        "141714\n" +
                        "74546\n" +
                        "55474\n" +
                        "106747\n" +
                        "140234\n" +
                        "60426\n" +
                        "145867\n" +
                        "144810\n" +
                        "94179\n" +
                        "101606\n" +
                        "77763\n" +
                        "139291\n" +
                        "104246\n" +
                        "148513\n" +
                        "126828\n" +
                        "64624\n" +
                        "139058\n" +
                        "85839\n" +
                        "86636\n" +
                        "62198\n" +
                        "137358\n" +
                        "76711\n" +
                        "87848\n" +
                        "141711\n" +
                        "114079\n" +
                        "71639\n" +
                        "95896\n" +
                        "104522\n" +
                        "61929\n" +
                        "72199\n" +
                        "142790\n" +
                        "137736\n" +
                        "123437\n" +
                        "91872\n" +
                        "127661\n" +
                        "111179\n" +
                        "51548\n" +
                        "83452\n" +
                        "91196\n" +
                        "117798\n" +
                        "84484\n" +
                        "75517\n" +
                        "83820\n" +
                        "97407\n" +
                        "89181\n" +
                        "71428\n" +
                        "72758\n" +
                        "73076\n" +
                        "109957\n" +
                        "50601\n" +
                        "74571\n" +
                        "65556\n" +
                        "129765\n" +
                        "80626\n" +
                        "126995\n" +
                        "73480\n" +
                        "71360\n" +
                        "103288\n" +
                        "85670", 3302760)
        );
    }

}