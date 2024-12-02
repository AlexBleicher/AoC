package AoC2024.Day2;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private String input;

    public Input(String i) {
        input = i;
    }

    public List<Report> parseInput() {
        String[] split = input.split("\n");
        List<Report> res = new ArrayList<>();
        for (String s : split) {
            List<Integer> levels = new ArrayList<>();
            String[] split1 = s.split(" ");
            for (String string : split1) {
                levels.add(Integer.parseInt(string));
            }
            res.add(new Report(levels));
        }
        return res;
    }
}
