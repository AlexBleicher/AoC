package AoC2023.Day9;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String in;

    public Input(String i) {
        in = i;
    }

    public List<History> parseInput() {
        String[] split = in.split("\n");
        List<History> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(" ");
            List<Integer> v = new ArrayList<>();
            for (String string : split1) {
                v.add(Integer.parseInt(string));
            }
            res.add(new History(v));
        }
        return res;
    }
}
