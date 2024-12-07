package AoC2024.Day7;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<Equation> parseInput() {
        String[] split = input.split("\n");
        List<Equation> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(":");
            Equation e = new Equation();
            e.setSol(Long.parseLong(split1[0]));
            e.setNumbers(new ArrayList<>());
            String[] split2 = split1[1].split(" ");
            for (String string : split2) {
                if (!string.isEmpty()) {
                    e.addToNumbers(Long.parseLong(string));
                }
            }
            res.add(e);
        }
        return res;
    }
}
