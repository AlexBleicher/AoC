package AoC2023.Day16;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public Tile[][] parseInput() {
        String[] split = input.split("\n");
        Tile[][] map = new Tile[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String line = split[y];
            for (int x = 0; x < line.length(); x++) {
                map[y][x] = new Tile(line.charAt(x));
            }
        }
        return map;
    }
}
