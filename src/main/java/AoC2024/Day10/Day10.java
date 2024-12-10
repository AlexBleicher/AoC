package AoC2024.Day10;

public class Day10 {

    private Position[][] map;

    public Day10(String i) {
        map = new Input(i).parseInput();
    }

    public long task1() {
        long score = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x].getScore() == 0) {
                    score += getScoreOfPoint(x, y, 0);
                    for (int i = 0; i < map.length; i++) {
                        for (int i1 = 0; i1 < map[0].length; i1++) {
                            map[i][i1].setAlreadyVisited(false);
                        }
                    }
                }
            }
        }
        return score;
    }

    private long getScoreOfPoint(int xPoint, int yPoint, long currentScore) {
        if (map[yPoint][xPoint].getScore() == 9) {
            map[yPoint][xPoint].setAlreadyVisited(true);
            return currentScore + 1;
        }
        if (xPoint > 0 && map[yPoint][xPoint - 1].getScore() == map[yPoint][xPoint].getScore() + 1 && !map[yPoint][xPoint - 1].isAlreadyVisited()) {
            currentScore = getScoreOfPoint(xPoint - 1, yPoint, currentScore);
        }
        if (xPoint < map[0].length - 1 && map[yPoint][xPoint + 1].getScore() == map[yPoint][xPoint].getScore() + 1 && !map[yPoint][xPoint + 1].isAlreadyVisited()) {
            currentScore = getScoreOfPoint(xPoint + 1, yPoint, currentScore);
        }
        if (yPoint > 0 && map[yPoint - 1][xPoint].getScore() == map[yPoint][xPoint].getScore() + 1 && !map[yPoint - 1][xPoint].isAlreadyVisited()) {
            long scoreOfPoint = getScoreOfPoint(xPoint, yPoint - 1, currentScore);
            currentScore = scoreOfPoint;
        }
        if (yPoint < map.length - 1 && map[yPoint + 1][xPoint].getScore() == map[yPoint][xPoint].getScore() + 1 && !map[yPoint + 1][xPoint].isAlreadyVisited()) {
            currentScore = getScoreOfPoint(xPoint, yPoint + 1, currentScore);
        }
        map[yPoint][xPoint].setAlreadyVisited(true);
        return currentScore;
    }

    public long task2() {
        long score = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x].getScore() == 0) {
                    score += getScoreOfPoint2(x, y, 0);
                }
            }
        }
        return score;
    }

    private long getScoreOfPoint2(int xPoint, int yPoint, long currentScore) {
        if (map[yPoint][xPoint].getScore() == 9) {
            return currentScore + 1;
        }
        if (xPoint > 0 && map[yPoint][xPoint - 1].getScore() == map[yPoint][xPoint].getScore() + 1) {
            currentScore = getScoreOfPoint2(xPoint - 1, yPoint, currentScore);
        }
        if (xPoint < map[0].length - 1 && map[yPoint][xPoint + 1].getScore() == map[yPoint][xPoint].getScore() + 1) {
            currentScore = getScoreOfPoint2(xPoint + 1, yPoint, currentScore);
        }
        if (yPoint > 0 && map[yPoint - 1][xPoint].getScore() == map[yPoint][xPoint].getScore() + 1) {
            long scoreOfPoint = getScoreOfPoint2(xPoint, yPoint - 1, currentScore);
            currentScore = scoreOfPoint;
        }
        if (yPoint < map.length - 1 && map[yPoint + 1][xPoint].getScore() == map[yPoint][xPoint].getScore() + 1) {
            currentScore = getScoreOfPoint2(xPoint, yPoint + 1, currentScore);
        }
        return currentScore;
    }
}
