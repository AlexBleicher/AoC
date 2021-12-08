package AoC2021.Day8;

import java.util.*;
import java.util.stream.Collectors;

public class Day8 {

    private List<String> numberSignals;
    private List<String> output;

    public Day8(String input) {
        numberSignals = new Input(input).getNumberSignals();
        output = new Input(input).getOuput();
    }

    public int task1() {
        return countEasyDigits();
    }

    public int countEasyDigits() {
        int count = 0;
        for (String outputLine : output) {
            String[] outputSplit = outputLine.split(" ");
            for (String outputNumber : outputSplit) {
                if (outputNumber.length() == 2 || outputNumber.length() == 3 || outputNumber.length() == 4 || outputNumber.length() == 7) {
                    count++;
                }
            }
        }
        return count;
    }

    public long task2() {
        List<Integer> allValues = getValuesOfOutput();
        long sum = 0;
        for (Integer val : allValues) {
            sum += val;
        }
        return sum;
    }

    public List<Integer> getValuesOfOutput() {
        List<Integer> allValues = new ArrayList<>();
        for (int i = 0; i < numberSignals.size(); i++) {
            String signalLine = numberSignals.get(i);
            Map<Integer, String> numberPattern = findNumberPattern(signalLine);
            String outputLine = output.get(i);
            String[] outputValuesAsString = outputLine.trim().split(" ");
            StringBuilder valueAsString = new StringBuilder();
            for (String outputValue : outputValuesAsString) {
                valueAsString.append(findCorrespondingValue(numberPattern, outputValue));
            }
            allValues.add(Integer.parseInt(valueAsString.toString()));
        }
        return allValues;
    }

    public Map<Integer, String> findNumberPattern(String signalLine) {
        Map<Integer, String> numberPatterns = new HashMap<>();
        String[] patterns = signalLine.split(" ");
        List<String> patternsSorted = new ArrayList<>(Arrays.asList(patterns))
                .stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        numberPatterns.put(1, patternsSorted.get(0));
        numberPatterns.put(7, patternsSorted.get(1));
        numberPatterns.put(4, patternsSorted.get(2));
        for (int i = 3; i < patternsSorted.size(); i++) {
            String pattern = patternsSorted.get(i);
            if (pattern.length() == 5) {
                int number = decideIf23Or5(numberPatterns.get(1), numberPatterns.get(4), pattern);
                numberPatterns.put(number, pattern);
            } else if (pattern.length() == 6) {
                int number = decideIf06Or9(numberPatterns.get(1), numberPatterns.get(4), pattern);
                numberPatterns.put(number, pattern);
            }
            if (pattern.length() == 7) {
                numberPatterns.put(8, pattern);
            }
        }
        return numberPatterns;
    }

    public int decideIf23Or5(String leftSide, String rightUp, String pattern) {
        if (pattern.contains(leftSide.substring(0, 1)) && pattern.contains(leftSide.substring(1))) {
            return 3;
        }
        int countOfLetters = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (rightUp.contains(pattern.substring(i, i + 1))) {
                countOfLetters++;
            }
        }
        if (countOfLetters == 2) {
            return 2;
        }
        return 5;
    }

    public int decideIf06Or9(String leftSide, String rightUp, String pattern) {
        if (!(pattern.contains(leftSide.substring(0, 1)) && pattern.contains(leftSide.substring(1)))) {
            return 6;
        }
        int countOfLetters = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (rightUp.contains(pattern.substring(i, i + 1))) {
                countOfLetters++;
            }
        }
        if (countOfLetters == 4) {
            return 9;
        }
        return 0;
    }

    public String findCorrespondingValue(Map<Integer, String> numberPatterns, String outputValue) {
        if (outputValue.length() == 2) {
            return "" + 1;
        }
        if (outputValue.length() == 3) {
            return "" + 7;
        }
        if (outputValue.length() == 4) {
            return "" + 4;
        }
        if (outputValue.length() == 7) {
            return "" + 8;
        }
        List<String> possiblePatterns = new ArrayList<>();
        if (outputValue.length() == 5) {
            possiblePatterns.add(numberPatterns.get(2));
            possiblePatterns.add(numberPatterns.get(3));
            possiblePatterns.add(numberPatterns.get(5));
        } else if (outputValue.length() == 6) {
            possiblePatterns.add(numberPatterns.get(0));
            possiblePatterns.add(numberPatterns.get(6));
            possiblePatterns.add(numberPatterns.get(9));
        }
        while (possiblePatterns.size() > 1) {
            for (int i = 0; i < outputValue.length(); i++) {
                for (int j = 0; j < possiblePatterns.size(); j++) {
                    String possiblePattern = possiblePatterns.get(j);
                    if (!possiblePattern.contains(outputValue.substring(i, i + 1))) {
                        possiblePatterns.remove(possiblePattern);
                    }
                }
                if (possiblePatterns.size() == 1) {
                    for (Map.Entry<Integer, String> entry : numberPatterns.entrySet()) {
                        if (entry.getValue().equals(possiblePatterns.get(0))) {
                            return "" + entry.getKey();
                        }
                    }
                }
            }
        }
        return "";
    }
}
