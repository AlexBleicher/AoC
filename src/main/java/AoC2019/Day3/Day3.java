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
        List<Coordinate> intersectionPoints = wire1.getCoordinates().stream()
                .filter(wire2.getCoordinates()::contains)
                .collect(Collectors.toList());
        return intersectionPoints.stream()
                .mapToInt(Coordinate::calculateManhattanDistanceToOrigin)
                .min()
                .orElseThrow(RuntimeException::new);
    }
}
