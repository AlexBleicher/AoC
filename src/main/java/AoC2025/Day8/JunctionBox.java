package AoC2025.Day8;

public class JunctionBox {

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double calcDistance(JunctionBox jb) {
        return Math.sqrt(Math.pow(jb.getX() - x, 2) + Math.pow(jb.getY() - y, 2) + Math.pow(jb.getZ() - z, 2));
    }
}
