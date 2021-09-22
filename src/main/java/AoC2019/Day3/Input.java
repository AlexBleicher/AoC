package AoC2019.Day3;

import java.util.ArrayList;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<ArrayList<String>> transformInput() {
        String[] splitInput = input.split("\n");
        ArrayList<ArrayList<String>> instructionList = new ArrayList<>();
        for (String s : splitInput) {
            ArrayList<String> instructions = new ArrayList<>();
            String[] splitInstructions = s.split(",");
            for (String instruction : splitInstructions) {
                instructions.add(instruction);
            }
            instructionList.add(instructions);
        }
        return instructionList;
    }
}
