package AoC2024.Day3;

public class Multiplication {
    private long a;
    private long b;

    private int startIndex;

    public Multiplication(long a, long b, int s) {
        this.a = a;
        this.b = b;
        this.startIndex = s;
    }

    public boolean isInRange(int toCompareLast, int toCompareCurrent) {
        return (startIndex > toCompareLast && startIndex < toCompareCurrent);
    }

    public long doInstruction() {
        return a * b;
    }
}
