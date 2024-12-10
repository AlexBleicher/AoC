package AoC2024.Day10;

public class Position {

    private boolean alreadyVisited;

    private int x;
    private int y;

    private int score;

    public Position(boolean alreadyVisited, int x, int y, int score) {
        this.alreadyVisited = alreadyVisited;
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public boolean isAlreadyVisited() {
        return alreadyVisited;
    }

    public void setAlreadyVisited(boolean alreadyVisited) {
        this.alreadyVisited = alreadyVisited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }
}
