package AoC2024.Day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {
    private int x;
    private int y;

    private List<Position> neighbors = new ArrayList<>();
    private boolean visited = false;
    private char letter;

    public Position(int x, int y, char l) {
        this.x = x;
        this.y = y;
        letter = l;
    }

    public char getLetter() {
        return letter;
    }

    public List<Position> getNeighbors() {
        return neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addToNeighbors(Position p) {
        neighbors.add(p);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
