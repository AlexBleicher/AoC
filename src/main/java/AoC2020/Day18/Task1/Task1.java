package AoC2020.Day18.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {

    private static List<String> allLines = new Input().parseInput();

    public static void main(String[] args) {

    }

    public static int calculateResultOfAllLines() {
        int resultOfAllLines = 0;
        for (String line : allLines) {

        }
        return resultOfAllLines;
    }

    public static List<String> splitLineToFactors(String line) {
        List<String> factors = new ArrayList<>();
        Collections.addAll(factors, line.split(")"));
        return factors;
    }

    public static int calculateTerm(String termString) {

        //Term term = new Term();
        //return term.calculate();
        return 0;
    }
}
