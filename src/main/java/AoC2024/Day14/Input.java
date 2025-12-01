package AoC2024.Day14;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<Robot> parseinput() {
        String[] split = input.split("\n");
        List<Robot> res = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(" ");
            String pos = split1[0];
            String[] split2 = pos.split("=");
            int x = Integer.parseInt(split2[1].split(",")[0]);
            int y = Integer.parseInt(split2[1].split(",")[1]);
            String vel = split1[1];
            String[] split3 = vel.split("=");
            int vx = Integer.parseInt(split3[1].split(",")[0]);
            int vy = Integer.parseInt(split3[1].split(",")[1]);
            res.add(new Robot(x, y, vx, vy));
        }
        return res;
    }
}
