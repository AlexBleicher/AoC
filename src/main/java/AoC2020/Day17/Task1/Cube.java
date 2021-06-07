package AoC2020.Day17.Task1;

import java.util.HashSet;
import java.util.Set;

public class Cube {

    private boolean alive;
    private Coordinate coordinate;
    private Set<Cube> neighbors = new HashSet<>();

    public Cube(boolean status, Coordinate coordinate) {
        this.alive = status;
        this.coordinate = coordinate;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean status) {
        this.alive = status;
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
        return ("X: " + coordinate.getX() + " Y: " + coordinate.getY() + " Z: " + coordinate.getZ() + " Status: " + alive);
    }

    public int getAmountOfActiveNeighbors() {
        int amountOfActiveNeighbors = 0;
        for (Cube neighbor : neighbors) {
            if (neighbor.isAlive()) {
                amountOfActiveNeighbors++;
            }
        }
        return amountOfActiveNeighbors;
    }
}
