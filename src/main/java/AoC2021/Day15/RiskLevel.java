package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class RiskLevel {

    private int x;
    private int y;
    private int value;
    private List<RiskLevel> neighbors = new ArrayList<>();

    public RiskLevel(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public void addNeighbor(RiskLevel riskLevel) {
        if (!neighbors.contains(riskLevel) && ((riskLevel.getX() == x + 1) && (riskLevel.getY() == y) || (riskLevel.getY() == y + 1 && riskLevel.getX() == x))) {
            neighbors.add(riskLevel);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public List<List<RiskLevel>> getAllPathsToEnd(RiskLevel bottom) {
        List<List<RiskLevel>> allPaths = new ArrayList<>();
        if (!bottom.equals(this)) {
            for (RiskLevel neighbor : neighbors) {
                List<List<RiskLevel>> allPathsOfNeighbor = neighbor.getAllPathsToEnd(bottom);
                for (List<RiskLevel> path : allPathsOfNeighbor) {
                    path.add(this);
                }
                allPaths.addAll(allPathsOfNeighbor);
            }
        }
        return allPaths;
    }
}
