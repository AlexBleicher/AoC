package AoC2022.Day9;

public class Command {

    private Direction direction;
    private int steps;

    public Command(Direction direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }
}
