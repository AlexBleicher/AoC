package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public String input;

    public Input(String input) {
        this.input = input;
    }

    public List<RiskLevel> parseInput() {
        List<RiskLevel> returnValue = new ArrayList<>();
        String[] inputLines = input.split("\n");
        int y = 0;
        for (String inputLine : inputLines) {
            for (int x = 0; x < inputLine.length(); x++) {
                RiskLevel newRiskLevel = new RiskLevel(x, y, Integer.parseInt("" + inputLine.charAt(x)));
                returnValue.add(newRiskLevel);
            }
            y++;
        }
        for (RiskLevel riskLevel : returnValue) {
            for (RiskLevel possibleNeighbor : returnValue) {
                if (((possibleNeighbor.getX() == riskLevel.getX() - 1 || possibleNeighbor.getX() == riskLevel.getX() + 1) && possibleNeighbor.getY() == riskLevel.getY()) ||
                        (possibleNeighbor.getY() == riskLevel.getY() - 1 || possibleNeighbor.getY() == riskLevel.getY() + 1) && possibleNeighbor.getX() == riskLevel.getX()) {
                    riskLevel.neighbors.add(possibleNeighbor);
                }
            }
        }
        return returnValue;
    }
}
