package AoC2019.Day3;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int calculateManhattanDistanceToOrigin() {
        int manhattanDistance = 0;
        if (x < 0) {
            manhattanDistance += x * -1;
        } else {
            manhattanDistance += x;
        }
        if (y < 0) {
            manhattanDistance += y * -1;
        } else {
            manhattanDistance += y;
        }
        return manhattanDistance;
    }
}
