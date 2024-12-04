package AoC2024.Day4;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public Letter[][] parseInput() {
        String[] split = input.split("\n");
        int length = split.length;
        Letter[][] res = new Letter[split[0].length()][length];
        for (int y = 0; y < length; y++) {
            String line = split[y];
            for (int x = 0; x < line.length(); x++) {
                char l = line.charAt(x);
                Letter let = new Letter();
                let.setX(x);
                let.setY(y);
                let.setLetter(l);
                res[y][x] = let;
            }
        }
        for (int x = 0; x < split[0].length(); x++) {
            for (int y = 0; y < length; y++) {
                Letter cur = res[x][y];
                if (x - 1 > 0) {
                    if (y - 1 > 0) {
                        cur.addNeighbor(res[x - 1][y - 1]);
                    }
                    cur.addNeighbor(res[x - 1][y]);
                    if (y + 1 < length) {
                        cur.addNeighbor(res[x - 1][y]);
                        ;
                    }
                }
                if (x + 1 < split[0].length()) {
                    if (y - 1 > 0) {
                        cur.addNeighbor(res[x + 1][y - 1]);
                    }
                    cur.addNeighbor(res[x + 1][y]);
                    if (y + 1 < length) {
                        cur.addNeighbor(res[x + 1][y]);
                        ;
                    }
                }
                if (y - 1 > 0) {
                    cur.addNeighbor(res[x][y - 1]);
                }
                if (y + 1 < length) {
                    cur.addNeighbor(res[x][y + 1]);
                }
            }
        }
        return res;
    }
}
