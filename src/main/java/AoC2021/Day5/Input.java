package AoC2021.Day5;

import java.util.ArrayList;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<Lines> splitInput() {
        String[] linesOfInput = input.split("\n");
        ArrayList<Lines> result = new ArrayList<>();
        for (String lineOfInput : linesOfInput) {
            String[] startAndFinish = lineOfInput.split(" -> ");
            String start = startAndFinish[0];
            String finish = startAndFinish[1];
            int startX = Integer.parseInt(start.split(",")[0]);
            int startY = Integer.parseInt(start.split(",")[1]);
            int endX = Integer.parseInt(finish.split(",")[0]);
            int endY = Integer.parseInt(finish.split(",")[1]);
            Lines line = new Lines(startX, startY, endX, endY);
            result.add(line);
        }
        return result;
    }
}
