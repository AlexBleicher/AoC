package AoC2024.Day13;

import java.util.ArrayList;
import java.util.List;

public class DiophantEquation {

    private long x1;
    private long x2;
    private long y1;
    private long y2;
    private long xres;
    private long yres;
    private long k1;
    private long k2;

    public long getX1() {
        return x1;
    }

    public void setX1(long x1) {
        this.x1 = x1;
    }

    public long getX2() {
        return x2;
    }

    public void setX2(long x2) {
        this.x2 = x2;
    }

    public long getY1() {
        return y1;
    }

    public void setY1(long y1) {
        this.y1 = y1;
    }

    public long getY2() {
        return y2;
    }

    public void setY2(long y2) {
        this.y2 = y2;
    }

    public long getXres() {
        return xres;
    }

    public void setXres(long xres) {
        this.xres = xres;
    }

    public long getYres() {
        return yres;
    }

    public void setYres(long yres) {
        this.yres = yres;
    }

    public long calculateEquation() {
        long gcd = gcdExtended(x1, x2);
        if (xres % gcd != 0) {
            return -1;
        } else {
            long vecX1ToAdd = x2 / gcd;
            long vecX2ToAdd = -x1 / gcd;
            long solutionX1 = k1 * (xres / gcd);
            long solutionX2 = k2 * (xres / gcd);
            long c = solutionX2 / vecX2ToAdd;
            c++;
            solutionX1 = solutionX1 + (-c * vecX1ToAdd);
            solutionX2 = solutionX2 + (-c * vecX2ToAdd);
            List<List<Long>> allPossibleSolutionsWithBothPositive = new ArrayList<>();
            List<Long> solutionList = new ArrayList<>();
            solutionList.add(solutionX1);
            solutionList.add(solutionX2);
            allPossibleSolutionsWithBothPositive.add(solutionList);
            while ((solutionX1 + (-1 * vecX1ToAdd) >= 0) && (solutionX2 + (-1 * vecX2ToAdd) >= 0)) {
                solutionX1 = solutionX1 + (-1 * vecX1ToAdd);
                solutionX2 = solutionX2 + (-1 * vecX2ToAdd);
                solutionList = new ArrayList<>();
                solutionList.add(solutionX1);
                solutionList.add(solutionX2);
                allPossibleSolutionsWithBothPositive.add(solutionList);
            }
            List<List<Long>> allPossibleForBoth = new ArrayList<>();
            for (List<Long> list : allPossibleSolutionsWithBothPositive) {
                Long solX1 = list.get(0);
                Long solX2 = list.get(1);
                if (solX1 * y1 + solX2 * y2 == yres) {
                    allPossibleForBoth.add(list);
                }
            }
            if (allPossibleForBoth.isEmpty()) {
                return -1;
            }
            List<Long> currentSmallest = allPossibleForBoth.get(0);
            for (List<Long> list : allPossibleForBoth) {
                if (list.get(0) * 3 + list.get(1) < (currentSmallest.get(0) * 3 + currentSmallest.get(1))) {
                    currentSmallest = list;
                }
            }
            return currentSmallest.get(0) * 3 + currentSmallest.get(1);
        }
    }

    private long gcdExtended(long a, long b) {
        if (b == 0) {
            k1 = 1;
            k2 = 0;
            return a;
        } else {
            long b1 = a % b;
            long g = gcdExtended(b, b1);
            long temp = k1;
            k1 = k2;
            k2 = temp - (a / b) * k2;
            return g;
        }
    }

    public long tryEverythingUnder100() {
        long gcd = gcdExtended(x1, x2);
        if (xres % gcd != 0) {
            System.out.println("Not possible");
            return -1;
        }
        for (int i = 0; i <= 100; i++) {
            long currentX = i * x1;
            long currentY = i * y1;
            for (int j = 0; j <= 100; j++) {
                long currentXAll = currentX + j * x2;
                long currentYAll = currentY + j * y2;
                if (currentXAll == xres && currentYAll == yres) {
                    return i * 3 + j;
                }

            }
        }
        return -1;
    }
}
