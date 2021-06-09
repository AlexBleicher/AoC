package AoC2020.Day17.Task1;

import java.util.ArrayList;
import java.util.List;

public class Day17Task1 {

    private static Input input = new Input();
    private static List<Cube> cubeList = input.getAllCubes();

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        setNeighbors();
        for (int i = 0; i < 6; i++) {
            cycle();
        }
        System.out.println(countActiveCubes());
        long timeEnd = System.currentTimeMillis();
        System.out.println("Gebrauchte Zeit insgesamt in Millisekunden: " + (timeEnd - timeStart));
    }

    public static void cycle() {
        long timeStart = System.currentTimeMillis();
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
        for (Cube cube : cubeList) {
            cube.setAlive(newState.get(cubeList.indexOf(cube)).isAlive());
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Gebrauchte Rundenzeit in Millisekunden: " + (timeEnd - timeStart));
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
        long timeStart = System.currentTimeMillis();
        for (Cube cube : cubeList) {
            Coordinate currentCoordinate = cube.getCoordinate();
            for (Cube nextCube : cubeList) {
                if (cube.getNeighbors().size() == 26) {
                    break;
                }
                if (currentCoordinate.isNeighbor(nextCube.getCoordinate())) {
                    cube.addNeighbor(nextCube);
                }
            }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Gebrauchte Zeit zum Finden der Nachbarn in Millisekunden: " + (timeEnd - timeStart));
    }
}
