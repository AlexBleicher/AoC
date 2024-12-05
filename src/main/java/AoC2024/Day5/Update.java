package AoC2024.Day5;

import java.util.ArrayList;
import java.util.List;

public class Update {

    private List<Long> numbers = new ArrayList<>();

    public void addNumber(long n) {
        numbers.add(n);
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }
}
