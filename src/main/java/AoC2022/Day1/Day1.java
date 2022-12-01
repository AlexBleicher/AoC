package AoC2022.Day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    List<ElfPackage> elfPackages = new ArrayList<>();

    public Day1(String input) {
        elfPackages = new Input(input).parseInput();
    }

    public int solveTask1() {
        ElfPackage elfWithMostCalories = elfPackages.stream().max(Comparator.comparingInt(ElfPackage::getAmountOfCalories)).get();
        return elfWithMostCalories.getAmountOfCalories();
    }

    public long solveTask2() {
        long totalCalories = 0;
        for (int i = 0; i < 3; i++) {
            int mostCalories = solveTask1();
            elfPackages.remove(elfPackages.stream().max(Comparator.comparingInt(ElfPackage::getAmountOfCalories)).get());
            totalCalories += mostCalories;
        }
        return totalCalories;
    }
}
