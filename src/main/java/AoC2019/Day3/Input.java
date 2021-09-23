package AoC2019.Day3;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public String[] transformInput() {
        return input.split("\n");
    }
}
