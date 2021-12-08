package AoC2021.Day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private String input;
    private String[] splitInput;

    public Input(String input) {
        this.input = input;
        splitInput = input.split("\n");
    }

    public List<String> getNumberSignals() {
        List<String> numberSignals = new ArrayList<>();
        for (String s : splitInput) {
            numberSignals.add(s.split("\\|")[0]);
        }
        return numberSignals;
    }

    public List<String> getOuput() {
        List<String> output = new ArrayList<>();
        for (String s : splitInput) {
            output.add(s.split("\\|")[1]);
        }
        return output;
    }
}
