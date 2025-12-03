package AoC2025.Day3;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Integer> batteries;
    private long joltage;

    public Bank() {
        batteries = new ArrayList<>();
        joltage = 0;
    }

    public void addBattery(int i) {
        batteries.add(i);
    }

    public void setMaximumJoltage2Batteries() {
        int maximumFirst = 0;
        int indexFirst = 0;
        int maximumSecond = 0;
        for (int i = 0; i < batteries.size() - 1; i++) {
            if (batteries.get(i) > maximumFirst) {
                maximumFirst = batteries.get(i);
                indexFirst = i;
            }
        }
        for (int i = indexFirst + 1; i < batteries.size(); i++) {
            if (batteries.get(i) > maximumSecond) {
                maximumSecond = batteries.get(i);
            }
        }
        joltage = 10 * maximumFirst + maximumSecond;
    }

    public void setMaximumJoltage12Batteries() {
        int currentIndex = 0;
        for (int i = 11; i >= 0; i--) {
            int maximum = 0;
            for (int in = currentIndex; in < batteries.size() - i; in++) {
                if (batteries.get(in) > maximum) {
                    maximum = batteries.get(in);
                    currentIndex = in + 1;
                }
            }
            long power = (long) Math.pow(10, i);
            joltage += (power * maximum);
        }
    }

    public long getJoltage() {
        return joltage;
    }
}
