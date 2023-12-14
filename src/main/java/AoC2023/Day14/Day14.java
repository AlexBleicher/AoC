package AoC2023.Day14;

import java.util.HashMap;
import java.util.Map;

public class Day14 {
    private Character[][] map;

    public Day14(String i) {
        map = new Input(i).parseInput();
    }

    public long task1() {
        boolean rockMoved = false;
        do {
            rockMoved = false;
            for (int y = 1; y < map.length; y++) {
                for (int x = 0; x < map[0].length; x++) {
                    Character c = map[y][x];
                    if (c == 'O' && map[y - 1][x] == '.') {
                        map[y - 1][x] = 'O';
                        map[y][x] = '.';
                        rockMoved = true;
                    }
                }
            }
        } while (rockMoved);
        long res = 0;
        for (int y = 0; y < map.length; y++) {
            int countRoundRocks = 0;
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 'O') {
                    countRoundRocks++;
                }
            }
            res += (long) (map.length - y) * countRoundRocks;
        }
        return res;
    }

    public long task2() {
        Map<String, Integer> configurationToIndex = new HashMap<>();
        int lastI = 0;
        int stepWidth = 1;
        for (int i = 0; i < 1000000000; i += stepWidth) {
            if (stepWidth == 1) {
                String mapString = "";
                for (int y = 0; y < map.length; y++) {
                    for (int x = 0; x < map[0].length; x++) {
                        mapString += map[y][x];
                    }
                    mapString += "\n";
                }

                if (configurationToIndex.containsKey(mapString)) {
                    if (stepWidth == 1) {
                        stepWidth = i - configurationToIndex.get(mapString);
                    }
                } else {
                    tilt('n');
                    tilt('w');
                    tilt('s');
                    tilt('e');
                    configurationToIndex.put(mapString, i);
                }
            }
            if (i % 10000000 == 0) {
                System.out.println(1000000000 - i);
            }
            lastI = i;
        }
        for (int i = lastI; i < 1000000000; i++) {
            tilt('n');
            tilt('w');
            tilt('s');
            tilt('e');
        }
        long res = 0;
        for (int y = 0; y < map.length; y++) {
            int countRoundRocks = 0;
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 'O') {
                    countRoundRocks++;
                }
            }
            res += (long) (map.length - y) * countRoundRocks;
        }
        return res;
    }

    private void tilt(char direction) {
        boolean rockMoved = false;
        do {
            rockMoved = false;
            if (direction == 'n') {
                for (int y = 1; y < map.length; y++) {
                    for (int x = 0; x < map[0].length; x++) {
                        Character c = map[y][x];
                        if (c == 'O' && map[y - 1][x] == '.') {
                            map[y - 1][x] = 'O';
                            map[y][x] = '.';
                            rockMoved = true;
                        }
                    }
                }
            } else if (direction == 's') {
                for (int y = 0; y < map.length - 1; y++) {
                    for (int x = 0; x < map[0].length; x++) {
                        Character c = map[y][x];
                        if (c == 'O' && map[y + 1][x] == '.') {
                            map[y + 1][x] = 'O';
                            map[y][x] = '.';
                            rockMoved = true;
                        }
                    }
                }
            } else if (direction == 'w') {
                for (int y = 0; y < map.length; y++) {
                    for (int x = 1; x < map[0].length; x++) {
                        Character c = map[y][x];
                        if (c == 'O' && map[y][x - 1] == '.') {
                            map[y][x - 1] = 'O';
                            map[y][x] = '.';
                            rockMoved = true;
                        }
                    }
                }
            } else if (direction == 'e') {
                for (int y = 0; y < map.length; y++) {
                    for (int x = 0; x < map[0].length - 1; x++) {
                        Character c = map[y][x];
                        if (c == 'O' && map[y][x + 1] == '.') {
                            map[y][x + 1] = 'O';
                            map[y][x] = '.';
                            rockMoved = true;
                        }
                    }
                }
            }
        } while (rockMoved);
    }
}
