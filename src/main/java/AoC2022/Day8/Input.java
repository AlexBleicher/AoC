package AoC2022.Day8;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Tree> parseInput() {
        List<Tree> trees = new ArrayList<>();
        String[] lines = input.split("\n");
        int y = 0;
        for (String line : lines) {
            for (int x = 0; x < line.length(); x++) {
                int height = Character.getNumericValue(line.charAt(x));
                Tree tree = new Tree(x, y, height);
                if ((y == 0) || (x == 0) || (y == lines.length - 1) || (x == line.length() - 1)) {
                    tree.setAtEdge(true);
                }
                trees.add(tree);
            }
            y++;
        }
        return trees;
    }
}
