package AoC2023.Day4;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String in) {
        input = in;
    }

    public List<Scratchcard> parseInput() {
        String[] split = input.split("\n");
        List<Scratchcard> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(": ");
            String[] split2 = split1[1].split(" \\| ");
            res.add(new Scratchcard(split2[0], split2[1]));
        }
        return res;
    }
}
