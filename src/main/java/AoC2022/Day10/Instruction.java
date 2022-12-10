package AoC2022.Day10;

public class Instruction {

    private int cycles;
    private int value;

    public Instruction(int cycles, int value) {
        this.cycles = cycles;
        this.value = value;
    }

    public int getCycles() {
        return cycles;
    }

    public int getValue() {
        return value;
    }
}
