package AoC2024.Day7;

import java.util.List;

public class Day7 {

    private List<Equation> equations;

    public Day7(String i) {
        equations = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (Equation equation : equations) {
            if (isPossible(equation, true)) {
                res += equation.getSol();
            }
        }
        return res;
    }

    public long task2() {
        long res = 0;
        for (Equation equation : equations) {
            if (isPossible(equation, false)) {
                res += equation.getSol();
            }
        }
        return res;
    }

    private boolean isPossible(Equation e, boolean isTask1) {
        long testValue = e.getSol();
        long currentAmount = e.getNumbers().get(0);
        if (checkIfNextOperatorPlus(testValue, currentAmount, e.getNumbers(), 1, isTask1)) {
            return true;
        }
        if (!isTask1) {
            if (checkIfNextOperatorConcat(testValue, currentAmount, e.getNumbers(), 1, isTask1)) {
                return true;
            }
        }
        return checkIfNextOperatorMul(testValue, currentAmount, e.getNumbers(), 1, isTask1);
    }

    private boolean checkIfNextOperatorPlus(long testValue, long ca, List<Long> numbers, int index, boolean isTask1) {
        if (index < numbers.size()) {
            ca += numbers.get(index);
            if (ca > testValue) {
                return false;
            }
            if (checkIfNextOperatorPlus(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
            if (!isTask1) {
                if (checkIfNextOperatorConcat(testValue, ca, numbers, index + 1, isTask1)) {
                    return true;
                }
            }
            return checkIfNextOperatorMul(testValue, ca, numbers, index + 1, isTask1);
        } else {
            return ca == testValue;
        }
    }

    private boolean checkIfNextOperatorMul(long testValue, long ca, List<Long> numbers, int index, boolean isTask1) {
        if (index < numbers.size()) {
            ca *= numbers.get(index);
            if (ca > testValue) {
                return false;
            }
            if (checkIfNextOperatorPlus(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
            if (!isTask1) {
                if (checkIfNextOperatorConcat(testValue, ca, numbers, index + 1, isTask1)) {
                    return true;
                }
            }
            return checkIfNextOperatorMul(testValue, ca, numbers, index + 1, isTask1);
        } else {
            return ca == testValue;
        }
    }

    private boolean checkIfNextOperatorConcat(long testValue, long ca, List<Long> numbers, int index, boolean isTask1) {
        if (index < numbers.size()) {
            ca = Long.parseLong(("" + ca).concat("" + numbers.get(index)));
            if (ca > testValue) {
                return false;
            }
            if (checkIfNextOperatorPlus(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
            if (checkIfNextOperatorConcat(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
            return checkIfNextOperatorMul(testValue, ca, numbers, index + 1, isTask1);
        } else {
            return ca == testValue;
        }
    }
}
