package AoC2022.Day1;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public String input;

    public Input(String input) {
        this.input = input;
    }

    public List<ElfPackage> parseInput() {
        List<ElfPackage> resultList = new ArrayList<>();
        String[] elves = input.split("\n\n");
        int i = 1;
        for (String elf : elves) {
            List<Integer> caloriesOfElf = new ArrayList<>();
            String[] caloriesSplit = elf.split("\n");
            for (String s : caloriesSplit) {
                caloriesOfElf.add(Integer.parseInt(s));
            }
            resultList.add(new ElfPackage(caloriesOfElf, i));
            i++;
        }
        return resultList;
    }
}
