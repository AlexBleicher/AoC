package AoC2021.Day7;

import java.util.ArrayList;

public class Input {
    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<Integer> splitInput() {
        ArrayList<Integer> result = new ArrayList<>();
        String[] inputSplit = input.split(",");
        for (String s : inputSplit) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
