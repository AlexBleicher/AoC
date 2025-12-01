package AoC2025.Day1;

import java.util.List;

public class Day1 {

    private List<Integer> turns;

    public Day1(String i) {
        turns = new Input(i).parseInput();
    }

    public int task1() {
        int currentValue = 50;
        int res = 0;
        for (Integer turn : turns) {
            currentValue = (currentValue + turn) % 100;
            if (currentValue == 0) {
                res++;
            }
        }
        return res;
    }

    public int task2() {
        int currentValue = 50;
        int res = 0;
        for (Integer turn : turns) {
            if (turn > 0) {
                for (Integer i = 0; i < turn; i++) {
                    currentValue = (currentValue + 1) % 100;
                    if(currentValue==0){
                        res++;
                    }
                }
            }
            else{
                for (Integer i = turn; i < 0; i++) {
                    currentValue = (currentValue - 1) % 100;
                    if(currentValue==0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
