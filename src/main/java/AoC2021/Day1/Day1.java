package AoC2021.Day1;

import java.util.ArrayList;

public class Day1 {

    private ArrayList<Integer> inputList;

    public int task1(String input) {
        inputList = new Input(input).splitInput();
        return countIncreases(inputList);
    }

    public int task2(String input) {
        inputList = new Input(input).splitInput();
        return countIncreases(buildWindows(inputList));
    }

    public int countIncreases(ArrayList<Integer> inputList) {
        int lastInt = inputList.get(0);
        int increases = 0;
        for (int i = 1; i < inputList.size(); i++) {
            int thisInt = inputList.get(i);
            if (thisInt > lastInt) {
                increases++;
            }
            lastInt = thisInt;
        }
        return increases;
    }

    public ArrayList<Integer> buildWindows(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size() - 2; i++) {
            int thisWindow = input.get(i) + input.get(i + 1) + input.get(i + 2);
            result.add(thisWindow);
        }
        return result;
    }

}
