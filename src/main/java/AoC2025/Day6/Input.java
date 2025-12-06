package AoC2025.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public List<Problem> parseInput() {
        String[] lines = input.split("\n");
        List<Problem> res = new ArrayList<>();
        String longestLine = Arrays.stream(lines).sorted().toList().get(lines.length - 1);
        List<String> substrings = new ArrayList<>();
        for (int i1 = 0; i1 < lines.length - 1; i1++) {
            substrings.add("");
        }
        int index = 0;
        for (int i = 0; i < longestLine.length(); i++) {
            boolean columnBreak = true;
            for (int j = 0; j < lines.length - 1; j++) {
                String line = lines[j];
                if (i < line.length()) {
                    char c = line.charAt(i);
                    String s = substrings.get(j);
                    s += c;
                    if (c != ' ') {
                        substrings.set(j, s);
                        columnBreak = false;
                    }
                }
            }
            if (columnBreak || i == longestLine.length() - 1) {
                res.add(new Problem());
                for (int i1 = 0; i1 < substrings.size(); i1++) {
                    res.get(index).addNumber(Long.parseLong(substrings.get(i1).strip()));
                    substrings.set(i1, "");
                }
                index++;
            }
        }
        index = 0;
        for (int i = 0; i < longestLine.length(); i++) {
            String line = lines[lines.length - 1];
            if (line.charAt(i) != ' ') {
                res.get(index++).setOperator(line.charAt(i));
            }
        }
        return res;
    }

    public List<Problem> parseInputTask2() {
        String[] lines = input.split("\n");
        List<Problem> res = new ArrayList<>();
        String longestLine = Arrays.stream(lines).sorted().toList().get(lines.length - 1);
        List<String> substrings = new ArrayList<>();
        int index = 0;
        for (int i = longestLine.length() - 1; i >= 0; i--) {
            boolean columnBreak = true;
            String substring = "";
            for (int i1 = 0; i1 < lines.length - 1; i1++) {
                String line = lines[i1];
                if (i < line.length()) {
                    char c = line.charAt(i);
                    if (c != ' ') {
                        substring += c;
                        columnBreak = false;
                    }
                }
            }
            if (!substring.equals("")) {
                substrings.add(substring);
            }
            if (columnBreak || i == 0) {
                res.add(new Problem());
                for (int i1 = 0; i1 < substrings.size(); i1++) {
                    res.get(index).addNumber(Long.parseLong(substrings.get(i1).strip()));
                }
                substrings = new ArrayList<>();
                index++;
            }
        }
        index = 0;
        for (int i = longestLine.length() - 1; i >= 0; i--) {
            String line = lines[lines.length - 1];
            if (line.charAt(i) != ' ') {
                res.get(index++).setOperator(line.charAt(i));
            }
        }
        return res;
    }
}
