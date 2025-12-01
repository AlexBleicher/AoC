package AoC2025.Day1;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Integer> parseInput() {
        String[] split = input.split("\n");
        List<Integer> res = new ArrayList<>();
        for (String s : split) {
            char c = s.charAt(0);
            int number = Integer.parseInt(s.substring(1));
            if (c == 'L') {
                number *= -1;
            }
            res.add(number);
        }
        return res;
    }
}
