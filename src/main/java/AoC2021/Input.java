package AoC2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<String> splitInput(){
        ArrayList<String> result = new ArrayList<>(Arrays.asList(input.split("\n")));
        return result;
    }
}
