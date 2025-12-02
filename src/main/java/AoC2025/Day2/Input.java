package AoC2025.Day2;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<List<Long>> parseInput() {
        List<List<Long>> res = new ArrayList<>();
        String[] split = input.split(",");
        for (String s : split) {
            String[] split1 = s.split("-");
            List<Long> list = new ArrayList<>();
            for (long l = Long.parseLong(split1[0]); l <= Long.parseLong(split1[1]); l++) {
                list.add(l);
            }
            res.add(list);
        }
        return res;
    }
}
