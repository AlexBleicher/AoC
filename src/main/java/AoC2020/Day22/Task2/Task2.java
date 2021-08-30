package AoC2020.Day22.Task2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Task2 {

    private static Input input = new Input();
    private static Deque<Integer> playerDeck1 = input.getDeck(0);
    private static Deque<Integer> playerDeck2 = input.getDeck(1);

    public static void main(String[] args) {
        Deque<Integer> winner = calculateWinner(playerDeck1, playerDeck2, playerDeck1.size(), playerDeck2.size(), false);
        System.out.println(winner);
        System.out.println(calculateScore(winner));
    }

    public static Deque<Integer> calculateWinner(Deque<Integer> d1, Deque<Integer> d2, int size1, int size2, boolean isSubRound) {

        final Deque<Integer> deck1 = new ArrayDeque<>(d1);
        while (deck1.size() > size1) {
            deck1.removeLast();
        }

        final Deque<Integer> deck2 = new ArrayDeque<>(d2);
        while (deck2.size() > size2) {
            deck2.removeLast();
        }

        final Set<String> previousDecks = new HashSet<>();
        while (deck1.size() != 0 && deck2.size() != 0) {
            String bothDecks = deck1.toString() + "|" + deck2.toString();
            if (previousDecks.contains(bothDecks)) {
                return d1;
            } else {
                previousDecks.add(bothDecks);
                int card1 = deck1.removeFirst();
                int card2 = deck2.removeFirst();
                if (deck1.size() >= card1 && deck2.size() >= card2) {
                    Deque<Integer> winner = calculateWinner(deck1, deck2, card1, card2, true);
                    if (winner.equals(deck1)) {
                        deck1.add(card1);
                        deck1.add(card2);
                    } else {
                        deck2.add(card2);
                        deck2.add(card1);
                    }
                } else {
                    if (card1 > card2) {
                        deck1.add(card1);
                        deck1.add(card2);
                    } else {
                        deck2.add(card2);
                        deck2.add(card1);
                    }
                }
            }
        }
        if (!isSubRound) {
            return deck2.isEmpty() ? deck1 : deck2;
        }
        return deck2.isEmpty() ? d1 : d2;

    }

    public static long calculateScore(Deque<Integer> deck) {
        long score = 0;
        try {
            for (int multiplier = deck.size(); multiplier >= 1; multiplier--) {
                score += (long) deck.poll() * multiplier;
            }

            return score;
        } catch (NullPointerException e) {
            throw new RuntimeException("Deck war leer!");
        }
    }

}