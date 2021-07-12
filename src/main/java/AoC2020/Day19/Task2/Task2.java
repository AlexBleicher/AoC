package AoC2020.Day19.Task2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {

    public static Input input = new Input();
    public static Map<Integer, String> allRules = input.getAllRules(1);
    public static List<String> allLines = input.getAllLines(1);
    public static Map<Integer, String> allRulesUpdated = input.getAllRules(2);
    public static List<String> allLinesTask2 = input.getAllLines(2);

    public static void main(String[] args) {
        List<String> allValidLinesWithoutLoop = filterAllValidLines(allLines, allRules);
        List<String> restLinesPossiblyValid = filterAllTooShortRestLines(allValidLinesWithoutLoop, allLinesTask2);
        List<String> allRestValidWithLoop = filterAllValidLines(restLinesPossiblyValid, allRulesUpdated);
        int amountOfValids = allValidLinesWithoutLoop.size() + allRestValidWithLoop.size();
        System.out.println(amountOfValids);
    }

    public static List<String> filterAllValidLines(List<String> allLines, Map<Integer, String> rulesUsed) {
        return allLines.stream()
                .filter(line -> isValid(line, rulesUsed))
                .collect(Collectors.toList());
    }

    public static List<String> filterAllTooShortRestLines(List<String> allValidLines, List<String> completeInput) {
        return completeInput.stream()
                .filter(line -> !allValidLines.contains(line))
                .filter(line -> (line.length() > allValidLines.get(0).length()))
                .collect(Collectors.toList());
    }

    public static boolean isValid(String line, Map<Integer, String> rulesUsed) {
        if (rulesUsed == allRules) {
            EvaluationResult result = meetsRule(line, rulesUsed.get(0), rulesUsed);
            return (result.isChecksOut() && result.getWordAfterEvaluation().length() == 0);
        } else {
            EvaluationResult result = checkRulesWithLoop(line);
            return result.isChecksOut() && result.getWordAfterEvaluation().length() == 0;
        }
    }

    public static EvaluationResult meetsRule(String currentWord, String rule, Map<Integer, String> rulesUsed) {
        if (currentWord.length() == 0) {
            return new EvaluationResult(currentWord, false);
        }
        if (rule.equals("\"a\"") || rule.equals("\"b\"")) {
            rule = rule.replaceAll("\"", "");
            return new EvaluationResult(currentWord.substring(1), currentWord.charAt(0) == rule.charAt(0));
        } else {
            if (rule.contains(" | ")) {
                String[] subRuleOptions = rule.split(" [|] ");
                EvaluationResult result = checksSubrules(currentWord, subRuleOptions[0], rulesUsed);
                if (result.isChecksOut()) {
                    return new EvaluationResult(result.getWordAfterEvaluation(), true);
                }
                result = checksSubrules(currentWord, subRuleOptions[1], rulesUsed);
                return new EvaluationResult(result.getWordAfterEvaluation(), result.isChecksOut());
            }
            return checksSubrules(currentWord, rule, rulesUsed);
        }
    }

    public static EvaluationResult checksSubrules(String word, String rules, Map<Integer, String> rulesUsed) {
        String[] subRules = rules.split(" ");
        String wordAfter = word;
        for (String subRule : subRules) {
            EvaluationResult result = meetsRule(wordAfter, rulesUsed.get(Integer.parseInt(subRule)), rulesUsed);
            if (!result.isChecksOut()) {
                return new EvaluationResult(word, false);
            }
            wordAfter = result.getWordAfterEvaluation();
        }
        return new EvaluationResult(wordAfter, true);
    }

    public static EvaluationResult checkRulesWithLoop(String word) {
        EvaluationResult resultOfCheck = meetsRule(word, allRulesUpdated.get(8), allRulesUpdated);
        if (!resultOfCheck.isChecksOut()) {
            return resultOfCheck;
        } else {
            String wordInEvaluation = resultOfCheck.getWordAfterEvaluation();
            resultOfCheck = meetsRule(wordInEvaluation, allRulesUpdated.get(11), allRulesUpdated);
            if (!resultOfCheck.isChecksOut()) {
                return checkRulesWithLoop(wordInEvaluation);
            }
        }
        return resultOfCheck;
    }

}
