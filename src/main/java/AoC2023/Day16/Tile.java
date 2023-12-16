package AoC2023.Day16;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private char symbol;
    private boolean isEnergized = false;

    private List<Character> visitedFrom = new ArrayList<>();

    public Tile(char s) {
        symbol = s;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isEnergized() {
        return isEnergized;
    }

    public void setEnergized(boolean e) {
        isEnergized = e;
    }

    public boolean hasBeenVisitedFromDirection(char d) {
        return visitedFrom.contains(d);
    }

    public void addVisitedDirection(char d) {
        visitedFrom.add(d);
    }

    public void deletedVisitedFromDirection() {
        visitedFrom = new ArrayList<>();
    }
}
