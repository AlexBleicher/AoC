package AoC2020;

import org.junit.jupiter.api.Test;

import java.util.*;

class Day16Task1Test {

    @Test
    public void testReplaceNonNumerical() {

        String test = "1afieojoiehioho-3";

        test = test.replaceAll("[^0-9-]", "");

        assert (test).equals("1-3");
    }

    @Test
    public void testGetAllRanges() {
        List<String> testInput = new ArrayList<>();
        testInput.add("afdeafoe: 12-13 or 32-34");
        testInput.add("afoehoiio: 55-56 or 77-78");

        Day16Task1 testObject = new Day16Task1();

        Set<Integer> result = testObject.getAllAllowedNumbers(testInput);

        Set<Integer> h = new HashSet<>(Arrays.asList(12, 13, 32, 33, 34, 55, 56, 77, 78));

        assert (result).equals(h);

    }

}