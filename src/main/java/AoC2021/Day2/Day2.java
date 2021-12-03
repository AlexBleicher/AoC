package AoC2021.Day2;

import java.util.ArrayList;

public class Day2 {

    private Position yourPosition = new Position();
    private ArrayList<Instruction> instructions;

    public Day2(String input) {
        this.instructions = new Input(input).splitInput();
    }

    public int task1() {
        followInstructions1();
        int yourHorizontal = yourPosition.getHorizontal();
        int yourDepth = yourPosition.getDepth();
        return yourHorizontal * yourDepth;
    }

    public void followInstructions1() {
        for (Instruction instruction : instructions) {
            movePositionTask1(instruction);
        }
    }

    public void movePositionTask1(Instruction instruction) {
        switch (instruction.getDirection()) {
            case "forward":
                yourPosition.forwardTask1(instruction.getValue());
                break;
            case "down":
                yourPosition.downTask1(instruction.getValue());
                break;
            case "up":
                yourPosition.upTask1(instruction.getValue());
                break;
        }
    }

    public int task2() {
        followInstructions2();
        return yourPosition.getDepth() * yourPosition.getHorizontal();
    }

    public void followInstructions2() {
        for (Instruction instruction : instructions) {
            movePosition2(instruction);
        }
    }

    public void movePosition2(Instruction instruction) {
        switch (instruction.getDirection()) {
            case "forward":
                yourPosition.forward(instruction.getValue());
                break;
            case "up":
                yourPosition.up(instruction.getValue());
                break;
            case "down":
                yourPosition.down(instruction.getValue());
                break;
        }
    }
}
