package AoC2025.Day9;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<RedTile> parseInput() {
        String[] split = input.split("\n");
        List<RedTile> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(",");
            RedTile r = new RedTile();
            r.setX(Integer.parseInt(split1[0]));
            r.setY(Integer.parseInt(split1[1]));
            res.add(r);
        }
        return res;
    }
}
