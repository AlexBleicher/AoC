package AoC2020.Day17.Task2;

import java.util.ArrayList;
import java.util.List;

public class Day17Task1 {

    private static Input input = new Input();
    private static List<Cube> cubeList = input.getAllCubes();

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            setNeighbors();
            cubeList = cycle();
        }
        System.out.println(countActiveCubes());
    }

    public static List<Cube> cycle() {
        List<Cube> newState = new ArrayList<>();
        for (Cube cube : cubeList) {
            Cube newCube = new Cube(cube.isStatus(), cube.getCoordinate());
            int amountOfActiveNeighbors = cube.getAmountOfActiveNeighbors();
            if (cube.isStatus()) {
                if (!(amountOfActiveNeighbors == 2 || amountOfActiveNeighbors == 3)) {
                    newCube.setStatus(false);
                }
            } else if (!cube.isStatus()) {
                if (amountOfActiveNeighbors == 3) {
                    newCube.setStatus(true);
                }
            }
            newState.add(newCube);
        }
        return newState;
    }

    public static int countActiveCubes() {
        int amountOfActiveCubes = 0;
        for (Cube cube : cubeList) {
            if (cube.isStatus()) {
                amountOfActiveCubes++;
            }
        }
        return amountOfActiveCubes;
    }

    public static void setNeighbors() {
        for (Cube cube : cubeList) {
            Cube currentCube = cube;
            Coordinate currentCoordinate = currentCube.getCoordinate();
            for (Cube nextCube : cubeList) {
                if (currentCube.getNeighbors().size() == 80) {
                    break;
                }
                if (currentCoordinate.isNeighbor(nextCube.getCoordinate())) {
                    currentCube.addNeighbor(nextCube);
                }
            }
        }
    }
}
