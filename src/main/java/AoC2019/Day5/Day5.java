package AoC2019.Day5;

import AoC2019.Day2.Input;

import java.util.ArrayList;

public class Day5 {

    private ArrayList<Integer> intcode;

    public Day5(String input) {
        this.intcode = new Input(input).transformInput();
    }

    public void runIntCode() {
        int index = 0;
        int optcode = intcode.get(index);
        while (optcode != 99) {
            switch (optcode) {
                case (1):
                    index += 4;
                    break;
                case (2):
                    index += 4;
                    break;
                case (3):
                    index += 2;
                    break;
                case (4):
                    index += 2;
                    break;
                default:
                    throw new RuntimeException("Diese Zahl ist hier falsch!");
            }
            optcode = intcode.get(index);
        }
    }

    public void add(int value1, int value2, int storeAddress) {
        intcode.set(storeAddress, value1 + value2);
    }

    public void multiply(int value1, int value2, int storeAddress) {
        intcode.set(storeAddress, value1 * value2);
    }

    public void store(int value, int storeAddress) {
        intcode.set(storeAddress, value);
    }

    public int putout(int storeAddress) {
        return intcode.get(storeAddress);
    }
}
