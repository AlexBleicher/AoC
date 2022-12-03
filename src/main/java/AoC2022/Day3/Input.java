package AoC2022.Day3;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Rucksack> parseInput() {
        List<Rucksack> result = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            int halfOfLine = line.length() / 2;
            List<Character> firstCompartement = new ArrayList<>();
            List<Character> secondCompartement = new ArrayList<>();
            for (int i = 0; i < halfOfLine; i++) {
                firstCompartement.add(line.charAt(i));
            }
            for (int i = halfOfLine; i < line.length(); i++) {
                secondCompartement.add(line.charAt(i));
            }
            result.add(new Rucksack(firstCompartement, secondCompartement));
        }
        return result;
    }
}
