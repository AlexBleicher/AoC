package AoC2023.Day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day8 {

    private Map<String, Node> map;
    private String instructions;
    private Node firstNode;

    public Day8(String input) {
        instructions = input.split("\n\n")[0];
        map = new Input(input.split("\n\n")[1]).parseInput();
        firstNode = map.get("AAA");
    }

    public long task1() {
        Node currentNode = firstNode;
        long steps = 0;
        int indexInstructions = 0;
        while (!currentNode.getName().equals("ZZZ")) {
            char instruction = instructions.charAt(indexInstructions++);
            if (indexInstructions > instructions.length() - 1) {
                indexInstructions = 0;
            }
            if (instruction == 'L') {
                currentNode = currentNode.getLeft();
            } else if (instruction == 'R') {
                currentNode = currentNode.getRight();
            }
            steps++;
        }
        return steps;
    }

    public long task2() {
        List<Node> startNodes = new ArrayList<>();
        for (String s : map.keySet()) {
            if (s.charAt(s.length() - 1) == 'A') {
                startNodes.add(map.get(s));
            }
        }
        List<Long> stepsNeeded = new ArrayList<>();
        for (Node startNode : startNodes) {
            long steps = 0;
            int indexInstructions = 0;
            Node currentNode = startNode;
            while (!currentNode.getName().endsWith("Z")) {
                char instruction = instructions.charAt(indexInstructions++);
                if (indexInstructions > instructions.length() - 1) {
                    indexInstructions = 0;
                }
                if (instruction == 'L') {
                    currentNode = currentNode.getLeft();
                } else if (instruction == 'R') {
                    currentNode = currentNode.getRight();
                }
                steps++;
            }
            stepsNeeded.add(steps);
        }
        return new LCMofArrayOfNumbers().getLCM(stepsNeeded);
    }
}
