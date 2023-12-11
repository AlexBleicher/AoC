package AoC2023.Day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private String in;

    public Input(String i) {
        in = i;
    }

    public Node[][] parseInput() {
        String[] split = in.split("\n");
        Node[][] map = new Node[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String s = split[y];
            boolean expandDown = !s.contains("#");
            for (int x = 0; x < s.length(); x++) {
                map[y][x] = new Node(s.charAt(x) == '#', expandDown);
            }
        }
        for (int x = 0; x < map[0].length; x++) {
            List<Node> nodesInColumn = new ArrayList<>();
            for (int y = 0; y < map.length; y++) {
                nodesInColumn.add(map[y][x]);
            }
            List<Node> collect = nodesInColumn.stream().filter(node -> !node.isGalaxy()).collect(Collectors.toList());
            if (collect.size() == nodesInColumn.size()) {
                for (Node node : nodesInColumn) {
                    node.setExpandRight(true);
                }
            }
        }
        return map;
    }
}
