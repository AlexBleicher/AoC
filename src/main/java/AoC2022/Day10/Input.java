package AoC2022.Day10;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Instruction> parseInput() {
        List<Instruction> instructions = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            if (line.equals("noop")) {
                instructions.add(new Instruction(1, 0));
            } else {
                String[] split = line.split(" ");
                instructions.add(new Instruction(2, Integer.parseInt(split[1])));
            }
        }
        return instructions;
    }
}
