package AoC2023.Day16;

public class Beam {
    private int currentX;
    private int currentY;
    private char direction;

    public Beam(int currentX, int currentY, char direction) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.direction = direction;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void move() {
        if (direction == 'l') {
            currentX -= 1;
        } else if (direction == 'r') {
            currentX += 1;
        } else if (direction == 'u') {
            currentY -= 1;
        } else if (direction == 'd') {
            currentY += 1;
        }
    }
}
