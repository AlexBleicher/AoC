package AoC2019.Day3;

import java.util.List;
import java.util.stream.Collectors;

public class Day3 {

    private Wire wire1;
    private Wire wire2;

    public Day3(String input) {
        wire1 = new Wire(new Input(input).transformInput()[0]);
        wire2 = new Wire(new Input(input).transformInput()[1]);
    }

    public int task1() {
        List<Coordinate> intersectionPoints = getIntersectionPoints();
        return intersectionPoints.stream()
                .mapToInt(Coordinate::calculateManhattanDistanceToOrigin)
                .min()
                .orElseThrow(RuntimeException::new);
    }

    public int task2() {
        List<Coordinate> intersectionPointsWithCombinedSteps = getIntersectionPoints();
        intersectionPointsWithCombinedSteps.forEach(coordinate1 -> coordinate1.addStepsNeeded(
                wire2.getCoordinates().stream()
                        .filter(coordinate1::equals)
                        .findFirst()
                        .get()
                        .getStepsNeeded()));
        return intersectionPointsWithCombinedSteps.stream()
                .mapToInt(Coordinate::getStepsNeeded)
                .min()
                .orElseThrow(RuntimeException::new);
    }

    public List<Coordinate> getIntersectionPoints() {
        return wire1.getCoordinates().stream()
                .filter(wire2.getCoordinates()::contains)
                .collect(Collectors.toList());
    }
}
