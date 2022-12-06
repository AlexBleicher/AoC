package AoC2022.Day6;

import java.util.List;

public class Day6 {

    private List<Character> dataStream;

    public Day6(String input) {
        dataStream = new Input(input).parseInput();
    }

    public int task1() {
        return calculateStartOfPackage();
    }

    public int calculateStartOfPackage() {
        int buffer = 3;
        for (int i = 3; i < dataStream.size(); i++) {
            String lastFourChars = "";
            boolean isContained = false;
            for (int j = 3; j >= 0 && !isContained; j--) {
                Character character = dataStream.get(i - j);
                if (lastFourChars.contains("" + character)) {
                    isContained = true;

                }
                lastFourChars += character;
            }
            buffer++;
            if (!isContained) {
                return buffer;
            }
        }
        return -1;
    }

    public int task2() {
        return calculateStartOfMessage();
    }

    private int calculateStartOfMessage() {
        int buffer = 13;
        for (int i = 13; i < dataStream.size(); i++) {
            String lastFourteenChars = "";
            boolean isContained = false;
            for (int j = 13; j >= 0 && !isContained; j--) {
                Character character = dataStream.get(i - j);
                if (lastFourteenChars.contains("" + character)) {
                    isContained = true;

                }
                lastFourteenChars += character;
            }
            buffer++;
            if (!isContained) {
                return buffer;
            }
        }
        return -1;
    }
}
