package AoC2025.Day7;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public char[][] parseInput() {
        String[] lines = input.split("\n");
        char[][] res = new char[lines.length][lines[0].length()];
        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                res[y][x] = line.charAt(x);
            }
        }
        return res;
    }
}
