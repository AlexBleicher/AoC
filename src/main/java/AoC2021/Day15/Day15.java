package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    private List<RiskLevel> riskLevelList;

    public Day15(String input) {
        riskLevelList = new Input(input).splitInput();
    }

    public int task1() {
        return lowestRiskPath();
    }

    public int lowestRiskPath(){
        RiskLevel bottom = riskLevelList.get(riskLevelList.size()-1);
        List<List<RiskLevel>> allPaths = riskLevelList.get(0).getAllPathsToEnd(bottom);
        int min =-1;
        for (List<RiskLevel> path : allPaths) {
            int scoreOfPath =0;
            for (RiskLevel riskLevel : path) {
                scoreOfPath+=riskLevel.getValue();
            }
            if(min==-1||min>scoreOfPath){
                min = scoreOfPath;
            }
        }
        return min;
    }
}
