package AoC2022.Day4;

import java.util.List;

public class Day4 {

    private List<Pair> sectionPairs;

    public Day4(String input){
        sectionPairs = new Input(input).parseInput();
    }

    public int task1(){
        return sectionPairs.stream()
                .mapToInt(Pair::add1IfOneSectionContainsOtherFull).sum();
    }

    public int task2(){
        return sectionPairs.stream()
                .mapToInt(Pair::add1IfSomethingOverlapsAtAll).sum();
    }
}
