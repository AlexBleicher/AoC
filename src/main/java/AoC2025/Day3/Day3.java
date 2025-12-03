package AoC2025.Day3;

import java.util.List;

public class Day3 {

    private List<Bank> banks;

    public Day3(String i) {
        banks = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (Bank bank : banks) {
            bank.setMaximumJoltage2Batteries();
            res += bank.getJoltage();
        }
        return res;
    }

    public long task2() {
        long res = 0;
        for (Bank bank : banks) {
            bank.setMaximumJoltage12Batteries();
            res += bank.getJoltage();
        }
        return res;
    }
}
