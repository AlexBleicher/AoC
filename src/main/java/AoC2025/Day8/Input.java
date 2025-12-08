package AoC2025.Day8;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<JunctionBox> parseInput() {
        String[] lines = input.split("\n");
        List<JunctionBox> res = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(",");
            JunctionBox jb = new JunctionBox();
            jb.setX(Integer.parseInt(split[0]));
            jb.setY(Integer.parseInt(split[1]));
            jb.setZ(Integer.parseInt(split[2]));
            res.add(jb);
        }
        return res;
    }
}
