package AoC2025.Day9;

import java.util.Objects;

public class RedTile {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long calcArea(RedTile otherTile) {
        return (long) (Math.max(x, otherTile.getX()) - Math.min(x, otherTile.getX()) + 1) * (Math.max(y, otherTile.getY()) - Math.min(y, otherTile.getY()) + 1);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedTile redTile = (RedTile) o;
        return x == redTile.x && y == redTile.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
