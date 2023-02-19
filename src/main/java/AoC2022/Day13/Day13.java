package AoC2022.Day13;

import java.util.List;

public class Day13 {

    private List<Pair> pairs;

    public Day13(String input) {
        this.pairs = new Input(input).parseInput();
    }

    public long task1() {
        long result = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).packetsInOrder()) {
                result += i + 1;
            }
        }
        return result;
    }
}
