package AoC2024.Day14;

import java.util.List;

public class Day14 {

    private int borderLeft;
    private int borderUp;
    private int borderDown;
    private int borderRight;

    private List<Robot> robots;

    public Day14(String i, boolean isTest) {
        robots = new Input(i).parseinput();
        if (isTest) {
            borderRight = 10;
            borderDown = 6;
        } else {
            borderRight = 100;
            borderDown = 102;
        }
        borderLeft = 0;
        borderUp = 0;
    }

    public long task1() {
        for (int i = 0; i < 100; i++) {
            for (Robot r : robots) {
                r.moveForSecond(borderLeft, borderUp, borderDown, borderRight);
            }
        }
        long upperQuadrantLeft = 0;
        for (int x = 0; x < borderRight / 2; x++) {
            for (int y = 0; y < borderDown / 2; y++) {
                for (Robot robot : robots) {
                    if (robot.getCurrentX() == x && robot.getCurrentY() == y) {
                        upperQuadrantLeft++;
                    }
                }
            }
        }
        long upperQuadrantRight = 0;
        for (int x = borderRight / 2 + 1; x <= borderRight; x++) {
            for (int y = 0; y < borderDown / 2; y++) {
                for (Robot robot : robots) {
                    if (robot.getCurrentX() == x && robot.getCurrentY() == y) {
                        upperQuadrantRight++;
                    }
                }
            }
        }

        long lowerQuadrantLeft = 0;
        for (int x = 0; x < borderRight / 2; x++) {
            for (int y = borderDown / 2 + 1; y <= borderDown; y++) {
                for (Robot robot : robots) {
                    if (robot.getCurrentX() == x && robot.getCurrentY() == y) {
                        lowerQuadrantLeft++;
                    }
                }
            }
        }

        long lowerQuadrantRight = 0;
        for (int x = borderRight / 2 + 1; x <= borderRight; x++) {
            for (int y = borderDown / 2 + 1; y <= borderDown; y++) {
                for (Robot robot : robots) {
                    if (robot.getCurrentX() == x && robot.getCurrentY() == y) {
                        lowerQuadrantRight++;
                    }
                }
            }
        }
        return upperQuadrantLeft * upperQuadrantRight * lowerQuadrantRight * lowerQuadrantLeft;
    }

    public long task2() {
        long seconds = 0;
        while (seconds < Long.MAX_VALUE) {
            for (Robot robot : robots) {
                robot.moveForSecond(borderLeft, borderUp, borderDown, borderRight);
            }
            seconds++;
            boolean hasOverlap = false;
            for (Robot robot : robots) {
                for (Robot robot1 : robots) {
                    if (robot.getVx() != robot1.getVx() || robot.getVy() != robot1.getVy()) {
                        if (robot.getCurrentX() == robot1.getCurrentX() && robot.getCurrentY() == robot1.getCurrentY()) {
                            hasOverlap = true;
                        }
                    }
                }
            }
            if (!hasOverlap) {
                for (int y = 0; y <= borderDown; y++) {
                    String line = "";
                    for (int x = 0; x <= borderRight; x++) {
                        boolean foundRobot = false;
                        for (Robot robot : robots) {
                            if (robot.getCurrentX() == x && robot.getCurrentY() == y && !foundRobot) {
                                line += "r";
                                foundRobot = true;
                            }
                        }
                        if (!foundRobot) {
                            line += ".";
                        }
                    }
                    System.out.println(line);
                }
                return seconds;
            }
        }
        return -1;
    }
}
