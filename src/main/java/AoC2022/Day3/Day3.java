package AoC2022.Day3;

import java.util.List;

public class Day3 {

    private List<Rucksack> rucksacks;

    public Day3(String input) {
        rucksacks = new Input(input).parseInput();
    }

    public int solveTask1() {
        return rucksacks.stream()
                .mapToInt(Rucksack::returnPriorityOfItemInBoth).sum();

    }


    public int solveTask2() {
        int result = 0;
        for (int i = 0; i < rucksacks.size(); i += 3) {
            result += getPriorityOfBadge(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2));
        }
        return result;
    }

    public int getPriorityOfBadge(Rucksack r1, Rucksack r2, Rucksack r3) {
        List<Character> allCharsInR1 = r1.allCharactersInRucksack();
        for (Character character : allCharsInR1) {
            if (r2.allCharactersInRucksack().contains(character) && r3.allCharactersInRucksack().contains(character)) {
                if (character.compareTo('a') < 0) { //Character is upper Case
                    return (character - 'A' + 1) + 26;
                } else {
                    return character - 'a' + 1;
                }
            }
        }
        return -1;
    }
}
