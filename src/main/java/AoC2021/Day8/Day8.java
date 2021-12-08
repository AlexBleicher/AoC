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

    public int task2() {
        List<Integer> allValues = getValuesOfOutput();
        int sum = 0;
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
            String[] outputValuesAsString = outputLine.split(" ");
            String valueAsString = "";
            for (String outputValue : outputValuesAsString) {
                valueAsString += findCorrespondingValue(numberPattern, outputValue);
            }
            allValues.add(Integer.parseInt(valueAsString));
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
        if (pattern.contains(leftSide)) {
            return 3;
        }
        int countOfLetters = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (rightUp.contains(pattern.substring(i, i + 1))) {
                countOfLetters++;
            }
        }
        if (countOfLetters == 2) {
            return 5;
        }
        return 2;
    }

    public int decideIf06Or9(String leftSide, String rightUp, String pattern) {
        if (!pattern.contains(leftSide)) {
            return 6;
        }
        int countOfLetters = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (rightUp.contains(pattern.substring(i, i + 1))) {
                countOfLetters++;
            }
        }
        if (countOfLetters == 2) {
            return 9;
        }
        return 0;
    }

    public String findCorrespondingValue(Map<Integer, String> numberPatterns, String outputValue){
        if(outputValue.length() == 2){
            return "" + 1;
        }
        if(outputValue.length() == 3){
            return "" + 7;
        }
        if(outputValue.length() == 4){
            return "" + 4;
        }
        if(outputValue.length() == 7){
            return "" + 8;
        }
        return ""; //Todo fertig implementieren
    }
}
