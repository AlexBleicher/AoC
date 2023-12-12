package AoC2023.Day12;

import java.util.ArrayList;
import java.util.List;

public class Day12 {

    private List<Row> rows;

    public Day12(String i) {
        rows = new Input(i).parseInput();
    }

    public int task1() {
        List<Integer> possibleArrangementsSizes = new ArrayList<>();
        for (Row row : rows) {
            possibleArrangementsSizes.add(row.getPossibleArrangements(row.getGears()).size());
        }
        return possibleArrangementsSizes.stream().reduce(Integer::sum).get();
    }
}
