package AoC2024.Day8;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public char[][] parseInput() {
        String[] split = input.split("\n");
        char[][] res = new char[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            for (int x = 0; x < split[0].length(); x++) {
                res[y][x] = split[y].charAt(x);
            }
        }
        return res;
    }
}
