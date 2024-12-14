package AoC2024.Day14;

public class Robot {

    private int currentX;
    private int currentY;

    private int vx;
    private int vy;

    public Robot(int currentX, int currentY, int vx, int vy) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.vx = vx;
        this.vy = vy;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void moveForSecond(int borderleft, int borderUp, int borderDown, int borderRight) {
        int x = currentX + vx;
        if (x < borderleft) {
            x = borderRight + x + 1;
        }
        if (x > borderRight) {
            x = borderleft + (x - borderRight) - 1;
        }
        currentX = x;

        int y = currentY + vy;
        if (y < borderUp) {
            y = borderDown + y + 1;
        }
        if (y > borderDown) {
            y = borderUp + (y - borderDown) - 1;
        }
        currentY = y;
    }
}
