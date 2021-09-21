package AoC2019.Day2;

import java.util.ArrayList;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<Integer> transformInput() {
        String[] splitInput = input.split(",");
        ArrayList<Integer> transformedInput = new ArrayList<Integer>();
        for (String s : splitInput) {
            transformedInput.add(Integer.parseInt(s));
        }
        return transformedInput;
    }
}
