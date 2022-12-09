package AoC2022.Day9;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Command> parseInput() {
        List<Command> commands = new ArrayList<>();
        String[] inputLines = input.split("\n");
        for (String inputLine : inputLines) {
            String[] splitCommand = inputLine.split(" ");
            Command newCommand;
            int steps = Integer.parseInt(splitCommand[1]);
            if (splitCommand[0].equals("R")) {
                newCommand = new Command(Direction.Right, steps);
            } else if (splitCommand[0].equals("L")) {
                newCommand = new Command(Direction.Left, steps);
            } else if (splitCommand[0].equals("U")) {
                newCommand = new Command(Direction.Up, steps);
            } else if (splitCommand[0].equals("D")) {
                newCommand = new Command(Direction.Down, steps);
            } else {
                newCommand = null;
            }
            if (newCommand != null) {
                commands.add(newCommand);
            }

        }
        return commands;
    }
}
