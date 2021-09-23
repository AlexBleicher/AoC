package AoC2019.Day3;

import java.util.HashSet;

public class Wire {

    private final HashSet<Coordinate> coordinates = new HashSet<>();

    public Wire(String instructions) {
        String[] wireSections = instructions.split(",");
        int x = 0;
        int y = 0;
        int stepsNeeded = 0;
        for (String section : wireSections) {
            char direction = section.charAt(0);
            int distance = Integer.parseInt(section.substring(1));
            for (int i = 0; i < distance; i++) {
                switch (direction) {
                    case ('R'):
                        x++;
                        break;
                    case ('L'):
                        x--;
                        break;
                    case ('U'):
                        y++;
                        break;
                    case ('D'):
                        y--;
                        break;
                    default:
                        throw new IllegalStateException("Das sollte hier nicht stehen!");
                }
                stepsNeeded++;
                coordinates.add(new Coordinate(x, y, stepsNeeded));
            }
        }
    }

    public HashSet<Coordinate> getCoordinates() {
        return coordinates;
    }
}
