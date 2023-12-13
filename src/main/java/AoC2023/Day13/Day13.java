package AoC2023.Day13;

import java.util.List;

public class Day13 {

    private List<Character[][]> patterns;

    public Day13(String i) {
        patterns = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (Character[][] pattern : patterns) {
            boolean hasHorizontalReflection = false;
            for (int y = 0; y < pattern.length - 1 && !hasHorizontalReflection; y++) {
                boolean reflectionPossible = true;
                int rowAboveReflectionIndex = y;
                int rowBelowReflectionIndex = y + 1;
                while (reflectionPossible && rowAboveReflectionIndex >= 0 && rowBelowReflectionIndex <= pattern.length - 1) {
                    Character[] rowAbove = pattern[rowAboveReflectionIndex--];
                    Character[] rowBelow = pattern[rowBelowReflectionIndex++];
                    for (int i = 0; i < rowAbove.length && reflectionPossible; i++) {
                        if (rowAbove[i] != rowBelow[i]) {
                            reflectionPossible = false;
                        }
                    }
                }
                if (reflectionPossible) {
                    hasHorizontalReflection = true;
                    res += 100 * (y + 1);
                }
            }
            if (!hasHorizontalReflection) {
                boolean reflectionFound = false;
                for (int x = 0; x < pattern[0].length && !reflectionFound; x++) {
                    boolean reflectionPossible = true;
                    int columnLeftReflectionIndex = x;
                    int columnRightReflectionIndex = x + 1;
                    while (reflectionPossible && columnLeftReflectionIndex >= 0 && columnRightReflectionIndex <= pattern[0].length - 1) {
                        for (int y = 0; y < pattern.length && reflectionPossible; y++) {
                            if (pattern[y][columnLeftReflectionIndex] != pattern[y][columnRightReflectionIndex]) {
                                reflectionPossible = false;
                            }
                        }
                        columnLeftReflectionIndex--;
                        columnRightReflectionIndex++;
                    }
                    if (reflectionPossible) {
                        reflectionFound = true;
                        res += x + 1;
                    }
                }
            }
        }
        return res;
    }

    public long task2() {
        long res = 0;
        for (Character[][] pattern : patterns) {
            boolean foundSmudge = false;
            for (int y = 0; y < pattern.length && !foundSmudge; y++) {
                for (int x = 0; x < pattern[0].length && !foundSmudge; x++) {
                    char original = pattern[y][x];
                    long s = hasMirror(pattern);
                    if (original == '#') {
                        pattern[y][x] = '.';
                    } else {
                        pattern[y][x] = '#';
                    }
                    long r = hasMirrorWithCheck(pattern, s);
                    if (r != -1) {
                        foundSmudge = true;
                    }
                    if (foundSmudge) {
                        res += r;
                    } else {
                        pattern[y][x] = original;
                    }
                }
            }
        }
        return res;
    }

    public long hasMirror(Character[][] pattern) {
        boolean hasHorizontalReflection = false;
        for (int y = 0; y < pattern.length - 1 && !hasHorizontalReflection; y++) {
            boolean reflectionPossible = true;
            int rowAboveReflectionIndex = y;
            int rowBelowReflectionIndex = y + 1;
            while (reflectionPossible && rowAboveReflectionIndex >= 0 && rowBelowReflectionIndex <= pattern.length - 1) {
                Character[] rowAbove = pattern[rowAboveReflectionIndex--];
                Character[] rowBelow = pattern[rowBelowReflectionIndex++];
                for (int i = 0; i < rowAbove.length && reflectionPossible; i++) {
                    if (rowAbove[i] != rowBelow[i]) {
                        reflectionPossible = false;
                    }
                }
            }
            if (reflectionPossible) {
                return 100 * (y + 1);
            }
        }
        if (!hasHorizontalReflection) {
            boolean reflectionFound = false;
            for (int x = 0; x < pattern[0].length - 1 && !reflectionFound; x++) {
                boolean reflectionPossible = true;
                int columnLeftReflectionIndex = x;
                int columnRightReflectionIndex = x + 1;
                while (reflectionPossible && columnLeftReflectionIndex >= 0 && columnRightReflectionIndex <= pattern[0].length - 1) {
                    for (int y = 0; y < pattern.length && reflectionPossible; y++) {
                        if (pattern[y][columnLeftReflectionIndex] != pattern[y][columnRightReflectionIndex]) {
                            reflectionPossible = false;
                        }
                    }
                    columnLeftReflectionIndex--;
                    columnRightReflectionIndex++;
                }
                if (reflectionPossible) {
                    return x + 1;
                }
            }
        }
        return -1;
    }

    private long hasMirrorWithCheck(Character[][] pattern, long s) {
        for (int y = 0; y < pattern.length - 1; y++) {
            boolean reflectionPossible = true;
            int rowAboveReflectionIndex = y;
            int rowBelowReflectionIndex = y + 1;
            while (reflectionPossible && rowAboveReflectionIndex >= 0 && rowBelowReflectionIndex <= pattern.length - 1) {
                Character[] rowAbove = pattern[rowAboveReflectionIndex--];
                Character[] rowBelow = pattern[rowBelowReflectionIndex++];
                for (int i = 0; i < rowAbove.length && reflectionPossible; i++) {
                    if (rowAbove[i] != rowBelow[i]) {
                        reflectionPossible = false;
                    }
                }
            }
            if (reflectionPossible) {
                long r = 100 * (y + 1);
                if (r != s) {
                    return r;
                }
            }
        }
        boolean reflectionFound = false;
        for (int x = 0; x < pattern[0].length - 1 && !reflectionFound; x++) {
            boolean reflectionPossible = true;
            int columnLeftReflectionIndex = x;
            int columnRightReflectionIndex = x + 1;
            while (reflectionPossible && columnLeftReflectionIndex >= 0 && columnRightReflectionIndex <= pattern[0].length - 1) {
                for (int y = 0; y < pattern.length && reflectionPossible; y++) {
                    if (pattern[y][columnLeftReflectionIndex] != pattern[y][columnRightReflectionIndex]) {
                        reflectionPossible = false;
                    }
                }
                columnLeftReflectionIndex--;
                columnRightReflectionIndex++;
            }
            if (reflectionPossible) {
                long r = x + 1;
                if (r != s) {
                    return r;
                }
            }
        }
        return -1;
    }
}
