package AoC2024.Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    private Letter[][] letters;

    public Day4(String i) {
        letters = new Input(i).parseInput();
    }

    public long task1() {
        List<String> allLinesForward = new ArrayList<>();
        List<String> allLinesBackward = new ArrayList<>();
        List<String> allLinesUpward = new ArrayList<>();
        List<String> allLinesDownward = new ArrayList<>();
        List<String> allLinesLeftToRightVertical = new ArrayList<>();
        List<String> allLinesRightToLeftVertical = new ArrayList<>();
        List<String> allLinesLeftToRightVerticalReversed = new ArrayList<>();
        List<String> allLinesRightToLeftVerticalReversed = new ArrayList<>();

        for (int y = 0; y < letters.length; y++) {
            String line = "";
            for (Letter letter : letters[y]) {
                line += letter.getLetter();
            }
            allLinesForward.add(line);
            allLinesBackward.add(new StringBuilder(line).reverse().toString());
        }
        for (int x = 0; x < letters[0].length; x++) {
            String line = "";
            for (int y = 0; y < letters.length; y++) {
                line += letters[y][x].getLetter();
            }
            allLinesDownward.add(line);
            allLinesUpward.add(new StringBuilder(line).reverse().toString());
        }
        for (int x = 0; x < letters[0].length; x++) {
            int countup = 0;
            String line = "";
            for (int y = 0; y < letters.length; y++) {
                if (x + countup < letters[0].length) {
                    line += letters[y][x + countup++].getLetter();
                }
            }
            allLinesLeftToRightVertical.add(line);
            allLinesLeftToRightVerticalReversed.add(new StringBuilder(line).reverse().toString());
        }
        for (int x = letters[0].length - 1; x > 0; x--) {
            String line = "";
            int countup = 0;
            for (int y = 0; y < letters.length; y++) {
                if (x - countup >= 0) {
                    line += letters[y][x - countup++].getLetter();
                }
            }
            allLinesRightToLeftVertical.add(line);
            allLinesRightToLeftVerticalReversed.add(new StringBuilder(line).reverse().toString());
        }
        for (int x = letters[0].length - 2; x > 0; x--) {
            String line = "";
            int countup = 0;
            for (int y = letters.length - 1; y >= 0; y--) {
                if (x - countup >= 0) {
                    line += letters[y][x - countup++].getLetter();
                }
            }
            allLinesRightToLeftVertical.add(line);
            allLinesRightToLeftVerticalReversed.add(new StringBuilder(line).reverse().toString());
        }
        for (int x = 1; x < letters[0].length; x++) {
            int countup = 0;
            String line = "";
            for (int y = letters.length - 1; y >= 0; y--) {
                if (x + countup < letters[0].length) {
                    line += letters[y][x + countup++].getLetter();
                }
            }
            allLinesLeftToRightVertical.add(line);
            allLinesLeftToRightVerticalReversed.add(new StringBuilder(line).reverse().toString());
        }
        Pattern pattern = Pattern.compile("XMAS");
        long counts = 0;
        for (String s : allLinesForward) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesBackward) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesDownward) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesUpward) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesLeftToRightVertical) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesLeftToRightVerticalReversed) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesRightToLeftVertical) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        for (String s : allLinesRightToLeftVerticalReversed) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counts++;
            }
        }
        return counts;
    }

    long task2() {
        long counts = 0;
        for (int y = 0; y < letters.length; y++) {
            for (int x = 0; x < letters[0].length; x++) {
                Letter letter = letters[x][y];
                if (letter.getLetter() == 'A') {
                    if (y + 1 < letters.length && x + 1 < letters[0].length && y - 1 >= 0 && x - 1 >= 0) {
                        String horizontal1 = "";
                        String horizontal2 = "";
                        horizontal1 += letters[x - 1][y - 1].getLetter();
                        horizontal1 += letters[x][y].getLetter();
                        horizontal1 += letters[x + 1][y + 1].getLetter();
                        if (checkHorizontal(horizontal1)) {
                            horizontal2 += letters[x - 1][y + 1].getLetter();
                            horizontal2 += letters[x][y].getLetter();
                            horizontal2 += letters[x + 1][y - 1].getLetter();
                            if (checkHorizontal(horizontal2)) {
                                counts++;
                            }
                        }
                    }
                }
            }
        }
        return counts;
    }

    boolean checkHorizontal(String toCheck) {
        Pattern pattern = Pattern.compile("MAS");
        Matcher matcher = pattern.matcher(toCheck);
        if (matcher.find()) {
            return true;
        } else {
            return pattern.matcher(new StringBuilder(toCheck).reverse().toString()).find();
        }
    }
}
