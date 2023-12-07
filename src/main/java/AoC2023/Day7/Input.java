package AoC2023.Day7;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String in;

    public Input(String i) {
        in = i;
    }

    public List<Hand> parseInput() {
        String[] split = in.split("\n");
        List<Hand> res = new ArrayList<>();
        for (String s : split) {
            res.add(new Hand(s.split(" ")[0], Long.parseLong(s.split(" ")[1])));
        }
        return res;
    }
}
