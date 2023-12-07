package AoC2023.Day7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HandsComparator implements Comparator<Hand> {

    public Map<String, Integer> valuesOfTypes = new HashMap<>();
    private boolean withJoker = false;

    public HandsComparator() {
        valuesOfTypes.put("Five of a kind", 7);
        valuesOfTypes.put("Four of a kind", 6);
        valuesOfTypes.put("Full house", 5);
        valuesOfTypes.put("Three of a kind", 4);
        valuesOfTypes.put("Two pairs", 3);
        valuesOfTypes.put("One pair", 2);
        valuesOfTypes.put("Highest card", 1);
    }

    public HandsComparator(boolean j) {
        valuesOfTypes.put("Five of a kind", 7);
        valuesOfTypes.put("Four of a kind", 6);
        valuesOfTypes.put("Full house", 5);
        valuesOfTypes.put("Three of a kind", 4);
        valuesOfTypes.put("Two pairs", 3);
        valuesOfTypes.put("One pair", 2);
        valuesOfTypes.put("Highest card", 1);
        withJoker = j;
    }

    public int compare(Hand hand1, Hand hand2) {
        String hand1Type = hand1.getType();
        String hand2Type = hand2.getType();
        if (withJoker) {
            hand1Type = hand1.getTypeWithJokers();
            hand2Type = hand2.getTypeWithJokers();
        }

        if (valuesOfTypes.get(hand1Type) > valuesOfTypes.get(hand2Type)) {
            return 1;
        } else if (valuesOfTypes.get(hand1Type) < valuesOfTypes.get(hand2Type)) {
            return -1;
        } else {
            for (int i = 0; i < hand1.getCards().size(); i++) {
                if (hand1.getCards().get(i).getStrength() > hand2.getCards().get(i).getStrength()) {
                    return 1;
                } else if (hand1.getCards().get(i).getStrength() < hand2.getCards().get(i).getStrength()) {
                    return -1;
                }
            }
            return 0;
        }

    }
}
