package AoC2021.Day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10 {

    private List<String> allLines;
    private List<String> allIncompleteOrCorruptedLines = new ArrayList<>();
    private List<String> allCorruptedLines = new ArrayList<>();
    private List<String> allIncompleteLines = new ArrayList<>();

    public Day10(String input) {
        allLines = new Input(input).splitLines();
    }

    public long task1() {
        findAllIncompleteOrCorruptedLines();
        return findAllCorruptedLines();
    }

    public void findAllIncompleteOrCorruptedLines() {
        for (String line : allLines) {
            if (!checkIfLineIsCorrect(line)) {
                allIncompleteOrCorruptedLines.add(line);
            }
        }
    }

    public boolean checkIfLineIsCorrect(String line) {
        int amountOfClosingRoundsNedded = 0;
        int amountOfClosingSquaresNeeded = 0;
        int amountOfClosingCurveysNeeded = 0;
        int amountOfClosingPointiesNeeded = 0;
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            switch (currentChar) {
                case ('('):
                    amountOfClosingRoundsNedded++;
                    break;
                case ('['):
                    amountOfClosingSquaresNeeded++;
                    break;
                case ('{'):
                    amountOfClosingCurveysNeeded++;
                    break;
                case ('<'):
                    amountOfClosingPointiesNeeded++;
                    break;
                case (')'):
                    amountOfClosingRoundsNedded--;
                    break;
                case ('}'):
                    amountOfClosingCurveysNeeded--;
                    break;
                case (']'):
                    amountOfClosingSquaresNeeded--;
                    break;
                case ('>'):
                    amountOfClosingPointiesNeeded--;
                    break;
            }
        }
        return (amountOfClosingRoundsNedded == 0 && amountOfClosingCurveysNeeded == 0 && amountOfClosingSquaresNeeded == 0 && amountOfClosingPointiesNeeded == 0);
    }

    public long findAllCorruptedLines() {
        long score = 0;
        for (String incompleteOrCorruptedLine : allIncompleteOrCorruptedLines) {
            int lineScore = checkIfCorrupted(incompleteOrCorruptedLine);
            score += lineScore;
            if (lineScore != 0) {
                allCorruptedLines.add(incompleteOrCorruptedLine);
            }
        }
        return score;
    }

    public int checkIfCorrupted(String line) {
        List<Character> needsClosing = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            switch (currentChar) {
                case ('('):
                    needsClosing.add('(');
                    break;
                case ('{'):
                    needsClosing.add('{');
                    break;
                case ('['):
                    needsClosing.add('[');
                    break;
                case ('<'):
                    needsClosing.add('<');
                    break;
                case (')'):
                    if (needsClosing.get(needsClosing.size() - 1) == '(') {
                        needsClosing.remove(needsClosing.size() - 1);
                    } else {
                        return 3;
                    }
                    break;
                case ('}'):
                    if (needsClosing.get(needsClosing.size() - 1) == '{') {
                        needsClosing.remove(needsClosing.size() - 1);
                    } else {
                        return 1197;
                    }
                    break;
                case (']'):
                    if (needsClosing.get(needsClosing.size() - 1) == '[') {
                        needsClosing.remove(needsClosing.size() - 1);
                    } else {
                        return 57;
                    }
                    break;
                case ('>'):
                    if (needsClosing.get(needsClosing.size() - 1) == '<') {
                        needsClosing.remove(needsClosing.size() - 1);
                    } else {
                        return 25137;
                    }
                    break;
            }
        }
        return 0;
    }

    public long task2() {
        findAllIncompleteOrCorruptedLines();
        findAllCorruptedLines();
        List<Long> scoresList = getScoresList();
        Collections.sort(scoresList);
        return scoresList.get(scoresList.size() / 2);
    }

    public List<Long> getScoresList() {
        allIncompleteLines.addAll(allIncompleteOrCorruptedLines);
        allIncompleteLines.removeAll(allCorruptedLines);
        List<Long> scoresList = new ArrayList<>();
        for (String incompleteLine : allIncompleteLines) {
            scoresList.add(calculateScore(incompleteLine));
        }
        return scoresList;
    }

    public long calculateScore(String line) {
        List<Character> needsClosing = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            switch (currentChar) {
                case ('('):
                    needsClosing.add('(');
                    break;
                case ('{'):
                    needsClosing.add('{');
                    break;
                case ('['):
                    needsClosing.add('[');
                    break;
                case ('<'):
                    needsClosing.add('<');
                    break;
                case (')'):
                case ('>'):
                case ('}'):
                case (']'):
                    needsClosing.remove(needsClosing.size() - 1);
                    break;
            }
        }
        long score = 0;
        for (int i = needsClosing.size() - 1; i >= 0; i--) {
            score = score * 5;
            if (needsClosing.get(i) == '(') {
                score++;
            } else if (needsClosing.get(i) == '[') {
                score += 2;
            } else if (needsClosing.get(i) == '{') {
                score += 3;
            } else if (needsClosing.get(i) == '<') {
                score += 4;
            }
        }
        return score;
    }
}
