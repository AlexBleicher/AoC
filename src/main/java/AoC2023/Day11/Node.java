package AoC2023.Day11;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private Node up;
    private Node down;
    private Node left;
    private Node right;
    private boolean isGalaxy;
    private Map<Node, Long> shortestPaths = new HashMap<>();
    private boolean expandDown;
    private boolean expandRight = false;

    public Node(boolean i, boolean e) {
        isGalaxy = i;
        expandDown = e;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isExpandDown() {
        return expandDown;
    }

    public void setExpandDown(boolean expandDown) {
        this.expandDown = expandDown;
    }

    public boolean isExpandRight() {
        return expandRight;
    }

    public void setExpandRight(boolean expandRight) {
        this.expandRight = expandRight;
    }

    public boolean isGalaxy() {
        return isGalaxy;
    }

    public void putShortestPath(Node n, long v) {
        shortestPaths.put(n, v);
    }

    public long getShortestPath(Node n) {
        return shortestPaths.get(n);
    }
}
