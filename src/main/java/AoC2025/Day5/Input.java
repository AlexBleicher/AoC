package AoC2025.Day5;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<List<Long>> parseInput() {
        List<List<Long>> res = new ArrayList<>();
        String[] split = input.split("\n\n");
        String[] split1 = split[0].split("\n");
        List<Long> freshIds = new ArrayList<>();
        for (String string : split1) {
            String[] s = string.split("-");
            long begin = Long.parseLong(s[0]);
            long end = Long.parseLong(s[1]);
            freshIds.add(begin);
            freshIds.add(end);
        }
        String[] split2 = split[1].split("\n");
        List<Long> ids = new ArrayList<>();
        for (String s : split2) {
            ids.add(Long.parseLong(s));
        }
        res.add(freshIds.stream().toList());
        res.add(ids);
        return res;
    }
}
