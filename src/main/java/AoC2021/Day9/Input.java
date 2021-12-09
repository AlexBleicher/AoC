package AoC2021.Day9;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<HeightLevel> splitInput() {
        String[] inputSplit = input.split("\n");
        List<HeightLevel> allHightLevels = new ArrayList<>();
        for (int y = 0; y < inputSplit.length; y++) {
            for (int x = 0; x < inputSplit[y].length(); x++) {
                HeightLevel thisHeight = new HeightLevel(Integer.parseInt(inputSplit[y].substring(x, x + 1)), x, y);
                allHightLevels.add(thisHeight);
            }
        }
        for (HeightLevel heightLevel : allHightLevels) {
            if (heightLevel.getX() != 0) {
                for (HeightLevel searchHeightLevel : allHightLevels) {
                    if (searchHeightLevel.getX() == heightLevel.getX() - 1 && searchHeightLevel.getY() == heightLevel.getY()) {
                        heightLevel.setAdjacentLeft(searchHeightLevel);
                        break;
                    }
                }
            }
            if (heightLevel.getY() != 0) {
                for (HeightLevel searchHeightLevel : allHightLevels) {
                    if (searchHeightLevel.getY() == heightLevel.getY() - 1 && searchHeightLevel.getX() == heightLevel.getX()) {
                        heightLevel.setAdjacentUp(searchHeightLevel);
                        break;
                    }
                }
            }
            if (heightLevel.getX() != inputSplit[0].length()) {
                for (HeightLevel searchHeightLevel : allHightLevels) {
                    if (searchHeightLevel.getX() == heightLevel.getX() + 1 && searchHeightLevel.getY() == heightLevel.getY()) {
                        heightLevel.setAdjacentRight(searchHeightLevel);
                        break;
                    }
                }
            }
            if (heightLevel.getY() != inputSplit.length) {
                for (HeightLevel searchHeightLevel : allHightLevels) {
                    if (searchHeightLevel.getY() == heightLevel.getY() + 1 && searchHeightLevel.getX() == heightLevel.getX()) {
                        heightLevel.setAdjacentDown(searchHeightLevel);
                        break;
                    }
                }
            }
        }
        return allHightLevels;
    }
}
