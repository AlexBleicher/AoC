package AoC2021.Day2;

public class Instruction {

    private String direction;
    private int value;

    public Instruction(String direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }

    public int getValue() {
        return value;
    }
}
