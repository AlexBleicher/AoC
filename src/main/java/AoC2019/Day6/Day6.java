package AoC2019.Day6;

import java.util.ArrayList;
import java.util.HashSet;

public class Day6 {

    private HashSet<Object> allObjects = new HashSet<>();
    private ArrayList<String[]> inputString;

    public Day6(String input) {
        inputString = new Input(input).transformInput();
        for (String[] strings : inputString) {
            allObjects.add(new Object(strings[0]));
            allObjects.add(new Object(strings[1]));
        }
    }
    
}
