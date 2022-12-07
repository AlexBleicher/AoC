package AoC2022.Day7;

public class File {

    private long size;
    private String name;

    public long getSize() {
        return size;
    }

    public File(String name) {
        this.name = name;
    }

    public File(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
