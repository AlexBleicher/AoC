package AoC2025.Day7;

import java.util.HashMap;
import java.util.Map;

public class Day7 {

    Map<Tuple, Long> alreadySeen = new HashMap<>();
    private char[][] map;

    public Day7(String i) {
        map = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (int y = 1; y < map.length; y++) {
            char[] line = map[y];
            for (int x = 0; x < line.length; x++) {
                if (map[y - 1][x] == 'S' || map[y - 1][x] == '|') {
                    if (map[y][x] == '^') {
                        map[y][x - 1] = '|';
                        map[y][x + 1] = '|';
                        res++;
                    } else {
                        map[y][x] = '|';
                    }
                }
            }
        }
        return res;
    }

    public long task2() {
        long res = 0;
        res = traversePath(map, 1);
        return res;
    }

    public long traversePath(char[][] mapTillNow, int currentY) {
        long r = 0;
        if (currentY < mapTillNow.length) {
            char[][] cloneMap = new char[mapTillNow.length][mapTillNow[0].length];
            for (int y = 0; y <= currentY; y++) {
                char[] line = mapTillNow[y];
                System.arraycopy(mapTillNow[y], 0, cloneMap[y], 0, line.length);
            }
            for (int y = currentY + 1; y < cloneMap.length; y++) {
                System.arraycopy(map[y], 0, cloneMap[y], 0, cloneMap[0].length);
            }

            for (int y = currentY; y < mapTillNow.length; y++) {
                char[] line = mapTillNow[y];
                for (int x = 0; x < line.length; x++) {
                    Tuple t = new Tuple();
                    t.setyIndex(y - 1);
                    t.setxIndex(x);
                    if (cloneMap[y - 1][x] == 'S' || cloneMap[y - 1][x] == '|') {
                        if (alreadySeen.containsKey(t)) {
                            return alreadySeen.get(t);
                        }
                        if (cloneMap[y][x] == '^') {
                            t.setyIndex(y);
                            cloneMap[y][x - 1] = '|';
                            long v = traversePath(cloneMap, y + 1);
                            t.setxIndex(x - 1);
                            alreadySeen.put(t, v);
                            r += v;
                            cloneMap[y][x - 1] = '.';
                            cloneMap[y][x + 1] = '|';
                            v = traversePath(cloneMap, y + 1);
                            t.setxIndex(x + 1);
                            alreadySeen.put(t, v);
                            r += v;
                            cloneMap[y][x + 1] = '.';
                            return r;

                        } else {
                            cloneMap[y][x] = '|';
                            return traversePath(cloneMap, y + 1);
                        }
                    }
                }
            }
        }
        return r += 1;
    }
}
