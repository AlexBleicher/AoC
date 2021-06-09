package AoC2020.Day18.Task1;

public class Term {
    int leftFactor;
    int rightFactor;
    char operator;

    public Term(int leftFactor, int rightFactor, char operator) {
        this.leftFactor = leftFactor;
        this.rightFactor = rightFactor;
        this.operator = operator;
    }

    public int calculate() {
        if (operator == '*') {
            return leftFactor * rightFactor;
        }
        return leftFactor + rightFactor;
    }
}
