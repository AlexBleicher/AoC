package AoC2022.Day8;

public class Tree {

    private int x;
    private int y;
    private int height;
    private int scenicScore = 1;
    private boolean isAtEdge;

    public Tree(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public boolean isAtEdge() {
        return isAtEdge;
    }

    public void setAtEdge(boolean atEdge) {
        isAtEdge = atEdge;
    }

    public int getScenicScore() {
        return scenicScore;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public void addToScenicScore(int value) {
        scenicScore *= value;
    }
}
