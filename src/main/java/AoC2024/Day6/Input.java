package AoC2024.Day6;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public char[][] parseInput() {
        String[] split = input.split("\n");
        char[][] map = new char[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String line = split[y];
            for (int x = 0; x < line.length(); x++) {
                map[y][x] = line.charAt(x);
            }
        }
        return map;
    }
}
