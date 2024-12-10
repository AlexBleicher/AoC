package AoC2024.Day10;

public class Input {
    private String input;

    public Input(String i) {
        input = i;
    }

    public Position[][] parseInput() {
        String[] split = input.split("\n");
        Position[][] map = new Position[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String s = split[y];
            for (int x = 0; x < s.length(); x++) {
                int i = Integer.parseInt(s.charAt(x) + "");
                map[y][x] = new Position(false, x, y, i);
            }
        }
        return map;
    }
}
