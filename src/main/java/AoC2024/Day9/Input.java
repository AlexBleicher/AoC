package AoC2024.Day9;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<File> parseInput() {
        List<File> res = new ArrayList<>();
        boolean isFree = false;
        int id = 0;
        for (int i = 0; i < input.length(); i++) {
            int amountOf = Integer.parseInt("" + input.charAt(i));
            for (int i1 = 0; i1 < amountOf; i1++) {
                res.add(new File(isFree, id));
            }
            if (!isFree) {
                id++;
            }
            isFree = !isFree;
        }
        return res;
    }
}
