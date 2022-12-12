package AoC2022.Day12;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Node> parseInput() {
        List<Node> nodes = new ArrayList<>();
        String[] inputLines = input.split("\n");
        for (int y = 0; y < inputLines.length; y++) {
            String line = inputLines[y];
            for (int x = 0; x < line.length(); x++) {
                char charInLine = line.charAt(x);
                int height = Character.getNumericValue(charInLine);
                if (charInLine == 'S') {
                    height = Character.getNumericValue('a');
                    nodes.add(new Node(x, y, height, 0, false));
                } else if (charInLine == 'E') {
                    height = Character.getNumericValue('z');
                    nodes.add(new Node(x, y, height, -1, true));
                } else {
                    nodes.add(new Node(x, y, height, -1, false));
                }
            }
        }
        return nodes;
    }
}
