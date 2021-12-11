package AoC2021.Day11;

import java.util.ArrayList;
import java.util.List;

public class Octopus {

    private int x;
    private int y;
    private int energyLevel;
    private List<Octopus> neighbors = new ArrayList<>();
    private boolean hasFlashed = false;

    public Octopus(int x, int y, int energyLevel) {
        this.x = x;
        this.y = y;
        this.energyLevel = energyLevel;
    }

    public void addNeighbor(Octopus possibleNeighbor) {
        if (!(possibleNeighbor.getX() > x + 1 || possibleNeighbor.getY() > y + 1 || possibleNeighbor.getX() < x - 1 || possibleNeighbor.getY() < y - 1 ||
                (possibleNeighbor.getX() == x && possibleNeighbor.getY() == y) || neighbors.contains(possibleNeighbor))) {
            neighbors.add(possibleNeighbor);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public List<Octopus> getNeighbors() {
        return neighbors;
    }

    public void increaseEnergyLevel() {
        energyLevel++;
    }

    public int flash() {
        if (energyLevel > 9 && !hasFlashed) {
            hasFlashed = true;
            int score = 1;
            for (Octopus neighbor : neighbors) {
                if (!neighbor.hasFlashed) {
                    neighbor.increaseEnergyLevel();
                    score += neighbor.flash();
                }
            }
            return score;
        } else {
            return 0;
        }
    }

    public void resetEnergy() {
        if (hasFlashed) {
            energyLevel = 0;
            hasFlashed = false;
        }
    }
}
