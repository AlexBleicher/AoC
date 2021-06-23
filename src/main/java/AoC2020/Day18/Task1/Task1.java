package AoC2020.Day18.Task1;

import java.util.List;

public class Task1 {

    private static List<String> allLines = new Input().parseInput();

    public static void main(String[] args) {
        System.out.print(calculateResultOfAllLines());
    }

    public static long calculateResultOfAllLines() {
        long resultOfAllLines = 0;
        for (String line : allLines) {
            line = replaceBracketInLine(line);
            resultOfAllLines += calculate(line);
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
                        long resultofBracket = calculate(bracketForCalculation);
                        return replaceBracketInLine(input.replace(bracket, "" + resultofBracket));
                    }
                }
            }
        }
        return input;
    }

    public static long calculate(String input) {
        String[] allNumbersAndFactors = input.split(" ");
        long result = Long.parseLong((allNumbersAndFactors[0]));
        String operator = "+";
        for (int i = 1; i < allNumbersAndFactors.length; i++) {
            if (i % 2 != 0) {
                operator = allNumbersAndFactors[i];
            } else {
                if (operator.equals("+")) {
                    result += Long.parseLong((allNumbersAndFactors[i]));
                } else {
                    result = result * Long.parseLong((allNumbersAndFactors[i]));
                }
            }
        }
        return result;
    }


}
