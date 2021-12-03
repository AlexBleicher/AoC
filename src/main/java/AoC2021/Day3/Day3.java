package AoC2021.Day3;

import java.util.ArrayList;

public class Day3 {

    private ArrayList<String> inputList;
    private int gammaRate;
    private int epsilonRate;
    private int oxygenRating;
    private int co2Scrubber;

    public Day3(String input) {
        this.inputList = new Input(input).splitInput();
    }

    public int task1() {
        fillRates();
        return gammaRate * epsilonRate;
    }

    public void fillRates() {
        String gammaAsString = "";
        String epsilonAsString = "";
        ArrayList<String> mostCommonValues = findMostCommonValues(inputList);
        for (String mostCommonValue : mostCommonValues) {
            gammaAsString += mostCommonValue;
            if (mostCommonValue.equals("0")) {
                epsilonAsString += "1";
            } else {
                epsilonAsString += "0";
            }
        }
        gammaRate = Integer.parseInt(gammaAsString, 2);
        epsilonRate = Integer.parseInt(epsilonAsString, 2);
    }

    public ArrayList<String> findMostCommonValues(ArrayList<String> listToConsider) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < listToConsider.get(0).length(); i++) {
            int count0 = 0;
            int count1 = 0;
            for (String s : listToConsider) {
                if (s.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            if (count0 > count1) {
                result.add("0");
            } else {
                result.add("1");
            }
        }
        return result;
    }

    public int task2() {
        findValuesOfScrubberAndRating();
        return oxygenRating * co2Scrubber;
    }

    public void findValuesOfScrubberAndRating() {
        co2Scrubber = Integer.parseInt(findScrubber(), 2);
        oxygenRating = Integer.parseInt(findRating(), 2);
    }

    public String findRating() {
        ArrayList<String> possibleRatings = new ArrayList<>(inputList);
        int index = 0;
        while (possibleRatings.size() > 1) {
            String mostCommonValue = findMostCommonValues(possibleRatings).get(index);
            ArrayList<String> toRemove = new ArrayList<>();
            for (String possibleRating : possibleRatings) {
                if (possibleRating.charAt(index) != mostCommonValue.charAt(0)) {
                    toRemove.add(possibleRating);
                }
            }
            possibleRatings.removeAll(toRemove);
            index++;
        }
        return possibleRatings.get(0);
    }

    public String findScrubber() {
        ArrayList<String> possibleScrubs = new ArrayList<>(inputList);
        int index = 0;
        while (possibleScrubs.size() > 1) {
            String mostCommonValue = findMostCommonValues(possibleScrubs).get(index);
            ArrayList<String> toRemove = new ArrayList<>();
            for (String possibleScrub : possibleScrubs) {
                if (possibleScrub.charAt(index) == mostCommonValue.charAt(0)) {
                    toRemove.add(possibleScrub);
                }
            }
            possibleScrubs.removeAll(toRemove);
            index++;
        }
        return possibleScrubs.get(0);
    }

}
