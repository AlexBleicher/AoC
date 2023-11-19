package AoC2022.Day13;

import java.util.List;

public class Day13 {

    private List<Pair> pairs;

    public Day13(String input) {
        this.pairs = new Input(input).parseInput();
    }

    public int solveTask1() {
        int sum = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).isRightOrder()) {
                sum += i + 1;
            }
        }
        return sum;
    }
}
