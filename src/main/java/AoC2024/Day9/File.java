package AoC2024.Day9;

public class File {

    private boolean isFree;
    private int id;

    public File(boolean isFree, int id) {
        this.isFree = isFree;
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
