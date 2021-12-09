package AoC2021.Day9;

public class HeightLevel {

    private HeightLevel adjacentLeft;
    private HeightLevel adjacentRight;
    private HeightLevel adjacentUp;
    private HeightLevel adjacentDown;
    private int x;
    private int y;
    private int value;

    public HeightLevel(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setAdjacentLeft(HeightLevel adjacentLeft) {
        this.adjacentLeft = adjacentLeft;
    }

    public void setAdjacentRight(HeightLevel adjacentRight) {
        this.adjacentRight = adjacentRight;
    }

    public void setAdjacentUp(HeightLevel adjacentUp) {
        this.adjacentUp = adjacentUp;
    }

    public void setAdjacentDown(HeightLevel adjacentDown) {
        this.adjacentDown = adjacentDown;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLowPoint() {
        return (adjacentLeft == null || value < adjacentLeft.getValue()) && (adjacentRight == null || value < adjacentRight.getValue()) && (adjacentDown == null || value < adjacentDown.getValue()) && (adjacentUp == null || value < adjacentUp.getValue());
    }

    public HeightLevel getAdjacentLeft() {
        if (adjacentLeft != null) {
            return adjacentLeft;
        } else {
            return null;
        }
    }

    public HeightLevel getAdjacentRight() {
        if (adjacentRight != null) {
            return adjacentRight;
        } else {
            return null;
        }
    }

    public HeightLevel getAdjacentUp() {
        if (adjacentUp != null) {
            return adjacentUp;
        }
        return null;
    }

    public HeightLevel getAdjacentDown() {
        if (adjacentDown != null) {
            return adjacentDown;
        }
        return null;
    }
}
