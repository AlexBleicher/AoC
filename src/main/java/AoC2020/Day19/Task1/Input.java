package AoC2020.Day19.Task1;

import java.util.*;

public class Input {

    private String input = "0: 4 1 5\n" +
            "1: 2 3 | 3 2\n" +
            "2: 4 4 | 5 5\n" +
            "3: 4 5 | 5 4\n" +
            "4: \"a\"\n" +
            "5: \"b\"\n" +
            "\n" +
            "ababbb\n" +
            "bababa\n" +
            "abbbab\n" +
            "aaabbb\n" +
            "aaaabbb\n" +
            "aa";


    private String[] splitInput = input.split("\n\n");

    public Map<Integer, String> getAllRules() {
        String rulesInputString = splitInput[0];
        String[] allRulesSplit = rulesInputString.split("\n");
        Map<Integer, String> allRules = new TreeMap<>();
        for (String s : allRulesSplit) {
            String[] ruleParts = s.split(": ");
            allRules.put(Integer.parseInt(ruleParts[0]), ruleParts[1]);
        }
        return allRules;
    }

    public List<String> getAllLines() {
        String lineInputString = splitInput[1];
        String[] allLinesSplit = lineInputString.split("\n");
        List<String> allLines = new ArrayList<>();
        Collections.addAll(allLines, allLinesSplit);
        return allLines;
    }

}
