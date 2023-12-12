package AoC2023.Day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day12 {

    private List<Row> rows;

    public Day12(String i) {
        rows = new Input(i).parseInput();
    }

    public int task1() {
        List<Set<String>> possibleArrangements = new ArrayList<>();
        for (Row row : rows) {
            possibleArrangements.add(row.getPossibleArrangements(row.getGears(), new HashSet<>()));
        }
        return possibleArrangements.stream().map(Set::size).reduce(Integer::sum).get();
    }

    public long task2() {
        List<Row> extendedRows = new ArrayList<>();
        for (Row row : rows) {
            List<Integer> originalnumbers = row.getDamagedGroups();
            List<Gear> originalgears = row.getGears();
            List<Integer> numbers = new ArrayList<>();
            List<Gear> gears = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                if (i > 0) {
                    gears.add(new Gear('?'));
                }
                for (Gear gear : originalgears) {
                    gears.add(new Gear(gear.getStatus()));
                }
                numbers.addAll(originalnumbers);
            }
            extendedRows.add(new Row(gears, numbers));
        }
        List<Set<String>> possibleArrangements = new ArrayList<>();
        for (Row row : extendedRows) {
            possibleArrangements.add(row.getPossibleArrangements(row.getGears(), new HashSet<>()));
        }
        return possibleArrangements.stream().map(Set::size).map(Long::valueOf).reduce(Long::sum).get();
    }
}
