package AoC2022.Day5;

public class Instruction {

    private int amount;
    private int indexFrom;
    private int indexTo;

    public Instruction(int amount, int indexFrom, int indexTo) {
        this.amount = amount;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
    }

    public int getAmount() {
        return amount;
    }

    public int getIndexFrom() {
        return indexFrom;
    }

    public int getIndexTo() {
        return indexTo;
    }
}
