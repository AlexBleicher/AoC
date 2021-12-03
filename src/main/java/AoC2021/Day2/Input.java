package AoC2021.Day2;

import java.util.ArrayList;

public class Input {

    private String inputAsString;

    public Input(String input) {
        inputAsString = input;
    }

    public ArrayList<Instruction> splitInput() {
        ArrayList<Instruction> resultList = new ArrayList<>();
        String[] splitInput = inputAsString.split("\n");
        for (String s : splitInput) {
            String[] instructionSplit = s.split(" ");
            Instruction thisInstruction = new Instruction(instructionSplit[0], Integer.parseInt(instructionSplit[1]));
            resultList.add(thisInstruction);
        }
        return resultList;
    }
}
