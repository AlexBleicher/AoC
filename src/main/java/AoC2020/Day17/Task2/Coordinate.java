package AoC2020.Day17.Task2;

public class Coordinate {

    private int x;
    private int y;
    private int z;
    private int w;

    public Coordinate(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getW() {
        return w;
    }

    public boolean isEqual(Coordinate coordinate) {
        return (x == coordinate.getX() && y == coordinate.getY() && z == coordinate.getZ() && w == coordinate.getW());
    }

    public boolean isNeighbor(Coordinate otherCoordinate) {
        if ((otherCoordinate.getX() == x || otherCoordinate.getX() == x - 1 || otherCoordinate.getX() == x + 1) &&
                (otherCoordinate.getY() == y || otherCoordinate.getY() == y - 1 || otherCoordinate.getY() == y + 1) &&
                (otherCoordinate.getZ() == z || otherCoordinate.getZ() == z - 1 || otherCoordinate.getZ() == z + 1) &&
                (otherCoordinate.getW() == w || otherCoordinate.getW() == w - 1 || otherCoordinate.getW() == w + 1) &&
                !isEqual(otherCoordinate)) {
            return true;

        }
        return false;
    }
}

