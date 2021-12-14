package AoC2021.Day14;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public String getPolymerTemplate() {
        String[] inputSplit = input.split("\n\n");
        return inputSplit[0];
    }

    public List<Rule> getInsertionRules() {
        String[] inputSplit = input.split("\n\n");
        String[] lines = inputSplit[1].split("\n");
        List<Rule> result = new ArrayList<>();
        for (String line : lines) {
            String[] lineSplit = line.split(" -> ");
            result.add(new Rule(lineSplit[0], lineSplit[1]));
        }
        return result;
    }

}
