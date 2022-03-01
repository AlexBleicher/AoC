package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    public List<RiskLevel> cave;

    public Day15(String input) {
        Input parser = new Input(input);
        cave = parser.parseInput();
    }

    public int solveTask1() {
        RiskLevel start = cave.get(0);
        RiskLevel end = cave.get(cave.size() - 1);
        return calculateShortestWay(start, end);
    }

    public int calculateShortestWay(RiskLevel start, RiskLevel end) {
        List<RiskLevel> queue = new ArrayList<>();
        List<RiskLevel> predecesor = new ArrayList<>();
        List<Integer> risk = new ArrayList<>();
        initialise(cave, start, queue, predecesor, risk);
        while (!queue.isEmpty()) {
            RiskLevel u = findLowest(queue, risk);
            queue.remove(queue.indexOf(u));
            for (RiskLevel neighbor : u.neighbors) {
                if (queue.contains(neighbor)) {
                    update_risk(neighbor, u, risk, predecesor);
                }
            }
        }
        return risk.get(cave.indexOf(end));
    }

    public void initialise(List<RiskLevel> cave, RiskLevel start, List<RiskLevel> queue, List<RiskLevel> predecesor, List<Integer> risk) {
        for (RiskLevel riskLevel : cave) {
            risk.add(-1);
            predecesor.add(null);
            queue.add(riskLevel);
        }
        risk.set(0, 0);
    }

    public RiskLevel findLowest(List<RiskLevel> queue, List<Integer> risks) {
        int currentLowest = -1;
        RiskLevel result = null;
        for (RiskLevel riskLevel : queue) {
            if (risks.get(cave.indexOf(riskLevel)) < currentLowest && risks.get(cave.indexOf(riskLevel)) != -1 || currentLowest == -1) {
                currentLowest = risks.get(cave.indexOf(riskLevel));
                result = riskLevel;
            }
        }
        return result;
    }

    public void update_risk(RiskLevel v, RiskLevel u, List<Integer> risks, List<RiskLevel> predecesors) {
        int alternative = risks.get(cave.indexOf(u)) + v.getRisk();
        if (risks.get(cave.indexOf(v)) == -1 || risks.get(cave.indexOf(v)) > alternative) {
            risks.set(cave.indexOf(v), alternative);
            predecesors.set(cave.indexOf(v), u);
        }
    }
}
