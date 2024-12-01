package AoC2023.Day17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day17 {

    private Integer[][] weights;
    private Node[][] graph;

    public Day17(String i) {
        weights = new Input(i).parseInput();
        for (int y = 0; y < weights.length; y++) {
            Integer[] line = weights[y];
            for (int x = 0; x < line.length; x++) {
                graph[y][x] = new Node(line[y]);
            }
        }
        for (int y = 0; y < graph.length; y++) {
            Node[] line = graph[y];
            for (int x = 0; x < line.length; x++) {
                if (y > 0) {
                    graph[y][x].setNeighborUp(graph[y - 1][x]);
                }
                if (y < graph.length - 1) {
                    graph[y][x].setNeighborDown(graph[y + 1][x]);
                }
                if (x > 0) {
                    graph[y][x].setNeighborLeft(graph[y][x - 1]);
                }
                if (x < line.length - 1) {
                    graph[y][x].setNeighborRight(graph[y][x + 1]);
                }
            }

        }
    }

    public long task1() {
        return 0;
    }

    private long dijkstra(Node startNode) {
        List<Long> distance = new ArrayList<>();
        List<Node> prev = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        for (int y = 0; y < graph.length; y++) {
            Node[] line = graph[y];
            for (int x = 0; x < line.length; x++) {
                distance.add(Long.MAX_VALUE);
                prev.add(null);
                queue.add(graph[y][x]);
            }
        }
        distance.set(distance.indexOf(startNode), (long) 0);
        startNode.setDirectionIn('l');

        int steps = 0;
        while (!queue.isEmpty()) {
            Node u = queue.get(distance.indexOf(distance.stream().min(Comparator.comparingLong(Long::longValue)).get()));
            queue.remove(u);
            steps++;
            List<Node> neighbors = u.getNeighbors(steps == 3);
        }
        return 0;
    }
}
