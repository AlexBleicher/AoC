package AoC2023.Day7;

import java.util.*;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private long bid;

    public Hand(String cardString, long bid) {
        for (int i = 0; i < cardString.length(); i++) {
            cards.add(new Card(cardString.charAt(i)));
        }
        this.bid = bid;
    }

    public String getType() {
        Map<Character, Integer> cardLabeltoAppearance = new HashMap<>();
        Set<Character> labels = new HashSet<>();
        for (Card card : cards) {
            char label = card.getLabel();
            labels.add(label);
            if (cardLabeltoAppearance.containsKey(label)) {
                cardLabeltoAppearance.put(label, cardLabeltoAppearance.get(label) + 1);
            } else {
                cardLabeltoAppearance.put(label, 1);
            }
        }
        int countPairs = 0;
        boolean hasThree = false;
        for (Character label : labels) {

            if (cardLabeltoAppearance.get(label) == 5) {
                return "Five of a kind";
            }
            if (cardLabeltoAppearance.get(label) == 4) {
                return "Four of a kind";
            }
            if (cardLabeltoAppearance.get(label) == 3) {
                hasThree = true;
            }
            if (cardLabeltoAppearance.get(label) == 2) {
                countPairs++;
            }
        }
        if (countPairs > 0 && hasThree) {
            return "Full house";
        }
        if (hasThree) {
            return "Three of a kind";
        }
        if (countPairs == 2) {
            return "Two pairs";
        }
        if (countPairs == 1) {
            return "One pair";
        }
        return "Highest card";
    }

    public String getTypeWithJokers() {
        int countJokers = 0;
        Map<Character, Integer> labelToAmount = new HashMap<>();
        for (Card card : cards) {
            if (card.getLabel() == 'J') {
                countJokers++;
            }
            if (labelToAmount.containsKey(card.getLabel())) {
                labelToAmount.put(card.getLabel(), labelToAmount.get(card.getLabel()) + 1);
            } else {
                labelToAmount.put(card.getLabel(), 1);
            }
        }
        int countPairs = 0;
        boolean hasThree = false;
        boolean hasFour = false;
        boolean hasFive = false;
        for (Character c : labelToAmount.keySet()) {
            if (c != 'J') {
                if (labelToAmount.get(c) == 2) {
                    countPairs++;
                }
                if (labelToAmount.get(c) == 3) {
                    hasThree = true;
                }
                if (labelToAmount.get(c) == 4) {
                    hasFour = true;
                }
                if (labelToAmount.get(c) == 5) {
                    hasFive = true;
                }
            }
        }
        if (countJokers == 4 || countJokers == 5 || hasFive || hasFour && countJokers == 1 || hasThree && countJokers == 2 || countJokers == 3 && countPairs == 1) {
            return "Five of a kind";
        }
        if (hasFour || hasThree && countJokers == 1 || countPairs == 1 && countJokers == 2 || countJokers == 3) {
            return "Four of a kind";
        }
        if (hasThree && countPairs == 1 || countPairs == 2 && countJokers == 1) {
            return "Full house";
        }
        if (hasThree || countPairs == 1 && countJokers == 1 || countJokers == 2) {
            return "Three of a kind";
        }
        if (countPairs == 2 && countJokers == 0) {
            return "Two pairs";
        }
        if (countPairs == 1 || countJokers == 1) {
            return "One pair";
        }
        return "Highest card";
    }

    public List<Card> getCards() {
        return cards;
    }

    public long getBid() {
        return bid;
    }
}
