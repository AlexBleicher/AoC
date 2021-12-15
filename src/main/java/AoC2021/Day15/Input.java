package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<RiskLevel> splitInput(){
        String[] inputSplit = input.split("\n");
        List<RiskLevel> result = new ArrayList<>();
        for(int y=0; y<inputSplit.length; y++){
            String inputLine = inputSplit[y];
            for(int x=0; x<inputLine.length(); x++){
                result.add(new RiskLevel(x, y, Integer.parseInt(inputLine.substring(x,x+1))));
            }
        }
        for (RiskLevel riskLevel : result) {
            for (RiskLevel level : result) {
                riskLevel.addNeighbor(level);
            }
        }
        return result;
    }
}
