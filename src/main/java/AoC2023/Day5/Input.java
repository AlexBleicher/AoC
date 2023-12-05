package AoC2023.Day5;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private String input;

    public Input(String i) {
        input = i;
    }

    public List<List<List<Long>>> parseInput() {
        String[] split = input.split("\n\n");
        List<List<List<Long>>> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(":")[1].split("\n");
            List<List<Long>> sublistLines = new ArrayList<>();
            for (String string : split1) {
                String[] split2 = string.split(" ");
                List<Long> subListNumbers = new ArrayList<>();
                for (String s1 : split2) {
                    if (!s1.isEmpty()) {
                        subListNumbers.add(Long.parseLong(s1));
                    }
                }
                if (!subListNumbers.isEmpty()) {
                    sublistLines.add(subListNumbers);
                }
            }
            res.add(sublistLines);
        }
        return res;
    }
}
