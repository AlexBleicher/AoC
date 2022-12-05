package AoC2022.Day4;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Pair> parseInput() {
        List<Pair> result = new ArrayList<>();
        String[] pairLines = input.split("\n");
        for (String pairLine : pairLines) {
            String[] pairs = pairLine.split(",");
            String[] firstSection = pairs[0].split("-");
            int ls1 = Integer.parseInt(firstSection[0]);
            int us1=Integer.parseInt(firstSection[1]);
            String[]  secondSection = pairs[1].split("-");
            int ls2 = Integer.parseInt(secondSection[0]);
            int us2=Integer.parseInt(secondSection[1]);
            result.add(new Pair(ls1,us1,ls2,us2));
        }
        return result;
    }
}
