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
        int lineLength = inputLines[0].length();
        int y = 0;
        for (String inputLine : inputLines) {
            for (int x = 0; x < inputLine.length(); x++) {
                int risk = Integer.parseInt("" + inputLine.charAt(x));
                RiskLevel newRiskLevel = new RiskLevel(x, y, risk);
                returnValue.add(newRiskLevel);
                for (int i = 1; i < 5; i++) {
                    risk += 1;
                    if (risk == 10) {
                        risk = 1;
                    }
                    RiskLevel riskLevelToAdd = new RiskLevel((x + i * lineLength), y, risk);
                    returnValue.add(riskLevelToAdd);
                }
            }
            y++;
        }
        List<RiskLevel> risksToAdd = new ArrayList<>();
        for (RiskLevel riskLevel : returnValue) {
            int risk = riskLevel.getRisk();
            for (int i = 1; i < 5; i++) {
                risk += 1;
                if (risk == 10) {
                    risk = 1;
                }
                RiskLevel riskLevelToAdd = new RiskLevel(riskLevel.getX(), riskLevel.getY() + i * lineLength, risk);
                risksToAdd.add(riskLevelToAdd);
            }
        }
        returnValue.addAll(risksToAdd);
        List<RiskLevel> risksStillToCheck = new ArrayList<>();
        risksStillToCheck.addAll(returnValue);
        for (RiskLevel riskLevel : returnValue) {
            for (RiskLevel possibleNeighbor : risksStillToCheck) {
                if (((possibleNeighbor.getX() == riskLevel.getX() - 1 || possibleNeighbor.getX() == riskLevel.getX() + 1) && possibleNeighbor.getY() == riskLevel.getY()) ||
                        (possibleNeighbor.getY() == riskLevel.getY() - 1 || possibleNeighbor.getY() == riskLevel.getY() + 1) && possibleNeighbor.getX() == riskLevel.getX()) {
                    riskLevel.neighbors.add(possibleNeighbor);
                    possibleNeighbor.neighbors.add(riskLevel);
                }
            }
            risksStillToCheck.remove(risksStillToCheck.indexOf(riskLevel));
        }
        return returnValue;
    }
}
