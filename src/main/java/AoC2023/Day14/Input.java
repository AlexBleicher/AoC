package AoC2023.Day14;

public class Input {

    public String input;

    public Input(String i) {
        input = i;
    }

    public Character[][] parseInput() {
        String[] split = input.split("\n");
        Character[][] map = new Character[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String s = split[y];
            for (int x = 0; x < s.length(); x++) {
                map[y][x] = s.charAt(x);
            }
        }
        return map;
    }
}
