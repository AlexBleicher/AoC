package AoC2021.Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<String> splitLines() {
        return new ArrayList<>(Arrays.asList(input.split("\n")));
    }
}
