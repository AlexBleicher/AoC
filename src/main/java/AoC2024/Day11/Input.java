package AoC2024.Day11;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<Stone> parseInput() {
        String[] split = input.split(" ");
        List<Stone> stones = new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                stones.add(new Stone(Long.parseLong(s)));
            }
        }
        return stones;
    }
}
