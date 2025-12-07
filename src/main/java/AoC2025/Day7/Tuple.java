package AoC2025.Day7;

import java.util.Objects;

public class Tuple {

    private int yIndex;
    private int xIndex;

    public int getyIndex() {
        return yIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    public int getxIndex() {
        return xIndex;
    }

    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return yIndex == tuple.yIndex && xIndex == tuple.xIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yIndex, xIndex);
    }
}
