package AoC2021.Day12;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Cave> splitInput() {
        String[] inputSplit = input.split("\n");
        List<Cave> allCaves = new ArrayList<>();
        for (String line : inputSplit) {
            String[] lineSplit = line.split("-");
            Cave caveLeft = new Cave(lineSplit[0], Character.isLowerCase(lineSplit[0].charAt(0)));
            Cave caveRight = new Cave(lineSplit[1], Character.isLowerCase(lineSplit[1].charAt(0)));
            if (!allCaves.contains(caveLeft)) {
                allCaves.add(caveLeft);
            } else {
                caveLeft = allCaves.get(allCaves.indexOf(caveLeft));
            }
            if (!allCaves.contains(caveRight)) {
                allCaves.add(caveRight);
            } else {
                caveRight = allCaves.get(allCaves.indexOf(caveRight));
            }
            caveLeft.addConnection(caveRight);
            caveRight.addConnection(caveLeft);
        }
        return allCaves;
    }
}
