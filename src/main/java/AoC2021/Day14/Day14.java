package AoC2021.Day14;

import java.util.*;

public class Day14 {

    public List<Rule> allRules;
    public String polymerTemplate;
    public Map<String, Long> amountOfRules = new HashMap<>();
    public Map<Character, Long> amountOfLetters = new HashMap<>();

    public Day14(String input) {
        this.polymerTemplate = new Input(input).getPolymerTemplate();
        this.allRules = new Input(input).getInsertionRules();
        for (Rule rule : allRules) {
            amountOfRules.put(rule.getPair(), Long.parseLong("0"));
        }
        for (int i = 0; i < polymerTemplate.length(); i++) {
            char currentChar = polymerTemplate.charAt(i);
            if (amountOfLetters.containsKey(currentChar)) {
                amountOfLetters.replace(currentChar, amountOfLetters.get(currentChar), amountOfLetters.get(currentChar) + 1);
            } else {
                amountOfLetters.put(currentChar, Long.parseLong("1"));
            }
        }
        for (int i = 0; i < polymerTemplate.length() - 1; i++) {
            String currentSubstring = polymerTemplate.substring(i, i + 2);
            amountOfRules.replace(currentSubstring, amountOfRules.get(currentSubstring), amountOfRules.get(currentSubstring) + 1);
        }
    }

    public long task1() {
        for (int i = 0; i < 10; i++) {
            insertionStep();
        }
        System.out.println(polymerTemplate.length());
        return calculateScore();
    }

    public void insertionStep() {
        String polymerTemplateAfterStep = "";
        for (int i = 0; i <= polymerTemplate.length() - 2; i++) {
            String currentSubstring = polymerTemplate.substring(i, i + 2);
            boolean hasRule = false;
            for (Rule rule : allRules) {
                if (rule.getPair().equals(currentSubstring)) {
                    if (i == 0) {
                        polymerTemplateAfterStep += rule.getStringAfterInsertion();
                    } else {
                        polymerTemplateAfterStep += rule.getStringAfterInsertion().substring(1);
                    }
                    hasRule = true;
                }
            }
            if (!hasRule) {
                polymerTemplateAfterStep += currentSubstring;
            }
        }
        polymerTemplate = polymerTemplateAfterStep;
    }

    public long calculateScore() {
        Set<Character> allLeters = new HashSet<>();
        for (int i = 0; i < polymerTemplate.length(); i++) {
            allLeters.add(polymerTemplate.charAt(i));
        }
        long max = 0;
        long min = -1;
        for (Character letter : allLeters) {
            long occurenceOfLetter = polymerTemplate.chars().filter(ch -> ch == letter).count();
            if (occurenceOfLetter > max) {
                max = occurenceOfLetter;
            } else if (min == -1 || min > occurenceOfLetter) {
                min = occurenceOfLetter;
            }
        }
        return max - min;
    }

    public long task2() {
        for (int i = 0; i < 40; i++) {
            insertionStepOptimized();
        }
        return calculateScoreOptimized();
    }

    public void insertionStepOptimized() {
        Map<String, Long> temp = new HashMap<>(amountOfRules);
        for (Rule rule : allRules) {
            String newRule1 = rule.getStringAfterInsertion().substring(0, 2);
            String newRule2 = rule.getStringAfterInsertion().substring(1);
            char addedLetter = rule.getStringAfterInsertion().charAt(1);
            long amountOfRule = amountOfRules.get(rule.getPair());
            addRule(temp, newRule1, amountOfRule);
            addRule(temp, newRule2, amountOfRule);
            addRule(temp, rule.getPair(), -amountOfRule);
            addAmountToLetter(addedLetter, amountOfRule);
        }
        amountOfRules = temp;
    }

    public void addRule(Map<String, Long> temp, String rule, long amountOfRule) {

        temp.replace(rule, temp.get(rule), temp.get(rule) + amountOfRule);

    }

    public void addAmountToLetter(char letterInsertet, long amountOfrule) {
        if (amountOfLetters.containsKey(letterInsertet)) {
            amountOfLetters.replace(letterInsertet, amountOfLetters.get(letterInsertet), amountOfLetters.get(letterInsertet) + amountOfrule);
        } else {
            amountOfLetters.put(letterInsertet, amountOfrule);
        }
    }

    public long calculateScoreOptimized() {
        long max = 0;
        long min = -1;
        for (Map.Entry<Character, Long> entry : amountOfLetters.entrySet()) {
            long entryValue = entry.getValue();
            if (max < entryValue) {
                max = entryValue;
            } else if (min == -1 || min > entryValue) {
                min = entryValue;
            }
        }
        return max - min;
    }
}
