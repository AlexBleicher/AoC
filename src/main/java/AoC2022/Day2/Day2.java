package AoC2022.Day2;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    private List<Round> roundList;

    public Day2(String input, int task) {
        roundList=new Input(input).parseInput(task);
    }

    public long solveTask1(){
        return roundList.stream().mapToInt(Round::getScore).sum();
    }

    public long solveTask2(){
        return roundList.stream().mapToInt(Round::getScore).sum();
    }
}
