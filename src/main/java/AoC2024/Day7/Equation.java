package AoC2024.Day7;

import java.util.List;

public class Equation {
    private long sol;
    private List<Long> numbers;

    public Equation() {
    }

    public long getSol() {
        return sol;
    }

    public void setSol(long sol) {
        this.sol = sol;
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }

    public void addToNumbers(Long n) {
        numbers.add(n);
    }
}
