package AoC2020.Day18.Task2;

import AoC2020.Day18.Task1.Input;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Task2 {

    private static List<String> allLines = new Input().parseInput();

    public static void main(String[] args) {
        System.out.print(calculateResultOfAllLines());
    }

    public static long calculateResultOfAllLines() {
        long resultOfAllLines = 0;
        for (String line : allLines) {
            line = replaceBracketInLine(line);
            line = replacePlusInLine(line);
            long result = calculateTimes(line);
            resultOfAllLines += result;
        }
        return resultOfAllLines;
    }

    public static String replaceBracketInLine(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                for (int j = i - 1; j >= 0; j--) {
                    if (input.charAt(j) == '(') {
                        String bracket = input.substring(j, i + 1);
                        String bracketForCalculation = input.substring(j + 1, i);
                        bracketForCalculation = replacePlusInLine(bracketForCalculation);
                        long resultofBracket = calculateTimes(bracketForCalculation);
                        return replaceBracketInLine(input.replace(bracket, "" + resultofBracket));
                    }
                }
            }
        }
        return input;
    }


    public static String replacePlusInLine(String input) {
        String[] allNumbersAndFactors = input.split(" ");
        for (int i = 0; i < allNumbersAndFactors.length; i++) {
            if (allNumbersAndFactors[i].equals("+")) {
                long leftFactor = Long.parseLong(allNumbersAndFactors[i - 1]);
                long rightFactor = Long.parseLong(allNumbersAndFactors[i + 1]);
                String plusTerm = leftFactor + " + " + rightFactor;
                long resultOfPlus = leftFactor + rightFactor;
                String nextInput = StringUtils.replaceOnce(input, plusTerm, "" + resultOfPlus);
                return replacePlusInLine(nextInput);
            }
        }
        return input;
    }

    public static long calculateTimes(String input) {
        String[] allNumbersAndFactors = input.split(" ");
        long result = Long.parseLong((allNumbersAndFactors[0]));
        for (int i = 2; i < allNumbersAndFactors.length; i += 2) {
            result = result * Long.parseLong((allNumbersAndFactors[i]));
        }
        return result;
    }


}