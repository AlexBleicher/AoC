package AoC2021.Day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day12 {

    private List<Cave> allCaves;
    private Set<List<Cave>> allPossiblePaths = new HashSet<>();

    public Day12(String input) {
        allCaves = new Input(input).splitInput();
    }

    public int task1() {
        findAllPossiblePaths();
        return allPossiblePaths.size();
    }

    public void findAllPossiblePaths() {
        Cave start = allCaves.get(allCaves.indexOf(new Cave("start", true)));
        start.findAllPathsToEnd(new ArrayList<>());
        allPossiblePaths.addAll(start.findAllPathsToEnd(new ArrayList<>()));
    }

    public int task2() {
        return findAllPossiblePaths2();
    }

    public int findAllPossiblePaths2() {
        Cave start = allCaves.get(allCaves.indexOf(new Cave("start", true)));
        return start.findAllPathsToEnd2(new HashSet<>(), false);
    }

}
