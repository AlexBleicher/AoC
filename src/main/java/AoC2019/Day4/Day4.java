package AoC2019.Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    private int lowerBorder;
    private int upperBorder;

    public Day4(String input) {
        String[] splitInput = input.split("-");
        lowerBorder = Integer.parseInt(splitInput[0]);
        upperBorder = Integer.parseInt(splitInput[1]);
    }

    public int task1() {
        List<Password> allPasswords = new ArrayList<>();
        for (int i = lowerBorder; i <= upperBorder; i++) {
            allPasswords.add(new Password(i));
        }
        List<Password> allValidPasswords = allPasswords.stream()
                .filter(Password::neverDecreases)
                .filter(Password::hasDouble)
                .collect(Collectors.toList());
        return allValidPasswords.size();
    }
}
