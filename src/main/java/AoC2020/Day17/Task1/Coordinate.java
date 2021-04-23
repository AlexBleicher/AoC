package AoC2020.Day17.Task1;

public class Coordinate {

    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public boolean isEqual(Coordinate coordinate) {
        return (x == coordinate.getX() && y == coordinate.getY() && z == coordinate.getZ());
    }

    public boolean isNeighbor(Coordinate otherCoordinate) {
        if ((otherCoordinate.getX() == x || otherCoordinate.getX() == x - 1 || otherCoordinate.getX() == x + 1) &&
                (otherCoordinate.getY() == y || otherCoordinate.getY() == y - 1 || otherCoordinate.getY() == y + 1) &&
                (otherCoordinate.getZ() == z || otherCoordinate.getZ() == z - 1 || otherCoordinate.getZ() == z + 1) &&
                !(otherCoordinate.getX() == x && otherCoordinate.getY() == y && otherCoordinate.getZ() == z)) {
            return true;

        }
        return false;
    }
}

