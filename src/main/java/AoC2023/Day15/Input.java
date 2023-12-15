package AoC2023.Day15;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private String in;

    public Input(String i) {
        in = i;
    }

    public List<String> parseInput() {
        String[] split = in.split(",");
        List<String> res = new ArrayList<>();
        for (String s : split) {
            res.add(s);
        }
        return res;
    }
}
