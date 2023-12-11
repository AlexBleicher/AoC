package AoC2023.Day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day11 {

    private Node[][] map;
    private List<Node> galaxies = new ArrayList<>();

    public Day11(String i) {
        map = new Input(i).parseInput();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x].isGalaxy()) {
                    galaxies.add(map[y][x]);
                }
            }
        }
    }

    public long task1() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (y > 0) {
                    map[y][x].setUp(map[y - 1][x]);
                }
                if (y < map.length - 1) {
                    map[y][x].setDown(map[y + 1][x]);
                }
                if (x > 0) {
                    map[y][x].setLeft(map[y][x - 1]);
                }
                if (x < map[0].length - 1) {
                    map[y][x].setRight(map[y][x + 1]);
                }
            }
        }

        List<Long> shortestPaths = new ArrayList<>();
        for (
                int i = 0; i < galaxies.size(); i++) {
            dijkstra(galaxies.get(i), 1);
        }
        for (
                int i = 0; i < galaxies.size(); i++) {
            Node galaxy = galaxies.get(i);
            for (int i1 = i; i1 < galaxies.size(); i1++) {
                shortestPaths.add(galaxy.getShortestPath(galaxies.get(i1)));
            }
        }
        return shortestPaths.stream().reduce((a, b) -> a + b).get();

    }

    public long task2(long stepwidth) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (y > 0) {
                    map[y][x].setUp(map[y - 1][x]);
                }
                if (y < map.length - 1) {
                    map[y][x].setDown(map[y + 1][x]);
                }
                if (x > 0) {
                    map[y][x].setLeft(map[y][x - 1]);
                }
                if (x < map[0].length - 1) {
                    map[y][x].setRight(map[y][x + 1]);
                }
            }
        }

        List<Long> shortestPaths = new ArrayList<>();
        for (
                int i = 0; i < galaxies.size(); i++) {
            dijkstra(galaxies.get(i), stepwidth);
        }
        for (
                int i = 0; i < galaxies.size(); i++) {
            Node galaxy = galaxies.get(i);
            for (int i1 = i; i1 < galaxies.size(); i1++) {
                shortestPaths.add(galaxy.getShortestPath(galaxies.get(i1)));
            }
        }
        return shortestPaths.stream().reduce((a, b) -> a + b).get();

    }

    private void dijkstra(Node start, long stepwidth) {
        Map<Node, Integer> indexes = new HashMap<>();
        List<Node> queue = new ArrayList<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                queue.add(map[y][x]);
            }
        }
        int i = 0;
        List<Integer> distances = new ArrayList<>();
        List<Node> prev = new ArrayList<>();
        for (Node node : queue) {
            distances.add(Integer.MAX_VALUE);
            prev.add(null);
            indexes.put(node, i++);
        }
        int index = queue.indexOf(start);
        distances.set(index, 0);
        Node u = null;
        boolean expansionDown = false;
        boolean expansionRight = false;
        while (!queue.isEmpty()) {
            u = queue.get(0);
            for (Node node : queue) {
                if (distances.get(indexes.get(node)) < distances.get(indexes.get(u))) {
                    u = node;
                }
            }
            queue.remove(u);
            u.putShortestPath(start, distances.get(indexes.get(u)));
            expansionRight = u.isExpandRight();
            expansionDown = u.isExpandDown();
            List<Node> neighbors = new ArrayList<>();
            neighbors.add(u.getUp());
            neighbors.add(u.getDown());
            neighbors.add(u.getLeft());
            neighbors.add(u.getRight());

            for (Node neighbor : neighbors) {
                if (neighbor != null) {
                    if ((expansionDown && neighbor == u.getDown()) || (neighbor == u.getLeft() && neighbor.isExpandRight())) {
                        updateDistance(u, neighbor, distances, prev, indexes.get(u), indexes.get(neighbor), true, stepwidth);
                    } else if ((expansionRight && neighbor == u.getRight()) || (neighbor == u.getUp() && neighbor.isExpandDown())) {
                        updateDistance(u, neighbor, distances, prev, indexes.get(u), indexes.get(neighbor), true, stepwidth);
                    } else {
                        updateDistance(u, neighbor, distances, prev, indexes.get(u), indexes.get(neighbor), false, stepwidth);
                    }
                }
            }
        }
    }

    private void updateDistance(Node u, Node v, List<Integer> distance, List<Node> prev, int indexOfU, int indexOfV, boolean considerExpansion, long stepWidth) {
        int alternative = distance.get(indexOfU) + 1;
        if (considerExpansion) {
            alternative += stepWidth;
        }
        if (alternative < distance.get(indexOfV)) {
            distance.set(indexOfV, alternative);
            prev.set(indexOfV, u);
        }
    }
}
