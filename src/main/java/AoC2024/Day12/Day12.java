package AoC2024.Day12;

import java.util.List;

public class Day12 {

    private List<Region> regions;

    public Day12(String i) {
        regions = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (Region region : regions) {
            long area = region.getPositions().size();
            long perimeter = region.calculatePerimeter();
            res += area * perimeter;
        }
        return res;
    }

    public long task2() {
        long res = 0;
        for (Region region : regions) {
            long area = region.getPositions().size();
            long sides = region.calculateSides();
            res += area * sides;
        }
        return res;
    }
}
