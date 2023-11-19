package AoC2022.Day13;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Pair> parseInput() {
        String[] split = input.split("\n\n");
        List<Pair> resultList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String left = split[i].split("\n")[0];
            String right = split[i].split("\n")[1];
            Pair toAdd = new Pair(left, right);
            resultList.add(toAdd);
        }
        return resultList;
    }
}