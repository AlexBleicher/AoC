package AoC2025.Day6;

import java.util.ArrayList;
import java.util.List;

public class Problem {

    private List<Long> numbers = new ArrayList<>();
    private char operator;


    public void addNumber(Long n) {
        numbers.add(n);
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public long calc() {
        long res = 0;
        if (operator == '*') {
            res = 1;
            for (Long number : numbers) {
                res *= number;
            }
        } else if (operator == '+') {
            for (Long number : numbers) {
                res += number;
            }
        }
        return res;
    }
}
