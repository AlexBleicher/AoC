package AoC2020.Day17.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Input {
    private String input = "...#..#.\n" +
            ".....##.\n" +
            "##..##.#\n" +
            "#.#.##..\n" +
            "#..#.###\n" +
            "...##.#.\n" +
            "#..##..#\n" +
            ".#.#..#.";

    private List<Cube> knownCubes = new ArrayList<>();
    private int lineLength;
    private int amountOfCycles = 6;

    public List<Cube> getAllCubes() {
        createFirstCubes();
        createAdditionalNeededCubes();
        return knownCubes;
    }

    public void createFirstCubes() {
        List<String> lines = Arrays.asList(input.split("\n"));
        int y = 0;
        for (String line : lines) {
            lineLength = line.length();
            for (int x = 0; x < line.length(); x++) {
                Cube cube;
                Coordinate coordinate = new Coordinate(x, y, 0);
                if (line.charAt(x) == '.') {
                    cube = new Cube(false, coordinate);
                } else {
                    cube = new Cube(true, coordinate);
                }
                knownCubes.add(cube);
            }
            y++;
        }
    }

    public void createAdditionalNeededCubes() {
        List<Coordinate> allNeededCoordinates = new ArrayList<>();
        for (int x = -amountOfCycles; x < amountOfCycles + lineLength; x++) {
            for (int y = -amountOfCycles; y < amountOfCycles + lineLength; y++) {
                for (int z = -amountOfCycles; z < amountOfCycles + lineLength; z++) {
                    allNeededCoordinates.add(new Coordinate(x, y, z));
                }
            }
        }
        for (Coordinate coordinate : allNeededCoordinates) {
            boolean cubeExists = false;
            for (Cube knownCube : knownCubes) {
                if (knownCube.getCoordinate().isEqual(coordinate)) {
                    cubeExists = true;
                    break;
                }
            }
            if (!cubeExists) {
                knownCubes.add(new Cube(false, coordinate));
            }
        }
    }

    public void writeOutField() {
        for (int z = -amountOfCycles; z < amountOfCycles + lineLength; z++) {
            System.out.println("Z == " + z);
            List<Cube> allCubesAtThisZ = new ArrayList<>();
            for (Cube knownCube : knownCubes) {
                if (knownCube.getCoordinate().getZ() == z) {
                    allCubesAtThisZ.add(knownCube);
                }
            }
            for (int y = -amountOfCycles; y < amountOfCycles + lineLength; y++) {
                List<Cube> allCubesAtThisYAndZ = new ArrayList<>();
                for (Cube cube : allCubesAtThisZ) {
                    if (cube.getCoordinate().getY() == y) {
                        allCubesAtThisYAndZ.add(cube);
                    }
                }
                allCubesAtThisYAndZ.sort(Comparator.comparing(Cube::getX));
                for (Cube cube : allCubesAtThisYAndZ) {
                    if (cube.isStatus()) {
                        System.out.print("#");
                    } else
                        System.out.print(".");
                }
                System.out.println(" ");
            }
        }
    }
}
