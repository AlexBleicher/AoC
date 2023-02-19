package AoC2022.Day13;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Pair> parseInput() {
        List<Pair> result = new ArrayList<>();
        String[] split = input.split("\n\n");
        for (String s : split) {
            String[] split1 = s.split("\n");
            result.add(new Pair(new Packet(split1[0]), new Packet(split1[1])));

        }
        return result;
    }
}