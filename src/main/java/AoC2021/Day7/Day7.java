package AoC2021.Day7;

import java.util.ArrayList;
import java.util.HashSet;

public class Day7 {

    private ArrayList<Integer> crabSubs;
    private HashSet<Integer> allPositions;

    public Day7(String input) {
        crabSubs = new Input(input).splitInput();
        allPositions = new HashSet<>();
        for (int i = 0; i < crabSubs.size(); i++) {
            allPositions.add(i);
        }
    }

    public int task1() {
        return calculateLeastFuel();
    }

    public int calculateLeastFuel() {
        int leastAmountOfFuel = -1;
        for (Integer position : allPositions) {
            int fuelCost = calculateFuelCost(position);
            if (leastAmountOfFuel == -1 || leastAmountOfFuel > fuelCost) {
                leastAmountOfFuel = fuelCost;
            }
        }
        return leastAmountOfFuel;
    }

    public int calculateFuelCost(int position) {
        int totalFuelCost = 0;
        for (Integer crabSub : crabSubs) {
            if (crabSub > position) {
                totalFuelCost += (crabSub - position);
            } else {
                totalFuelCost += (position - crabSub);
            }
        }
        return totalFuelCost;
    }

    public int task2() {
        return calculateLeastFuel2();
    }

    public int calculateLeastFuel2() {
        int leastAmountOfFuel = -1;
        for (Integer position : allPositions) {
            int fuelCost = calculateFuelCost2(position);
            if (leastAmountOfFuel == -1 || leastAmountOfFuel > fuelCost) {
                leastAmountOfFuel = fuelCost;
            }
        }
        return leastAmountOfFuel;
    }

    public int calculateFuelCost2(int pos) {
        int totalFuelCost = 0;
        for (Integer crabSub : crabSubs) {
            if (crabSub > pos) {
                for (int i = 1; i <= (crabSub - pos); i++) {
                    totalFuelCost += i;
                }
            } else if (crabSub < pos) {
                for (int i = 1; i <= (pos - crabSub); i++) {
                    totalFuelCost += i;
                }
            }
        }
        return totalFuelCost;
    }
}
