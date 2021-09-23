package AoC2019.Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {


    List<Password> allPasswords = new ArrayList<>();


    public Day4(String input) {
        String[] splitInput = input.split("-");
        int lowerBorder = Integer.parseInt(splitInput[0]);
        int upperBorder = Integer.parseInt(splitInput[1]);
        for (int i = lowerBorder; i <= upperBorder; i++) {
            allPasswords.add(new Password(i));
        }
    }

    public int task1() {
        List<Password> allValidPasswords = allPasswords.stream()
                .filter(Password::neverDecreases)
                .filter(Password::hasDouble)
                .collect(Collectors.toList());
        return allValidPasswords.size();
    }

    public int task2() {
        List<Password> allValidPasswords = allPasswords.stream()
                .filter(Password::neverDecreases)
                .filter(Password::hasLonelyDouble)
                .collect(Collectors.toList());
        return allValidPasswords.size();
    }
}
