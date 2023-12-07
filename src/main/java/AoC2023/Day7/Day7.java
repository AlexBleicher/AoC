package AoC2023.Day7;

import java.util.List;
import java.util.stream.Collectors;

public class Day7 {

    public List<Hand> hands;

    public Day7(String i) {
        hands = new Input(i).parseInput();
    }

    public long task1() {
        hands = hands.stream().sorted(new HandsComparator()).collect(Collectors.toList());
        long res = 0;
        for (int i = 0; i < hands.size(); i++) {
            res += hands.get(i).getBid() * (i + 1);
        }
        return res;
    }

    public long task2() {
        for (Hand hand : hands) {
            for (Card card : hand.getCards()) {
                if (card.getLabel() == 'J') {
                    card.setStrength(1);
                }
            }
        }
        hands = hands.stream().sorted(new HandsComparator(true)).collect(Collectors.toList());
        long res = 0;
        for (int i = 0; i < hands.size(); i++) {
            res += hands.get(i).getBid() * (i + 1);
        }
        return res;
    }
}
