package AoC2021.Day1;

import java.util.ArrayList;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }


    public ArrayList<Integer> splitInput() {
        ArrayList<Integer> result = new ArrayList<>();
        String[] splitInput = input.split("\n");
        for (String s : splitInput) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
