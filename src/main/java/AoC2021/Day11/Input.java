package AoC2021.Day11;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Octopus> splitInput() {
        String[] inputSplit = input.split("\n");
        List<Octopus> result = new ArrayList<>();
        for (int y = 0; y < inputSplit.length; y++) {
            String line = inputSplit[y];
            for (int x = 0; x < line.length(); x++) {
                result.add(new Octopus(x, y, Integer.parseInt(line.substring(x, x + 1))));
            }
        }
        for (Octopus octopus : result) {
            for (Octopus possibleNeighbor : result) {
                octopus.addNeighbor(possibleNeighbor);
            }
        }
        return result;
    }
}
