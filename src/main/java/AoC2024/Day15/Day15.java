package AoC2024.Day15;

import java.util.List;

public class Day15 {

    private char[][] map;
    private List<Character> instructions;
    private char[][] map2;
    private int robotX;
    private int robotY;

    public Day15(String i) {
        Input input = new Input(i);
        map = input.parseInputMap();
        map2 = input.parseInputMap2();
        instructions = input.parseInputInstructions();
        for (int y = 0; y < map.length; y++) {
            char[] chars = map[y];
            for (int x = 0; x < chars.length; x++) {
                if (chars[x] == '@') {
                    robotX = x;
                    robotY = y;
                }
            }
        }
    }

    public long task1() {
        for (Character instruction : instructions) {
            move(robotY, robotX, instruction, '@');
        }
        long res = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 'O') {
                    res += 100L * y + x;
                }
            }
        }
        return res;
    }

    private boolean move(int y, int x, char dir, char charToSet) {
        int nextX;
        int nextY;
        if (dir == '<') {
            nextX = x - 1;
            nextY = y;
        } else if (dir == '>') {
            nextX = x + 1;
            nextY = y;
        } else if (dir == '^') {
            nextY = y - 1;
            nextX = x;
        } else if (dir == 'v') {
            nextY = y + 1;
            nextX = x;
        } else {
            nextX = x;
            nextY = y;
            throw new RuntimeException("Not possible");
        }

        if (map[nextY][nextX] == '#') {
            return false;
        }
        if (map[nextY][nextX] == 'O') {
            boolean o = move(nextY, nextX, dir, 'O');
            if (o) {
                map[nextY][nextX] = charToSet;
                if (charToSet == '@') {
                    robotX = nextX;
                    robotY = nextY;
                    map[y][x] = '.';
                }
                return true;
            }
            return false;
        }
        if (map[nextY][nextX] == '.') {
            map[nextY][nextX] = charToSet;
            if (charToSet == '@') {
                robotX = nextX;
                robotY = nextY;
                map[y][x] = '.';
            }
            return true;
        } else {
            char charToExpect = map[nextY][nextX];
            throw new RuntimeException("This should not be in the map");
        }
    }

    public long task2() {
        for (int y = 0; y < map2.length; y++) {
            for (int x = 0; x < map2[y].length; x++) {
                if (map2[y][x] == '@') {
                    robotX = x;
                    robotY = y;
                }
            }
        }
        for (Character instruction : instructions) {
            move2(robotY, robotX, instruction, '@');
        }
        long res = 0;
        for (int y = 0; y < map2.length; y++) {
            for (int x = 0; x < map2[y].length; x++) {
                if (map2[y][x] == '[') {
                    res += 100L * y + x;
                }
            }
        }
        return res;
    }

    private boolean move2Possible(int y, int x, char dir) {
        int nextX;
        int nextY;
        if (dir == '<') {
            nextX = x - 1;
            nextY = y;
        } else if (dir == '>') {
            nextX = x + 1;
            nextY = y;
        } else if (dir == '^') {
            nextY = y - 1;
            nextX = x;
        } else if (dir == 'v') {
            nextY = y + 1;
            nextX = x;
        } else {
            nextX = x;
            nextY = y;
            throw new RuntimeException("Not possible");
        }

        if (map2[nextY][nextX] == '#') {
            return false;
        } else if (map2[nextY][nextX] == '[' && (dir == '^' || dir == 'v')) {
            boolean notBlocked = move2Possible(nextY, nextX, dir);
            if (!notBlocked) {
                return false;
            } else {
                return move2Possible(nextY, nextX + 1, dir);
            }
        } else if (map2[nextY][nextX] == ']' && (dir == '^' || dir == 'v')) {
            boolean notBlocked = move2Possible(nextY, nextX, dir);
            if (!notBlocked) {
                return false;
            } else {
                return move2Possible(nextY, nextX - 1, dir);
            }
        } else if ((map2[nextY][nextX] == '[' || map2[nextY][nextX] == ']') && (dir == '<' || dir == '>')) {
            return move2Possible(nextY, nextX, dir);
        } else if (map2[nextY][nextX] == '.') {
            return true;
        } else {
            char charToExpect = map2[nextY][nextX];
            throw new RuntimeException("This should not be in the map");
        }
    }

    private void move2(int y, int x, char dir, char charToSet) {
        int nextX;
        int nextY;
        if (dir == '<') {
            nextX = x - 1;
            nextY = y;
        } else if (dir == '>') {
            nextX = x + 1;
            nextY = y;
        } else if (dir == '^') {
            nextY = y - 1;
            nextX = x;
        } else if (dir == 'v') {
            nextY = y + 1;
            nextX = x;
        } else {
            nextX = x;
            nextY = y;
            throw new RuntimeException("Not possible");
        }

        if (move2Possible(y, x, dir)) {
            if (map2[nextY][nextX] == '[' && (dir == '^' || dir == 'v')) {
                move2(nextY, nextX, dir, '[');
                move2(nextY, nextX + 1, dir, ']');
            } else if (map2[nextY][nextX] == ']' && (dir == '^' || dir == 'v')) {
                move2(nextY, nextX, dir, ']');
                move2(nextY, nextX - 1, dir, '[');
            } else if (map2[nextY][nextX] != '.') {
                move2(nextY, nextX, dir, map2[nextY][nextX]);
            }
            map2[nextY][nextX] = charToSet;
            map2[y][x] = '.';
            if (charToSet == '@') {
                robotY = nextY;
                robotX = nextX;
            }
        }
    }


}
