package AoC2024.Day8;

public class Day8 {
    private char[][] map;
    private char[][] antinodeMap;

    public Day8(String i) {
        map = new Input(i).parseInput();
        antinodeMap = new char[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                antinodeMap[y][x] = '.';
            }
        }
    }

    public long task1() {
        long countAntinodes = 0;
        for (int ay = 0; ay < map.length; ay++) {
            for (int ax = 0; ax < map[0].length; ax++) {
                for (int oy = 0; oy < map.length; oy++) {
                    for (int ox = 0; ox < map[0].length; ox++) {
                        if (map[ay][ax] == map[oy][ox] && (ay != oy || ax != ox) && map[ay][ax] != '.') {
                            int absy = Math.abs(ay - oy);
                            int absx = Math.abs(ax - ox);
                            int yToSet = Math.min(ay, oy) - absy;
                            boolean rightLine = ((ay == Math.max(ay, oy) && ax == Math.max(ax, ox)) || (oy == Math.max(ay, oy) && ox == Math.max(ax, ox)));
                            if (yToSet >= 0) {
                                int xToSet;
                                if (rightLine) {
                                    xToSet = Math.min(ax, ox) - absx;
                                } else {
                                    xToSet = Math.max(ax, ox) + absx;
                                }
                                if (xToSet >= 0 && xToSet < map[0].length) {
                                    antinodeMap[yToSet][xToSet] = '#';
                                }
                            }
                            yToSet = Math.max(ay, oy) + absy;
                            if (yToSet < map.length) {
                                int xToSet;
                                if (rightLine) {
                                    xToSet = Math.max(ax, ox) + absx;
                                } else {
                                    xToSet = Math.min(ax, ox) - absx;
                                }
                                if (xToSet >= 0 && xToSet < map[0].length) {
                                    antinodeMap[yToSet][xToSet] = '#';
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int y = 0; y < antinodeMap.length; y++) {
            for (int x = 0; x < antinodeMap[0].length; x++) {
                if (antinodeMap[y][x] == '#') {
                    countAntinodes++;
                }
            }
        }
        return countAntinodes;
    }

    public long task2() {
        long countAntinodes = 0;
        for (int ay = 0; ay < map.length; ay++) {
            for (int ax = 0; ax < map[0].length; ax++) {
                for (int oy = 0; oy < map.length; oy++) {
                    for (int ox = 0; ox < map[0].length; ox++) {
                        if (map[ay][ax] == map[oy][ox] && map[ay][ax] != '.') {
                            int absy = Math.abs(ay - oy);
                            int absx = Math.abs(ax - ox);
                            int original_absy = absy;
                            int original_absx = absx;
                            boolean rightLine = ((ay == Math.max(ay, oy) && ax == Math.max(ax, ox)) || (oy == Math.max(ay, oy) && ox == Math.max(ax, ox)));
                            boolean reachedHeight = false;
                            boolean reachedLength = false;
                            boolean wasZero = false;
                            while ((!reachedLength || !reachedHeight) && !wasZero) {
                                int yToSet = Math.min(ay, oy) - absy;
                                if (yToSet >= 0) {
                                    int xToSet;
                                    if (rightLine) {
                                        xToSet = Math.min(ax, ox) - absx;
                                    } else {
                                        xToSet = Math.max(ax, ox) + absx;
                                    }
                                    if (xToSet >= 0 && xToSet < map[0].length) {
                                        antinodeMap[yToSet][xToSet] = '#';
                                    } else {
                                        reachedHeight = true;
                                    }
                                } else {
                                    reachedHeight = true;
                                }
                                yToSet = Math.max(ay, oy) + absy;
                                if (yToSet < map.length) {
                                    int xToSet;
                                    if (rightLine) {
                                        xToSet = Math.max(ax, ox) + absx;
                                    } else {
                                        xToSet = Math.min(ax, ox) - absx;
                                    }
                                    if (xToSet >= 0 && xToSet < map[0].length) {
                                        antinodeMap[yToSet][xToSet] = '#';
                                    } else {
                                        reachedLength = true;
                                    }
                                } else {
                                    reachedLength = true;
                                }
                                absy += original_absy;
                                absx += original_absx;
                                if (absy == 0 && absx == 0) {
                                    wasZero = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int y = 0; y < antinodeMap.length; y++) {
            for (int x = 0; x < antinodeMap[0].length; x++) {
                if (antinodeMap[y][x] == '#') {
                    countAntinodes++;
                }
            }
        }
        return countAntinodes;
    }


}
