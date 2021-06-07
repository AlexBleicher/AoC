package AoC2020.Day17.Task2;

import java.util.HashSet;
import java.util.Set;

public class Task2 {

    private static Input input = new Input();
    private static Set<Coordinate> allActiveCoordinates = input.getAllFirstActiveCubes();

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            allActiveCoordinates = cycle();
        }
        System.out.println(allActiveCoordinates.size());
    }

    public static Set<Coordinate> cycle() {
        Set<Coordinate> allNeededCoordinates = getAllNeededCoordinates();
        Set<Coordinate> nextActiveCoordinates = new HashSet<>();
        for (Coordinate neededCoordinate : allNeededCoordinates) {
            int activeNeighbors = countActiveNeighbors(neededCoordinate);
            if (allActiveCoordinates.contains(neededCoordinate) && (activeNeighbors == 2 || activeNeighbors == 3)) {
                nextActiveCoordinates.add(neededCoordinate);
            } else if (!allActiveCoordinates.contains(neededCoordinate) && activeNeighbors == 3) {
                nextActiveCoordinates.add(neededCoordinate);
            }
        }
        return nextActiveCoordinates;
    }

    public static Set<Coordinate> getAllNeededCoordinates() {
        Set<Coordinate> allNeededCoordinates = new HashSet<>();
        for (Coordinate activeCoordinate : allActiveCoordinates) {
            allNeededCoordinates.add(activeCoordinate);
            Set<Coordinate> allNeighbors = activeCoordinate.getAllNeighbors();
            allNeededCoordinates.addAll(allNeighbors);
        }
        return allNeededCoordinates;
    }

    public static int countActiveNeighbors(Coordinate coordinate) {
        Set<Coordinate> neighbors = coordinate.getAllNeighbors();
        return (int) neighbors.stream()
                .filter(e -> allActiveCoordinates.contains(e))
                .count();
    }

}
