package AoC2023.Day10;

public class Input {

    public String input;

    public Input(String i) {
        input = i;
    }

    public Pipe[][] parseInput() {
        String[] split = input.split("\n");
        Pipe[][] array = new Pipe[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String line = split[y];
            for (int x = 0; x < line.length(); x++) {
                Pipe pipe = new Pipe(line.charAt(x));
                array[y][x] = pipe;
            }
        }
        for (int y = 0; y < split.length; y++) {
            for (int x = 0; x < split[0].length(); x++) {
                Pipe p = array[y][x];
                if (y > 0) {
                    p.setNorth(array[y - 1][x]);
                }
                if (y < split.length - 1) {
                    p.setSouth(array[y + 1][x]);
                }
                if (x > 0) {
                    p.setWest(array[y][x - 1]);
                }
                if (x < split[0].length() - 1) {
                    p.setEast(array[y][x + 1]);
                }
            }
        }
        return array;
    }
}
