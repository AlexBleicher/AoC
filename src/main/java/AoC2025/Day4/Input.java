package AoC2025.Day4;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public char[][] parseInput() {
        String[] split = input.split("\n");
        char[][] res = new char[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            String line = split[i];
            for (int i1 = 0; i1 < line.length(); i1++) {
                res[i][i1] = line.charAt(i1);
            }
        }
        return res;
    }
}
