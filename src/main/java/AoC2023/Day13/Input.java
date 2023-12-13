package AoC2023.Day13;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String in;

    public Input(String i) {
        in = i;
    }

    public List<Character[][]> parseInput() {
        String[] split = in.split("\n\n");
        List<Character[][]> res = new ArrayList<>();
        for (String s : split) {
            String[] lines = s.split("\n");
            Character[][] map = new Character[lines.length][lines[0].length()];
            for (int y = 0; y < lines.length; y++) {
                String line = lines[y];
                for (int x = 0; x < line.length(); x++) {
                    map[y][x] = line.charAt(x);
                }
            }
            res.add(map);
        }
        return res;
    }
}
