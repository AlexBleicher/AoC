package AoC2024.Day1;

import java.util.ArrayList;
import java.util.List;

public class Input {
    String input;

    public Input(String i) {
        input = i;
    }

    public List<List<Long>> parseInput() {
        String[] split = input.split("\n");
        List<Long> listLeft = new ArrayList<>();
        List<Long> listRight = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(" ");
            listLeft.add(Long.parseLong(split1[0]));
            listRight.add(Long.parseLong(split1[3]));
        }
        List<List<Long>> res = new ArrayList<>();
        res.add(listLeft);
        res.add(listRight);
        return res;
    }
}
