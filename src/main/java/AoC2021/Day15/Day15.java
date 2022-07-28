package AoC2021.Day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
        PriorityQueue<RiskLevel> queue = initialize();
        RiskLevel u = start;
        while(queue.contains(end)){
            for (RiskLevel neighbor : u.neighbors) {
                int length = u.pathLength + neighbor.getRisk();
                if(neighbor.getPathLength()>length){
                    queue.remove(neighbor);
                    neighbor.pathLength = length;
                    queue.add(neighbor);
                }
            }
            queue.remove(u);
            u = queue.peek();
        }
        return end.pathLength;
    }

    public PriorityQueue<RiskLevel> initialize(){
        PriorityQueue<RiskLevel> q = new PriorityQueue<RiskLevel>(Comparator.comparingInt(RiskLevel::getPathLength));
        for (RiskLevel riskLevel : cave) {
            riskLevel.pathLength = Integer.MAX_VALUE;
            q.add(riskLevel);
        }
        cave.get(0).pathLength=0;
        q.remove(cave.get(0));
        return q;
    }
}
