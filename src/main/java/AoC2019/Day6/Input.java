package AoC2019.Day6;

import java.util.ArrayList;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<String[]> transformInput() {
        ArrayList<String[]> result = new ArrayList<>();
        String[] splitInput = input.split("\n");
        for (String s : splitInput) {
            result.add(s.split("\\)"));
        }
        return result;
    }
}
