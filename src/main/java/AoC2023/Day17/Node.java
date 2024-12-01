package AoC2023.Day17;

import java.util.List;

public class Node {

    private int heatloss;
    private Node neighborLeft;
    private Node neighborRight;
    private Node neighborUp;
    private Node neighborDown;

    private char directionIn;

    public Node(int heatloss) {
        this.heatloss = heatloss;
    }

    public int getHeatloss() {
        return heatloss;
    }

    public void setHeatloss(int heatloss) {
        this.heatloss = heatloss;
    }

    public Node getNeighborLeft() {
        return neighborLeft;
    }

    public void setNeighborLeft(Node neighborLeft) {
        this.neighborLeft = neighborLeft;
    }

    public Node getNeighborRight() {
        return neighborRight;
    }

    public void setNeighborRight(Node neighborRight) {
        this.neighborRight = neighborRight;
    }

    public Node getNeighborUp() {
        return neighborUp;
    }

    public void setNeighborUp(Node neighborUp) {
        this.neighborUp = neighborUp;
    }

    public Node getNeighborDown() {
        return neighborDown;
    }

    public void setNeighborDown(Node neighborDown) {
        this.neighborDown = neighborDown;
    }

    public char getDirectionIn() {
        return directionIn;
    }

    public void setDirectionIn(char directionIn) {
        this.directionIn = directionIn;
    }

    public List<Node> getNeighbors(boolean needsToTurn) {
        return null; //TODO: Sometimes finish this
    }
}
