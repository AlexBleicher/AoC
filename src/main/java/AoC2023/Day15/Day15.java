package AoC2023.Day15;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    private List<String> initSequence;

    public Day15(String i) {
        initSequence = new Input(i).parseInput();
    }

    public long task1() {
        long res = 0;
        for (String s : initSequence) {
            res += hashAlgorithm(s);
        }
        return res;
    }

    public long task2() {
        List<List<String>> boxes = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            boxes.add(new ArrayList<>());
        }
        for (String s : initSequence) {
            int indexOperation = 0;
            for (int i = 0; i < s.length() && indexOperation == 0; i++) {
                if (!Character.isAlphabetic(s.charAt(i))) {
                    indexOperation = i;
                }
            }
            String label = s.substring(0, indexOperation);
            long boxIndex = hashAlgorithm(label);
            List<String> box = boxes.get((int) boxIndex);
            if (s.charAt(indexOperation) == '-') {
                String lens = s.replace("-", " ");
                int indexToRemove = -1;
                for (String string : box) {
                    if (string.contains(label)) {
                        indexToRemove = box.indexOf(string);
                    }
                }
                if (indexToRemove != -1) {
                    box.remove(indexToRemove);
                }
            } else if (s.charAt(indexOperation) == '=') {
                String lens = s.replace("=", " ");
                int indexOfLabelInBox = -1;
                for (String string : box) {
                    if (string.contains(label)) {
                        indexOfLabelInBox = box.indexOf(string);
                    }
                }
                if (indexOfLabelInBox != -1) {
                    box.set(indexOfLabelInBox, lens);
                } else {
                    box.add(lens);
                }
            }
        }
        long res = 0;
        int boxI = 1;
        for (List<String> box : boxes) {
            for (int i = 0; i < box.size(); i++) {
                String lens = box.get(i);
                String[] split = lens.split(" ");
                long focal = Long.parseLong(split[1]);
                res += boxI * (i + 1) * focal;
            }
            boxI++;
        }
        return res;
    }

    private long hashAlgorithm(String s) {
        long currentValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c;
            currentValue += ascii;
            currentValue *= 17;
            currentValue = currentValue % 256;
        }
        return currentValue;
    }
}
