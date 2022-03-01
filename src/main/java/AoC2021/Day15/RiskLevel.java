package AoC2021.Day15;

import java.util.ArrayList;
import java.util.List;

public class RiskLevel {

    private int x;
    private int y;
    private int risk;
    public List<RiskLevel> neighbors = new ArrayList<>();

    public RiskLevel(int x, int y, int risk) {
        this.x = x;
        this.y = y;
        this.risk = risk;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRisk() {
        return risk;
    }
}
