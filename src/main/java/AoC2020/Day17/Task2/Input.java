package AoC2020.Day17.Task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    private String input = "...#..#.\n" +
            ".....##.\n" +
            "##..##.#\n" +
            "#.#.##..\n" +
            "#..#.###\n" +
            "...##.#.\n" +
            "#..##..#\n" +
            ".#.#..#.";

    public Set<Coordinate> getAllFirstActiveCubes() {
        Set<Coordinate> allFirstActiveCubes = new HashSet();
        List<String> lines = Arrays.asList(input.split("\n"));
        int y = 0;
        for (String line : lines) {
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    allFirstActiveCubes.add(new Coordinate(0, x, y, 0));
                }
            }
            y++;
        }
        return allFirstActiveCubes;
    }
}
