package AoC2024.Day3;

public class Enabled {

    private int startIndex;
    private boolean enabled;

    public Enabled(int startIndex, boolean enabled) {
        this.startIndex = startIndex;
        this.enabled = enabled;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
