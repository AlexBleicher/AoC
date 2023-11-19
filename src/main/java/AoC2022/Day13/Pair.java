package AoC2022.Day13;

public class Pair {

    private Packet left;
    private Packet right;

    public Pair(String leftString, String rightString) {
        left = new Packet(leftString);
        right = new Packet(rightString);
    }

    public Packet getLeft() {
        return left;
    }

    public Packet getRight() {
        return right;
    }
}
