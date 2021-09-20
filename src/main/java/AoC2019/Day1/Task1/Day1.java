package AoC2019.Day1.Task1;

import java.util.ArrayList;

public class Day1 {

    public long task1(String stringInput) {
        ArrayList<Integer> input = new Input(stringInput).transformInput();
        long result = 0;
        for (Integer integer : input) {
            result += (integer / 3) - 2;
        }
        return result;
    }

    public long task2(String stringInput) {
        ArrayList<Integer> input = new Input(stringInput).transformInput();
        long result = 0;
        for (Integer integer : input) {
            result += calculateFuelRecursively(integer);
        }
        return result;
    }

    private long calculateFuelRecursively(Integer massGiven) {
        long fuelNeeded = (massGiven / 3) - 2;
        if (((fuelNeeded / 3) - 2) <= 0) {
            return fuelNeeded;
        } else {
            long fuelNeededForFuel = calculateFuelRecursively((int) fuelNeeded);
            return (fuelNeeded + fuelNeededForFuel);
        }
    }
}

