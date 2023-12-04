package AoC2023.Day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {

    private List<Scratchcard> cards;
    private Map<Scratchcard, Integer> map = new HashMap<>();

    public Day4(String i) {
        cards = new Input(i).parseInput();
        for (Scratchcard card : cards) {
            map.put(card, 1);
        }
    }

    public int day1() {
        return cards.stream().mapToInt(Scratchcard::calculateWorth).sum();
    }

    public int day2() {
        int res = 0;
        for (int j = 0; j < cards.size(); j++) {
            Scratchcard card = cards.get(j);
            int repeats = map.get(card);
            for (int i = 0; i < repeats; i++) {
                int worth = card.calculateMatches();
                for (int x = 1; x <= worth; x++) {
                    if (j + x < cards.size()) {
                        int value = map.get(cards.get(j + x));
                        map.put(cards.get(j + x), value + 1);
                    }
                }
            }
            res += map.get(card);
        }
        return res;
    }
}
