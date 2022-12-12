package AoC2022.Day12;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int x;
    private int y;
    private int height;
    private List<Node> neighbors;
    private int pathLength;
    private boolean isGoal;

    public Node(int x, int y, int height, int pathLength, boolean isGoal) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.pathLength = pathLength;
        neighbors = new ArrayList<>();
        this.isGoal = isGoal;
    }

    public boolean isGoal() {
        return isGoal;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    public void addNeighbor(Node n) {
        if ((n.getX() == x && (n.getY() == y - 1 || n.getY() == y + 1)) || (n.getY() == y && (n.getX() == x - 1 || n.getX() == x + 1))) {
            neighbors.add(n);
        }
    }
}
