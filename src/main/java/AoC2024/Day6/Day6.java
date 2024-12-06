package AoC2024.Day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {

    private char[][] map;

    public Day6(String i) {
        map = new Input(i).parseInput();
    }

    public long task1() {
        Set<Position> visitedPositions = new HashSet<>();
        Position guard = new Position(0, 0);
        List<Position> obstacles = new ArrayList<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == '^') {
                    guard.setX(x);
                    guard.setY(y);
                } else if (map[y][x] == '#') {
                    obstacles.add(new Position(y, x));
                }
            }
        }

        Position startGuard = new Position(guard.getY(), guard.getX());
        boolean facingUp = true;
        boolean facingDown = false;
        boolean facingLeft = false;
        boolean facingRight = false;
        boolean guardInMap = guard.getX() >= 0 && guard.getY() >= 0 && guard.getX() <= map[0].length && guard.getY() <= map.length;
        while (guardInMap) {
            visitedPositions.add(guard);

            if (facingUp) {
                Position newPosition = new Position(guard.getY() - 1, guard.getX());
                if (!obstacles.contains(newPosition)) {
                    guard.setY(newPosition.getY());
                } else {
                    facingUp = false;
                    facingRight = true;
                }
            } else if (facingRight) {
                Position newPosition = new Position(guard.getY(), guard.getX() + 1);
                if (!obstacles.contains(newPosition)) {
                    guard.setX(newPosition.getX());
                } else {
                    facingRight = false;
                    facingDown = true;
                }
            } else if (facingDown) {
                Position newPosition = new Position(guard.getY() + 1, guard.getX());
                if (!obstacles.contains(newPosition)) {
                    guard.setY(newPosition.getY());
                } else {
                    facingDown = false;
                    facingLeft = true;
                }
            } else if (facingLeft) {
                Position newPosition = new Position(guard.getY(), guard.getX() - 1);
                if (!obstacles.contains(newPosition)) {
                    guard.setX(newPosition.getX());
                } else {
                    facingLeft = false;
                    facingUp = true;
                }
            }
            guardInMap = guard.getX() >= 0 && guard.getY() >= 0 && guard.getX() < map[0].length && guard.getY() < map.length;
            if (guardInMap) {
                map[guard.getY()][guard.getX()] = 'X';
            }
        }
        map[startGuard.getY()][startGuard.getX()] = '^';
        long countX = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                System.out.print(map[y][x]);
                if (map[y][x] == 'X') {
                    countX++;
                } else if (map[y][x] == '^') {
                    countX++;
                }
            }
            System.out.println();
        }
        return countX;
    }

    public long task2() {
        List<char[][]> maps = new ArrayList<>();
        task1();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char mapToTest[][] = new char[map.length][map[0].length];
                boolean toinclude = false;
                for (int y = 0; y < map.length; y++) {
                    for (int x = 0; x < map[0].length; x++) {
                        if (y == i && x == j && map[y][x] == 'X' && (map[y][x] != '^' || map[y][x] == '#')) {
                            mapToTest[y][x] = 'O';
                            toinclude = true;
                        } else {
                            if (map[y][x] == 'X') {
                                mapToTest[y][x] = '.';
                            } else {
                                mapToTest[y][x] = map[y][x];
                            }
                        }
                    }
                }
                if (toinclude) {
                    maps.add(mapToTest);
                }
            }
        }
        long loopPossible = 0;

        for (char[][] testMap : maps) {
            map = testMap;
            boolean hasLoop = traverseMapLookingForLoops();
            if (hasLoop) {
                loopPossible++;
            }

        }

        return loopPossible;
    }

    private boolean traverseMapLookingForLoops() {
        Position guard = new Position(0, 0);
        List<Position> obstacles = new ArrayList<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == '^') {
                    guard.setX(x);
                    guard.setY(y);
                } else if (map[y][x] == '#' || map[y][x] == 'O') {
                    obstacles.add(new Position(y, x));
                }
            }
        }

        boolean facingUp = true;
        boolean facingDown = false;
        boolean facingLeft = false;
        boolean facingRight = false;
        boolean guardInMap = guard.getX() >= 0 && guard.getY() >= 0 && guard.getX() <= map[0].length && guard.getY() <= map.length;
        while (guardInMap) {
            if (facingUp) {
                Position newPosition = new Position(guard.getY() - 1, guard.getX());
                if (newPosition.getY() >= 0) {
                    if (map[newPosition.getY()][newPosition.getX()] == '+') {
                        return true;
                    }
                    map[newPosition.getY()][newPosition.getX()] = '+';
                }
                if (!obstacles.contains(newPosition)) {
                    guard.setY(newPosition.getY());
                } else {
                    facingUp = false;
                    facingRight = true;
                }
            } else if (facingRight) {
                Position newPosition = new Position(guard.getY(), guard.getX() + 1);
                if (newPosition.getX() < map[0].length) {
                    if (map[newPosition.getY()][newPosition.getX()] == '>') {
                        return true;
                    }
                    map[newPosition.getY()][newPosition.getX()] = '>';
                }
                if (!obstacles.contains(newPosition)) {
                    guard.setX(newPosition.getX());
                } else {
                    facingRight = false;
                    facingDown = true;
                }
            } else if (facingDown) {
                Position newPosition = new Position(guard.getY() + 1, guard.getX());
                if (newPosition.getY() < map.length) {
                    if (map[newPosition.getY()][newPosition.getX()] == '-') {
                        return true;
                    }
                    map[newPosition.getY()][newPosition.getX()] = '-';
                }
                if (!obstacles.contains(newPosition)) {
                    guard.setY(newPosition.getY());
                } else {
                    facingDown = false;
                    facingLeft = true;
                }
            } else if (facingLeft) {
                Position newPosition = new Position(guard.getY(), guard.getX() - 1);
                if (newPosition.getX() >= 0) {
                    if (map[newPosition.getY()][newPosition.getX()] == '<') {
                        return true;
                    }
                    map[newPosition.getY()][newPosition.getX()] = '<';
                }
                if (!obstacles.contains(newPosition)) {
                    guard.setX(newPosition.getX());
                } else {
                    facingLeft = false;
                    facingUp = true;
                }
            }
            guardInMap = guard.getX() >= 0 && guard.getY() >= 0 && guard.getX() < map[0].length && guard.getY() < map.length;
        }
        return false;
    }
}
