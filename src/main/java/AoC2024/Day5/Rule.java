package AoC2024.Day5;

public class Rule {

    private long comesFirst;
    private long comesSecond;

    public Rule(long comesFirst, long comesSecond) {
        this.comesFirst = comesFirst;
        this.comesSecond = comesSecond;
    }

    public long getComesFirst() {
        return comesFirst;
    }

    public void setComesFirst(long comesFirst) {
        this.comesFirst = comesFirst;
    }

    public long getComesSecond() {
        return comesSecond;
    }

    public void setComesSecond(long comesSecond) {
        this.comesSecond = comesSecond;
    }
}
