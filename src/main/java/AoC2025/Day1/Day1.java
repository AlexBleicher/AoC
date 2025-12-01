package AoC2025.Day1;

import java.util.List;

public class Day1 {

    private List<Integer> turns;

    public Day1(String i) {
        turns = new Input(i).parseInput();
    }

    public int task1() {
        int currentValue = 50;
        int res = 0;
        for (Integer turn : turns) {
            currentValue = (currentValue + turn) % 100;
            if (currentValue == 0) {
                res++;
            }
        }
        return res;
    }
}
