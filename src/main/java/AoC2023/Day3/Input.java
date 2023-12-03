package AoC2023.Day3;

import java.util.Arrays;
import java.util.List;

public class Input {
    private String input;

    public Input(String i) {
        input = i;
    }

    public List<String> parseInput() {
        String[] split = input.split("\n");
        return Arrays.stream(split).toList();
    }
}
