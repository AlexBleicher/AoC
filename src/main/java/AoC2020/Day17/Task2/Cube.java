package AoC2020.Day17.Task2;

import java.util.HashSet;
import java.util.Set;

public class Cube {

    private boolean status;
    private Coordinate coordinate;
    private Set<Cube> neighbors = new HashSet<>();

    public Cube(boolean status, Coordinate coordinate) {
        this.status = status;
        this.coordinate = coordinate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void addNeighbor(Cube cube) {
        neighbors.add(cube);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getX() {
        return getCoordinate().getX();
    }

    public Set<Cube> getNeighbors() {
        return neighbors;
    }

    public String getCubeInfo() {
        return ("X: " + coordinate.getX() + " Y: " + coordinate.getY() + " Z: " + coordinate.getZ() + " W: " + coordinate.getW() + " Status: " + status);
    }

    public int getAmountOfActiveNeighbors() {
        int amountOfActiveNeighbors = 0;
        for (Cube neighbor : neighbors) {
            if (neighbor.isStatus()) {
                amountOfActiveNeighbors++;
            }
        }
        return amountOfActiveNeighbors;
    }
}
