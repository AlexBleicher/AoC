package AoC2022.Day12;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Day12 {

    private List<Node> nodes;

    public Day12(String input) {
        nodes = new Input(input).parseInput();
    }

    public int solveTask1() {
        for (Node node : nodes) {
            for (Node node1 : nodes) {
                node.addNeighbor(node1);
            }
        }
        Node start = nodes.stream()
                .filter(Node -> Node.getPathLength() == 0)
                .findFirst()
                .get();
        Node end = nodes.stream()
                .filter(Node::isGoal)
                .findFirst()
                .get();
        return calculateShortestWay(start, end);
    }

    public int calculateShortestWay(Node start, Node end) {
        PriorityQueue<Node> queue = initialize();
        Node u = start;
        while (queue.contains(end)) {
            for (Node neighbor : u.getNeighbors()) {
                if (neighbor.getHeight() <= u.getHeight() + 1) {
                    int length = u.getPathLength() + 1;
                    if (length < 0) {
                        return Integer.MAX_VALUE; //Not possible to ever reach goal
                    }
                    if (neighbor.getPathLength() > length) {
                        queue.remove(neighbor);
                        neighbor.setPathLength(length);
                        queue.add(neighbor);
                    }
                }
            }
            queue.remove(u);
            u = queue.peek();
        }
        return end.getPathLength();
    }

    public PriorityQueue<Node> initialize() {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(Node::getPathLength));
        for (Node node : nodes) {
            if (node.getPathLength() != 0) {
                node.setPathLength(Integer.MAX_VALUE);
                q.add(node);
            }
        }
        return q;
    }

    public int solveTask2() {
        for (Node node : nodes) {
            for (Node node1 : nodes) {
                node.addNeighbor(node1);
            }
        }
        List<Node> possibleStarts = nodes.stream()
                .filter(Node -> Node.getHeight() == Character.getNumericValue('a'))
                .collect(Collectors.toList());
        Node end = nodes.stream()
                .filter(Node::isGoal)
                .findFirst()
                .get();

        int lowest = Integer.MAX_VALUE;
        for (Node possibleStart : possibleStarts) {
            for (Node node : nodes) {
                node.setPathLength(-1);
            }
            possibleStart.setPathLength(0);
            int pathLengthFromHere = calculateShortestWay(possibleStart, end);
            if (pathLengthFromHere <= lowest) {
                lowest = pathLengthFromHere;
            }
        }
        return lowest;
    }
}
