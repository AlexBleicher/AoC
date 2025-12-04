package AoC2025.Day4;

public class Day4 {

    private char[][] array;

    public Day4(String i) {
        array = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                if (array[y][x] == '@') {
                    int countAdjacent = 0;
                    if (y > 0) {
                        if (x > 0 && array[y - 1][x - 1] == '@') {
                            countAdjacent++;
                        }
                        if (x < (array[0].length - 1) && array[y - 1][x + 1] == '@') {
                            countAdjacent++;
                        }
                        if (array[y - 1][x] == '@') {
                            countAdjacent++;
                        }
                    }
                    if (y < array.length - 1) {
                        if (x > 0 && array[y + 1][x - 1] == '@') {
                            countAdjacent++;
                        }
                        if (x < (array[0].length - 1) && array[y + 1][x + 1] == '@') {
                            countAdjacent++;
                        }
                        if (array[y + 1][x] == '@') {
                            countAdjacent++;
                        }
                    }
                    if (x > 0 && array[y][x - 1] == '@') {
                        countAdjacent++;
                    }
                    if (x < array[0].length - 1 && array[y][x + 1] == '@') {
                        countAdjacent++;
                    }
                    if (countAdjacent < 4) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public long task2() {
        long res = 0;
        boolean removed = true;
        while (removed) {
            for (int y = 0; y < array.length; y++) {
                for (int x = 0; x < array[0].length; x++) {
                    if (array[y][x] == '@') {
                        int countAdjacent = 0;
                        if (y > 0) {
                            if (x > 0 && (array[y - 1][x - 1] == '@' || array[y - 1][x - 1] == 'X')) {
                                countAdjacent++;
                            }
                            if (x < (array[0].length - 1) && (array[y - 1][x + 1] == '@' || array[y - 1][x + 1] == 'X')) {
                                countAdjacent++;
                            }
                            if (array[y - 1][x] == '@' || array[y - 1][x] == 'X') {
                                countAdjacent++;
                            }
                        }
                        if (y < array.length - 1) {
                            if (x > 0 && (array[y + 1][x - 1] == '@' || array[y + 1][x - 1] == 'X')) {
                                countAdjacent++;
                            }
                            if (x < (array[0].length - 1) && (array[y + 1][x + 1] == '@' || array[y + 1][x + 1] == 'X')) {
                                countAdjacent++;
                            }
                            if (array[y + 1][x] == '@' || array[y + 1][x] == 'X') {
                                countAdjacent++;
                            }
                        }
                        if (x > 0 && (array[y][x - 1] == '@' || array[y][x - 1] == 'X')) {
                            countAdjacent++;
                        }
                        if (x < array[0].length - 1 && (array[y][x + 1] == '@' || array[y][x + 1] == 'X')) {
                            countAdjacent++;
                        }
                        if (countAdjacent < 4) {
                            res++;
                            array[y][x] = 'X';
                        }
                    }
                }
            }
            removed = false;
            for (int y = 0; y < array.length; y++) {
                for (int x = 0; x < array[0].length; x++) {
                    if (array[y][x] == 'X') {
                        removed = true;
                        array[y][x] = '.';
                    }
                }
            }
        }
        return res;
    }
}
