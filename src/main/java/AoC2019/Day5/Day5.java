package AoC2019.Day5;

import AoC2019.Day2.Input;

import java.util.ArrayList;

public class Day5 {

    private ArrayList<Integer> intcode;

    public Day5(String input) {
        this.intcode = new Input(input).transformInput();
    }

    public int runIntCode(int inputValue) {
        int diagnosticCode = 0;
        int index = 0;
        int optcode = intcode.get(index) % 100;
        while (optcode != 99) {
            int value1;
            int value2;
            int modeValue1 = intcode.get(index) / 100 % 10;
            int modeValue2 = intcode.get(index) / 1000 % 10;
            int store = intcode.get(index + 3);
            switch (optcode) {
                case (1):
                    value1 = (modeValue1 == 1 ? intcode.get(index + 1) : intcode.get(intcode.get(index + 1)));
                    value2 = (modeValue2 == 1 ? intcode.get(index + 2) : intcode.get(intcode.get(index + 2)));
                    add(value1, value2, store);
                    index += 4;
                    break;
                case (2):
                    value1 = (modeValue1 == 1 ? intcode.get(index + 1) : intcode.get(intcode.get(index + 1)));
                    value2 = (modeValue2 == 1 ? intcode.get(index + 2) : intcode.get(intcode.get(index + 2)));
                    multiply(value1, value2, store);
                    index += 4;
                    break;
                case (3):
                    store = intcode.get(index + 1);
                    putin(inputValue, store);
                    index += 2;
                    break;
                case (4):
                    store = intcode.get(index + 1);
                    diagnosticCode = putout(store);
                    System.out.println(diagnosticCode);
                    index += 2;
                    break;
                case (5):
                    if ((modeValue1 == 1) ? (intcode.get(index + 1) != 0) : (intcode.get(intcode.get(index + 1)) != 0)) {
                        index = (modeValue2 == 1 ? intcode.get(index + 2) : intcode.get(intcode.get(index + 2)));
                    } else {
                        index += 3;
                    }
                    break;
                case (6):
                    if ((modeValue1 == 1) ? (intcode.get(index + 1) == 0) : (intcode.get(intcode.get(index + 1)) == 0)) {
                        index = (modeValue2 == 1 ? intcode.get(index + 2) : intcode.get(intcode.get(index + 2)));
                    } else {
                        index += 3;
                    }
                    break;
                case (7):
                    if ((modeValue1 == 1 ? intcode.get(index + 1) : intcode.get(intcode.get(index + 1))) < (modeValue2 == 1 ? intcode.get(index + 2) : intcode.get(intcode.get(index + 2)))) {
                        intcode.set(store, 1);
                    } else {
                        intcode.set(store, 0);
                    }
                    index += 4;
                    break;
                case (8):
                    if ((modeValue1 == 1 ? intcode.get(index + 1) : intcode.get(intcode.get(index + 1))) == (modeValue2 == 1 ? intcode.get(index + 2) : intcode.get(intcode.get(index + 2)))) {
                        intcode.set(store, 1);
                    } else {
                        intcode.set(store, 0);
                    }
                    index += 4;
                    break;
                default:
                    throw new RuntimeException("Diese Zahl ist hier falsch!");
            }
            optcode = intcode.get(index) % 100;
        }
        return diagnosticCode;
    }

    public void add(int value1, int value2, int storeAddress) {
        intcode.set(storeAddress, value1 + value2);
    }

    public void multiply(int value1, int value2, int storeAddress) {
        intcode.set(storeAddress, value1 * value2);
    }

    public void putin(int value, int storeAddress) {
        intcode.set(storeAddress, value);
    }

    public int putout(int storeAddress) {
        return intcode.get(storeAddress);
    }

    public int task1(int inputValue) {
        return runIntCode(inputValue);
    }

    public int task2(int inputValue) {
        return runIntCode(inputValue);
    }

}
