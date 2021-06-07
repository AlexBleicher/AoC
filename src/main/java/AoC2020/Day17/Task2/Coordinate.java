package AoC2020.Day17.Task2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coordinate {

    private int w;
    private int x;
    private int y;
    private int z;

    public Coordinate(int w, int x, int y, int z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getW() {
        return w;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return getW() == that.getW() &&
                getX() == that.getX() &&
                getY() == that.getY() &&
                getZ() == that.getZ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getW(), getX(), getY(), getZ());
    }

    public Set<Coordinate> getAllNeighbors() {
        Set<Coordinate> allNeighbors = new HashSet<>();
        for (int w = this.w - 1; w <= this.w + 1; w++) {
            for (int x = this.x - 1; x <= this.x + 1; x++) {
                for (int y = this.y - 1; y <= this.y + 1; y++) {
                    for (int z = this.z - 1; z <= this.z + 1; z++) {
                        Coordinate neighbor = new Coordinate(w, x, y, z);
                        if (!neighbor.equals(this)) {
                            allNeighbors.add(neighbor);
                        }
                    }
                }
            }
        }
        return allNeighbors;
    }

}
