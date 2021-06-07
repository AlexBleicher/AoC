package AoC2020.Day17.Task1;

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
            Cube newCube = new Cube(cube.isAlive(), cube.getCoordinate());
            int amountOfActiveNeighbors = cube.getAmountOfActiveNeighbors();
            if (cube.isAlive()) {
                if (!(amountOfActiveNeighbors == 2 || amountOfActiveNeighbors == 3)) {
                    newCube.setAlive(false);
                }
            } else if (!cube.isAlive()) {
                if (amountOfActiveNeighbors == 3) {
                    newCube.setAlive(true);
                }
            }
            newState.add(newCube);
        }
        return newState;
    }

    public static int countActiveCubes() {
        int amountOfActiveCubes = 0;
        for (Cube cube : cubeList) {
            if (cube.isAlive()) {
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
                if (currentCube.getNeighbors().size() == 26) {
                    break;
                }
                if (currentCoordinate.isNeighbor(nextCube.getCoordinate())) {
                    currentCube.addNeighbor(nextCube);
                }
            }
        }
    }
}
