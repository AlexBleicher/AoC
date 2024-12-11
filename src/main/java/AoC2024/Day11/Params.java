package AoC2024.Day11;

import java.util.Objects;

public class Params {

    private long value;
    private int count;

    public Params(long value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Params params = (Params) o;
        return value == params.value && count == params.count;
    }

    public long getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, count);
    }
}
