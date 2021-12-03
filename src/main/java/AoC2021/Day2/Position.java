package AoC2021.Day2;

public class Position {

    private int horizontal = 0;
    private int depth = 0;
    private int aim = 0;

    public void forwardTask1(int value) {
        horizontal += value;
    }

    public void downTask1(int value) {
        depth += value;
    }

    public void upTask1(int value) {
        depth -= value;
    }

    public void forward(int value) {
        horizontal += value;
        depth += (aim * value);
    }

    public void down(int value) {
        aim += value;
    }

    public void up(int value) {
        aim -= value;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getDepth() {
        return depth;
    }
}
