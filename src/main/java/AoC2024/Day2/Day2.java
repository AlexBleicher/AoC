package AoC2024.Day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    private List<Report> reports;

    public Day2(String i) {
        reports = new Input(i).parseInput();
    }

    public long task1() {
        long safeReports = 0;
        for (Report report : reports) {
            List<Integer> levels = report.getLevels();
            if (checkIfSafe(levels)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    public long task2() {
        long safeReports = 0;
        for (Report report : reports) {
            List<Integer> levels = report.getLevels();
            if (checkIfSafeWithDampener(levels)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    public boolean checkIfSafe(List<Integer> levels) {
        boolean increasing = (levels.get(0) < levels.get(1));
        int i = 0;
        if (increasing) {
            while (increasing && i < levels.size() - 1) {
                Integer i1 = levels.get(i);
                Integer i2 = levels.get(++i);
                if (i2 > i1 + 3 || i2 < i1 + 1) {
                    return false;
                } else {
                    increasing = i1 < i2;
                }
            }
        } else {
            while (!increasing && i < levels.size() - 1) {
                Integer i1 = levels.get(i);
                Integer i2 = levels.get(++i);
                if (i2 < i1 - 3 || i2 > i1 - 1) {
                    return false;
                } else {
                    increasing = i1 < i2;
                }
            }
        }
        return true;
    }

    public boolean checkIfSafeWithDampener(List<Integer> levels) {
        List<Boolean> safeCases = new ArrayList<>();
        safeCases.add(checkIfSafe(levels));
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> levelsWithoutNumber = new ArrayList<>();
            for (int i1 = 0; i1 < levels.size(); i1++) {
                if (i1 != i) {
                    levelsWithoutNumber.add(levels.get(i1));
                }
            }
            safeCases.add(checkIfSafe(levelsWithoutNumber));
        }
        return safeCases.contains(true);
    }

}
