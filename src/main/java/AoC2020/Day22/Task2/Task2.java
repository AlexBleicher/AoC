package AoC2020.Day22.Task2;

import java.util.*;

public class Task2 {

    private static Input input = new Input();
    private static Set<List<Deque<Integer>>> previousDecks = new HashSet<>();

    public static void main(String[] args) {
        Deque<Integer> deckPlayer1 = input.getDeck(0);
        Deque<Integer> deckPlayer2 = input.getDeck(1);
        Deque<Integer> winner = getWinner(deckPlayer1, deckPlayer2, deckPlayer1.size(), deckPlayer2.size());
        System.out.println(calculateScore(winner));
    }

    public static Deque<Integer> getWinner(Deque<Integer> deckPlayer1, Deque<Integer> deckPlayer2, int size1, int size2) {
        Deque<Integer> deck1 = deckPlayer1;
        Deque<Integer> deck2 = deckPlayer2;
        deck1 = trimDeck(deck1, size1);
        deck2 = trimDeck(deck2, size2);
        List<Deque<Integer>> bothDecks = new ArrayList();
        bothDecks.add(deck1);
        bothDecks.add(deck1);
        if (previousDecks.contains(bothDecks)) {
            return deck1;
        } else {
            previousDecks.add(bothDecks);
            while (!deck1.isEmpty() && !deck2.isEmpty()) {
                int card1 = deck1.poll();
                int card2 = deck2.poll();
                if (deck1.size() >= card1 && deck2.size() >= card2) {
                    Deque<Integer> winner = getWinner(deck1, deck2, card1, card2);
                    if (winner == deck1) {
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
            return deck2.isEmpty() ? deck1 : deck2;
        }
    }

    public static Deque<Integer> trimDeck(Deque<Integer> deck, int size) {
        while (deck.size() > size) {
            deck.removeLast();
        }
        return deck;
    }

    public static long calculateScore(Deque<Integer> deck) {
        long score = 0;

        for (int multiplier = deck.size(); multiplier >= 1; multiplier--) {
            System.out.println(score);
            score += (long) deck.poll() * multiplier;
        }

        return score;
    }

}