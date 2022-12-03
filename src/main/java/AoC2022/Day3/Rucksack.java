package AoC2022.Day3;

import java.util.ArrayList;
import java.util.List;

public class Rucksack {

    private List<Character> firstCompartement;
    private List<Character> secondCompartement;

    public Rucksack(List<Character> firstCompartement, List<Character> secondCompartement) {
        this.firstCompartement = firstCompartement;
        this.secondCompartement = secondCompartement;
    }

    public int returnPriorityOfItemInBoth() {
        for (Character character : firstCompartement) {
            if (secondCompartement.contains(character)) {
                if (character.compareTo('a') < 0) { //Character is upper Case
                    return (character - 'A' + 1) + 26;
                } else {
                    return character - 'a' + 1;
                }
            }
        }
        return -1;
    }

    public List<Character> allCharactersInRucksack() {
        List<Character> result = new ArrayList<Character>();
        result.addAll(firstCompartement);
        result.addAll(secondCompartement);
        return result;
    }
}
