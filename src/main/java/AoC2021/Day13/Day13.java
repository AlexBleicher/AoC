package AoC2021.Day13;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day13 {

    private Set<Dot> allDots;
    private List<Instruction> allInstructions;

    public Day13(String input) {
        Input inputSplitter = new Input(input);
        allDots = inputSplitter.splitCoordinates();
        allInstructions = inputSplitter.splitInstructions();
    }

    public int task1() {
        foldDots(allInstructions.get(0));
        return allDots.size();
    }

    public void foldDots(Instruction instruction) {
        if (instruction.isFoldUp()) {
            foldUp(instruction.getLineNumber());
        } else {
            foldSideways(instruction.getLineNumber());
        }
    }

    public void foldUp(int foldLine) {
        Set<Dot> allDotsUnderFoldLine = new HashSet<>();
        Set<Dot> allDotsOnFoldLine = new HashSet<>();
        for (Dot dot : allDots) {
            if (dot.getY() > foldLine) {
                allDotsUnderFoldLine.add(dot);
            } else if (dot.getY() == foldLine) {
                allDotsOnFoldLine.add(dot);
            }
        }
        allDots.removeAll(allDotsUnderFoldLine);
        allDots.removeAll(allDotsOnFoldLine);
        for (Dot dotToFold : allDotsUnderFoldLine) {
            Dot foldedDot = new Dot(dotToFold.getX(), foldLine - (dotToFold.getY() - foldLine));
            allDots.add(foldedDot);
        }
    }

    public void foldSideways(int foldLine) {
        Set<Dot> allDotsRightOfFoldLine = new HashSet<>();
        Set<Dot> allDotsOnFoldLine = new HashSet<>();
        for (Dot dot : allDots) {
            if (dot.getX() > foldLine) {
                allDotsRightOfFoldLine.add(dot);
            } else if (dot.getX() == foldLine) {
                allDotsOnFoldLine.add(dot);
            }
        }
        allDots.removeAll(allDotsRightOfFoldLine);
        allDots.removeAll(allDotsOnFoldLine);
        for (Dot dotToFold : allDotsRightOfFoldLine) {
            Dot foldedDot = new Dot(foldLine - (dotToFold.getX() - foldLine), dotToFold.getY());
            allDots.add(foldedDot);
        }

    }

    public void task2() {
        for (Instruction instruction : allInstructions) {
            foldDots(instruction);
        }
        visualizeDots();
    }

    public void visualizeDots() {
        List<Dot> sortedDotsByX = allDots.stream()
                .sorted(Comparator.comparingInt(Dot::getX))
                .collect(Collectors.toList());
        List<Dot> sortedDotsByY = allDots.stream()
                .sorted(Comparator.comparingInt(Dot::getY))
                .collect(Collectors.toList());
        String output = "";
        for (int y = 0; y <= (sortedDotsByY.get(sortedDotsByY.size() - 1)).getY(); y++) {
            for (int x = 0; x <= (sortedDotsByX.get(sortedDotsByX.size() - 1)).getX(); x++) {
                if (allDots.contains(new Dot(x, y))) {
                    output += "#";
                } else {
                    output += " ";
                }
            }


            output += "\n";
        }
        System.out.println(output);
    }
}
