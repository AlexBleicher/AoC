package AoC2023.Day6;

import java.util.List;

public class Day6 {

    String in;
    private List<Race> raceList;

    public Day6(String i) {
        raceList = new Input(i).parseInput();
        in = i;
    }

    public long task1() {
        return raceList.stream()
                .map(Race::determineWaysToWin)
                .reduce((a, b) -> a * b).get();
    }

    public long task2() {
        Race bigRace = new Input(in).parseInput2();
        return bigRace.determineWaysToWin();
    }
}
