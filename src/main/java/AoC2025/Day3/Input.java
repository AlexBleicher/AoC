package AoC2025.Day3;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<Bank> parseInput() {
        String[] split = input.split("\n");
        List<Bank> res = new ArrayList<>();
        for (String s : split) {
            Bank bank = new Bank();
            for (int i = 0; i < s.length(); i++) {
                bank.addBattery(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
            res.add(bank);
        }
        return res;
    }
}
