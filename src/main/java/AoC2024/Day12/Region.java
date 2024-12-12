package AoC2024.Day12;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private final char letter;

    private List<Position> positions = new ArrayList<>();

    public Region(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    /*public boolean checkIfBelongsToPosition(Position p){
        Position leftNeighbor = new Position(p.getX()-1, p.getY());
        Position rightNeighbor = new Position(p.getX()+1, p.getY());
        Position upperNeighbor = new Position(p.getX(), p.getY()-1);
        Position lowerNeighbor = new Position(p.getX(), p.getY()+1);

        return positions.contains(leftNeighbor)||positions.contains(rightNeighbor)||positions.contains(upperNeighbor)||positions.contains(lowerNeighbor);
    }*/

    public void addAllPositions(List<Position> p) {
        positions.addAll(p);
    }

    public void addPosition(Position p) {
        positions.add(p);
    }

    public List<Position> getPositions() {
        return positions;
    }

    public long calculateSides() {
        long sides = 0;
        for (Position p : positions) {
            Position leftNeighbor = new Position(p.getX() - 1, p.getY(), letter);
            Position rightNeighbor = new Position(p.getX() + 1, p.getY(), letter);
            Position upperNeighbor = new Position(p.getX(), p.getY() - 1, letter);
            Position lowerNeighbor = new Position(p.getX(), p.getY() + 1, letter);
            Position upperRightDiagonalNeighbor = new Position(p.getX() + 1, p.getY() - 1, letter);
            Position lowerRightDiagonalNeighbor = new Position(p.getX() + 1, p.getY() + 1, letter);
            Position upperLeftDiagonalNeighbor = new Position(p.getX() - 1, p.getY() - 1, letter);
            Position lowerLeftDiagonalNeighbor = new Position(p.getX() - 1, p.getY() + 1, letter);
            if (!positions.contains(leftNeighbor) && !positions.contains(upperNeighbor)) {
                sides++;
            }
            if (positions.contains(upperNeighbor) && positions.contains(rightNeighbor) && !positions.contains(upperRightDiagonalNeighbor)) {
                sides++;
            }
            if (positions.contains(upperNeighbor) && positions.contains(leftNeighbor) && !positions.contains(upperLeftDiagonalNeighbor)) {
                sides++;
            }
            if (positions.contains(lowerNeighbor) && positions.contains(rightNeighbor) && !positions.contains(lowerRightDiagonalNeighbor)) {
                sides++;
            }
            if (positions.contains(lowerNeighbor) && positions.contains(leftNeighbor) && !positions.contains(lowerLeftDiagonalNeighbor)) {
                sides++;
            }
            if (!positions.contains(leftNeighbor) && !positions.contains(lowerNeighbor)) {
                sides++;
            }
            if (!positions.contains(rightNeighbor) && (!positions.contains(upperNeighbor))) {
                sides++;
            }
            if (!positions.contains(rightNeighbor) && (!positions.contains(lowerNeighbor))) {
                sides++;
            }

        }
        return sides;
    }

    public long calculatePerimeter() {
        long res = 0;
        for (Position p : positions) {
            Position leftNeighbor = new Position(p.getX() - 1, p.getY(), letter);
            Position rightNeighbor = new Position(p.getX() + 1, p.getY(), letter);
            Position upperNeighbor = new Position(p.getX(), p.getY() - 1, letter);
            Position lowerNeighbor = new Position(p.getX(), p.getY() + 1, letter);

            if (!positions.contains(lowerNeighbor)) {
                res++;
            }
            if (!positions.contains(upperNeighbor)) {
                res++;
            }
            if (!positions.contains(leftNeighbor)) {
                res++;
            }
            if (!positions.contains(rightNeighbor)) {
                res++;
            }
        }
        return res;
    }
}
