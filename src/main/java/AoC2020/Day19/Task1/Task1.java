package AoC2020.Day19.Task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {

    public static Input input = new Input();
    public static Map<Integer, String> allRules = input.getAllRules();
    public static List<String> allLines = input.getAllLines();

    public static void main(String[] args) {
        System.out.println(allLines.size());
        List<String> allValidLines = filterAllValidLines(allLines);
        System.out.println(allValidLines.size());
    }

    public static List<String> filterAllValidLines(List<String> allLines) {
        List<String> allValidLines = allLines.stream()
                .filter(line -> isValid(line))
                .collect(Collectors.toList());
        return allValidLines;
    }

    public static boolean isValid(String line) {
        EvaluationResult result = meetsRule(line, allRules.get(0));
        return (result.isChecksOut() && result.getWordAfterEvaluation().length() == 0);
    }

    public static EvaluationResult meetsRule(String currentWord, String rule) {
        if (currentWord.length() == 0) {
            return new EvaluationResult(currentWord, false);
        }
        if (rule.equals("\"a\"") || rule.equals("\"b\"")) {
            rule = rule.replaceAll("\"", "");
            return new EvaluationResult(currentWord.substring(1), currentWord.charAt(0) == rule.charAt(0));
        } else {
            if (rule.contains(" | ")) {
                String[] subRuleOptions = rule.split(" [|] ");
                EvaluationResult result = checksSubrules(currentWord, subRuleOptions[0]);
                if (result.isChecksOut()) {
                    return new EvaluationResult(result.getWordAfterEvaluation(), true);
                }
                result = checksSubrules(currentWord, subRuleOptions[1]);
                return new EvaluationResult(result.getWordAfterEvaluation(), result.isChecksOut());
            }
            return checksSubrules(currentWord, rule);
        }
    }

    public static EvaluationResult checksSubrules(String word, String rules) {
        String[] subRules = rules.split(" ");
        String wordAfter = word;
        for (int i = 0; i < subRules.length; i++) {
            EvaluationResult result = meetsRule(wordAfter, allRules.get(Integer.parseInt(subRules[i])));
            if (!result.isChecksOut()) {
                return new EvaluationResult(word, false);
            }
            wordAfter = result.getWordAfterEvaluation();
        }
        return new EvaluationResult(wordAfter, true);
    }

}
