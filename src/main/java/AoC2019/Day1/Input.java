package AoC2019.Day1;

import java.util.ArrayList;

public class Input {

    private String input = "";

    public Input(String stringInput) {
        this.input = stringInput;
    }

    public ArrayList<Integer> transformInput() {
        String[] splitInput = input.split("\n");
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (String s : splitInput) {
            resultList.add(Integer.parseInt(s));
        }
        return resultList;
    }
}
