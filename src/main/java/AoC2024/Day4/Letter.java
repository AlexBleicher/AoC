package AoC2024.Day4;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private char letter;
    private List<Letter> neighbors = new ArrayList<>();

    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public List<Letter> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Letter> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Letter n) {
        neighbors.add(n);
    }
}
