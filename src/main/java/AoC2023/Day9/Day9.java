package AoC2023.Day9;

import java.util.List;

public class Day9 {

    private List<History> histories;

    public Day9(String i) {
        histories = new Input(i).parseInput();
    }

    public long task1() {
        return histories.stream().map(History::predictNextValue).reduce(Integer::sum).get();
    }

    public long task2() {
        return histories.stream().map(History::predictPrevValue).reduce(Integer::sum).get();
    }
}
