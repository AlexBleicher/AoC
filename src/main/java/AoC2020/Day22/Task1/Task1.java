package AoC2020.Day22.Task1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task1 {

    public static Input input = new Input();
    public static Deque<Integer> deckPlayer1 = new ArrayDeque<>();
    public static Deque<Integer> deckPlayer2 = new ArrayDeque<>();

    public static void main(String[] args) {
        deckPlayer1 = input.getDeck(0);
        deckPlayer2 = input.getDeck(1);
        playRound();
        System.out.println(calculateScore(deckPlayer2));
    }

    public static void playRound() {
        while (deckPlayer1.size() != 0 && deckPlayer2.size() != 0) {
            playTurn();
        }
    }

    public static void playTurn() {
        int card1 = deckPlayer1.poll();
        int card2 = deckPlayer2.poll();
        if (card1 > card2) {
            deckPlayer1.add(card1);
            deckPlayer1.add(card2);
        } else {
            deckPlayer2.add(card2);
            deckPlayer2.add(card1);
        }
    }

    public static long calculateScore(Deque<Integer> deck) {
        long score = 0;

        for (int multiplier = deck.size(); multiplier >= 1; multiplier--) {
            score += (long) deck.poll() * multiplier;
        }

        return score;
    }
}
