package AoC2023.Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    String input;

    public Input(String i) {
        this.input = i;
    }

    public List<String> parseInput() {
        String[] split = input.split("\n");
        List<String> res = new ArrayList<>();
        res.addAll(Arrays.asList(split));
        return res;
    }
}
