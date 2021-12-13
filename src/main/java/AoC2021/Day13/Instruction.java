package AoC2021.Day13;

public class Instruction {

    private boolean foldUp;
    private int lineNumber;

    public Instruction(boolean foldUp, int lineNumber) {
        this.foldUp = foldUp;
        this.lineNumber = lineNumber;
    }

    public boolean isFoldUp() {
        return foldUp;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
