package AoC2024.Day15;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public char[][] parseInputMap() {
        String s = input.split("\n\n")[0];
        String[] split = s.split("\n");
        char[][] map = new char[split.length][split[0].length()];
        for (int y = 0; y < split.length; y++) {
            String line = split[y];
            for (int x = 0; x < line.length(); x++) {
                map[y][x] = line.charAt(x);
            }
        }
        return map;
    }

    public char[][] parseInputMap2() {
        String s = input.split("\n\n")[0];
        String[] split = s.split("\n");
        char[][] map = new char[split.length][split[0].length() * 2];
        for (int y = 0; y < split.length; y++) {
            String line = split[y];
            int xInMap = 0;
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                if (c == '#') {
                    map[y][xInMap++] = '#';
                    map[y][xInMap++] = '#';
                } else if (c == 'O') {
                    map[y][xInMap++] = '[';
                    map[y][xInMap++] = ']';
                } else if (c == '.') {
                    map[y][xInMap++] = '.';
                    map[y][xInMap++] = '.';
                } else if (c == '@') {
                    map[y][xInMap++] = '@';
                    map[y][xInMap++] = '.';
                }
            }
        }
        return map;
    }

    public List<Character> parseInputInstructions() {
        String s = input.split("\n\n")[1];
        String[] split = s.split("\n");
        List<Character> instructions = new ArrayList<>();
        for (String string : split) {
            for (int i = 0; i < string.length(); i++) {
                instructions.add(string.charAt(i));
            }
        }
        return instructions;
    }
}
