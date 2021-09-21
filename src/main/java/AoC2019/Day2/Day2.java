package AoC2019.Day2;

import java.util.ArrayList;

public class Day2 {

    private ArrayList<Integer> intProgram;

    public Day2(String stringInput) {
        intProgram = new Input(stringInput).transformInput();
    }

    public ArrayList<Integer> runIntProgram() {
        int index = 0;
        int optcode = intProgram.get(index);
        while (optcode != 99) {
            int resultPosition = intProgram.get(index + 3);
            if (optcode == 1) {
                intProgram.set(resultPosition, intProgram.get(intProgram.get(index + 1)) + intProgram.get(intProgram.get(index + 2)));
            } else if (optcode == 2) {
                intProgram.set(resultPosition, intProgram.get(intProgram.get(index + 1)) * intProgram.get(intProgram.get(index + 2)));
            } else {
                throw new RuntimeException("Diese Zahl sollte hier nicht stehen!");
            }
            index += 4;
            optcode = intProgram.get(index);
        }
        return intProgram;
    }

    public int solveTask1() {
        intProgram.set(1, 12);
        intProgram.set(2, 2);
        return runIntProgram().get(0);
    }
}
