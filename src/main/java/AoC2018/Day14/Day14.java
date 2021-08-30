package AoC2018.Day14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day14 {

    public List<Integer> recipes = new ArrayList<>();
    public int elveIndex1 = 0;
    public int elveIndex2 = 1;

    public String part1(int input) {
        recipes.add(3);
        recipes.add(7);
        while (recipes.size() < input + 10) {
            generateNewRecipes(recipes.get(elveIndex1), recipes.get(elveIndex2));
            getNewRecipes(recipes.get(elveIndex1), recipes.get(elveIndex2));
        }
        List<Integer> last10Recipes = recipes.subList(input, input + 10);
        return last10Recipes.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

    }

    public int part2(String input) {
        recipes.add(3);
        recipes.add(7);
        boolean scoreSequenceAppeared = false;
        while (!scoreSequenceAppeared) {
            generateNewRecipes(recipes.get(elveIndex1), recipes.get(elveIndex2));
            getNewRecipes(recipes.get(elveIndex1), recipes.get(elveIndex2));
            if (recipes.size() >= input.length()) {
                List<Integer> lastDigits = recipes.subList(recipes.size() - input.length(), recipes.size());
                String lastDigitsAsString = "";
                for (Integer lastDigit : lastDigits) {
                    lastDigitsAsString += lastDigit;
                }
                scoreSequenceAppeared = (input.equals(lastDigitsAsString));
            }
        }
        return recipes.size() - input.length();
    }

    public void generateNewRecipes(int recipeScore1, int recipeScore2) {
        int scoreTotal = recipeScore1 + recipeScore2;
        if (scoreTotal >= 10) {
            recipes.add(1);
            recipes.add(scoreTotal % 10);
        } else {
            recipes.add(scoreTotal);
        }
    }

    public void getNewRecipes(int recipeScore1, int recipeScore2) {
        int steps1 = recipeScore1 + 1;
        int steps2 = recipeScore2 + 1;
        elveIndex1 = (elveIndex1 + steps1) % recipes.size();
        elveIndex2 = (elveIndex2 + steps2) % recipes.size();
    }
}
