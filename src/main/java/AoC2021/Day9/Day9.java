package AoC2021.Day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    private List<HeightLevel> allHeightLevels;
    private List<HeightLevel> allLowPoints = new ArrayList<>();

    public Day9(String input) {
        this.allHeightLevels = new Input(input).splitInput();
    }

    public int task1() {
        int sumOfRiskLevels = 0;
        for (HeightLevel heightLevel : allHeightLevels) {
            if (heightLevel.isLowPoint()) {
                allLowPoints.add(heightLevel);
            }
        }
        for (HeightLevel lowPoint : allLowPoints) {
            sumOfRiskLevels += (1 + lowPoint.getValue());
        }
        return sumOfRiskLevels;
    }

    public long task2() {
        List<Integer> allBasinSizes = findAllBasinSizes();
        allBasinSizes.sort(Collections.reverseOrder());
        return (long) allBasinSizes.get(0) * allBasinSizes.get(1) * allBasinSizes.get(2);
    }

    public List<Integer> findAllBasinSizes() {
        List<Integer> basinSizes = new ArrayList<>();
        for (HeightLevel heightLevel : allHeightLevels) {
            if (heightLevel.isLowPoint()) {
                allLowPoints.add(heightLevel);
            }
        }
        for (HeightLevel lowPoint : allLowPoints) {
            basinSizes.add(getBasin(lowPoint).size());
        }
        return basinSizes;
    }

    public List<HeightLevel> getBasin(HeightLevel point) {
        List<HeightLevel> basin = new ArrayList<>();
        basin.add(point);
        for (int i = 0; i < basin.size(); i++) {
            HeightLevel currentPoint = basin.get(i);
            HeightLevel up = currentPoint.getAdjacentUp();
            HeightLevel left = currentPoint.getAdjacentLeft();
            HeightLevel down = currentPoint.getAdjacentDown();
            HeightLevel right = currentPoint.getAdjacentRight();
            addPoint(basin, up);
            addPoint(basin, left);
            addPoint(basin, down);
            addPoint(basin, right);
        }
        return basin;
    }

    public void addPoint(List<HeightLevel> basin, HeightLevel point) {
        if (point != null && !basin.contains(point) && point.getValue() != 9) {
            basin.add(point);
        }
    }
}
