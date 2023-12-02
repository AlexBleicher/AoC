package AoC2023.Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        this.input = i;
    }

    public List<Game> parseInput() {
        String[] split = input.split("\n");
        List<Game> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(": ");
            res.add(new Game(Arrays.stream(split1[1].split("; ")).toList()));
        }
        return res;
    }
}
