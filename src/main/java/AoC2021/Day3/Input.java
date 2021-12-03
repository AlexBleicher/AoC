package AoC2021.Day3;

import java.util.ArrayList;
import java.util.Arrays;

public class Input {

    private String input;

    public Input(String userInput){
        input = userInput;
    }

    public ArrayList<String> splitInput(){
        String[] splitInput = input.split("\n");
        return new ArrayList<>(Arrays.asList(splitInput));
    }
}
