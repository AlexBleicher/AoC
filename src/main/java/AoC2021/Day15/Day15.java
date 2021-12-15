package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    private List<RiskLevel> riskLevelList;

    public Day15(String input) {
        riskLevelList = new Input(input).splitInput();
    }

    public int task1() {
        return lowestRiskPath(riskLevelList.get(0));
    }

    public int lowestRiskPath(RiskLevel start) {
        List<RiskLevel> queue = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        List<RiskLevel> path = new ArrayList<>();
        initialise(queue, distance, path, start);
        while (!queue.isEmpty()) {
            RiskLevel u = getRiskLevelWithLowestDistance(distance, queue);
            queue.remove(u);
            for (RiskLevel neighbor : u.getNeighbors()) {
                if (queue.contains(neighbor)) {
                    update_Distance(u, neighbor, distance, path);
                }
            }
        }
        return distance.get(distance.size() - 1);
    }

    public void initialise(List<RiskLevel> queue, List<Integer> distance, List<RiskLevel> path, RiskLevel start) {
        for (RiskLevel riskLevel : riskLevelList) {
            distance.add(1000000000);
            path.add(null);
        }
        distance.set(riskLevelList.indexOf(start), 0);
        queue.addAll(riskLevelList);
    }

    public void update_Distance(RiskLevel u, RiskLevel v, List<Integer> distance, List<RiskLevel> path) {
        int alternative = distance.get(riskLevelList.indexOf(u)) + u.getValue();
        if (alternative < distance.get(riskLevelList.indexOf(v))) {
            distance.set(riskLevelList.indexOf(v), alternative);
            path.set(riskLevelList.indexOf(v), u);
        }
    }

    public RiskLevel getRiskLevelWithLowestDistance(List<Integer> distance, List<RiskLevel> queue) {
        int lowest = -1;
        for (Integer thisDistance : distance) {
            if (lowest == -1 || (lowest > thisDistance)) {
                lowest = thisDistance;
            }
        }
        return queue.get(distance.indexOf(lowest));
    }
}
