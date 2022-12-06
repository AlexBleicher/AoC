package AoC2022.Day6;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Character> parseInput() {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            characters.add(input.charAt(i));
        }
        return characters;
    }
}
