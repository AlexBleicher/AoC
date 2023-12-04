package AoC2023.Day4;

import java.util.ArrayList;
import java.util.List;

public class Scratchcard {

    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Integer> numbersYouHave = new ArrayList<>();

    public Scratchcard(String w, String n) {
        String[] split = w.split(" ");
        for (String s : split) {
            if (!s.isEmpty()) {
                winningNumbers.add(Integer.parseInt(s));
            }
        }
        split = n.split(" ");
        for (String s : split) {
            if (!s.isEmpty()) {
                numbersYouHave.add(Integer.parseInt(s));
            }
        }
    }

    public int calculateWorth() {
        int w = 0;
        for (Integer i : numbersYouHave) {
            if (winningNumbers.contains(i)) {
                if (w == 0) {
                    w++;
                } else {
                    w = w * 2;
                }
            }
        }
        return w;
    }

    public int calculateMatches() {
        int m = 0;
        for (Integer i : numbersYouHave) {
            if (winningNumbers.contains(i)) {
                m++;
            }
        }
        return m;
    }

}
