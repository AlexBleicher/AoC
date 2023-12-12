package AoC2023.Day12;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String in;

    public Input(String i) {
        in = i;
    }

    public List<Row> parseInput() {
        String[] split = in.split("\n");
        List<Row> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(" ");
            res.add(new Row(split1[0], split1[1]));
        }
        return res;
    }
}

