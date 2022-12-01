package AoC2022.Day1;

import java.util.List;

public class ElfPackage {

    List<Integer> calories;
    int number;

    public ElfPackage(List<Integer> calories, int number) {
        this.calories = calories;
        this.number = number;
    }

    public int getAmountOfCalories() {
        return calories.stream().mapToInt(Integer::intValue).sum();
    }
}
