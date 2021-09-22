package AoC2019.Day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Day3 {

    private ArrayList<ArrayList<String>> instructionList;
    private HashSet<Coordinate> wire1;
    private HashSet<Coordinate> wire2;

    public Day3(String input) {
        this.instructionList = new Input(input).transformInput();
    }

    public HashSet<Coordinate> layOutWire(ArrayList<String> instructions) {
        int currentX = 0;
        int currentY = 0;
        HashSet<Coordinate> allCoordinates = new HashSet<>();
        for (String instruction : instructions) {
            char direction = instruction.charAt(0);
            int nextInt = Integer.parseInt(instruction.substring(1));
            switch (direction) {
                case ('R'):
                    while (currentX < nextInt) {
                        currentX++;
                        Coordinate currentCoordinate = new Coordinate(currentX, currentY);
                        allCoordinates.add(currentCoordinate);
                    }
                    break;
                case ('L'):
                    while (currentX > nextInt) {
                        currentX--;
                        Coordinate currentCoordinate = new Coordinate(currentX, currentY);
                        allCoordinates.add(currentCoordinate);
                    }
                    break;
                case ('U'):
                    while (currentY < nextInt) {
                        currentY++;
                        Coordinate currentCoodinate = new Coordinate(currentX, currentY);
                        allCoordinates.add(currentCoodinate);
                    }
                    break;
                case ('D'):
                    while (currentY > nextInt) {
                        currentY--;
                        Coordinate currentCoordinate = new Coordinate(currentX, currentY);
                        allCoordinates.add(currentCoordinate);
                    }
                    break;
            }
        }
        return allCoordinates;
    }

    public int task1() {
        wire1 = layOutWire(instructionList.get(0));
        wire2 = layOutWire(instructionList.get(1));
        ArrayList<Coordinate> intersectionPoints = new ArrayList<>();
        for (Coordinate coordinate1 : wire1) {
            for (Coordinate coordinate2 : wire2) {
                if (coordinate1.getX() == coordinate2.getX() && coordinate1.getY() == coordinate2.getY()) {
                    intersectionPoints.add(coordinate1);
                }
            }
        }
        intersectionPoints = (ArrayList<Coordinate>) intersectionPoints.stream()
                .sorted(Comparator.comparingInt(Coordinate::calculateManhattanDistanceToOrigin))
                .collect(Collectors.toList());
        return intersectionPoints.get(0).calculateManhattanDistanceToOrigin();
    }
}
