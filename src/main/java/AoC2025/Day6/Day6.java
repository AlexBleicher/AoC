package AoC2025.Day6;

import java.util.List;

public class Day6 {

    private List<Problem> problemList;
    private List<Problem> problemListTask2;

    public Day6(String i) {
        problemList = new Input(i).parseInput();
        problemListTask2 = new Input(i).parseInputTask2();
    }

    public long task1() {
        long res = 0;
        for (Problem problem : problemList) {
            res += problem.calc();
        }
        return res;
    }

    public long task2() {
        long res = 0;
        for (Problem problem : problemListTask2) {
            res += problem.calc();
        }
        return res;
    }
}
