package AoC2023.Day17;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public Integer[][] parseInput() {
        String[] split = input.split("\n");
        Integer[][] map = new Integer[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String line = split[y];
            for (int x = 0; x < line.length(); x++) {
                map[y][x] = Character.getNumericValue(line.charAt(x));
            }
        }
        return map;
    }
}
