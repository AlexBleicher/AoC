package AoC2021.Day6;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public long[] splitInput() {
        String[] splitInput = input.split(",");
        long[] restClassesOfDays = new long[7];
        for (String s : splitInput) {
            restClassesOfDays[Integer.parseInt(s)]++;
        }
        return restClassesOfDays;
    }
}
