package AoC2021.Day13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public Set<Dot> splitCoordinates() {
        String[] splitInput = input.split("\n\n");
        String[] splitLines = splitInput[0].split("\n");
        Set<Dot> result = new HashSet<>();
        for (String line : splitLines) {
            String[] xAndy = line.split(",");
            result.add(new Dot(Integer.parseInt(xAndy[0]), Integer.parseInt(xAndy[1])));
        }
        return result;
    }

    public List<Instruction> splitInstructions() {
        String[] splitInput = input.split("\n\n");
        String[] splitLines = splitInput[1].split("\n");
        List<Instruction> result = new ArrayList<>();
        for (String line : splitLines) {
            String[] foldUpAndLineValue = line.split("=");
            result.add(new Instruction(foldUpAndLineValue[0].contains("y"), Integer.parseInt(foldUpAndLineValue[1])));
        }
        return result;
    }
}
