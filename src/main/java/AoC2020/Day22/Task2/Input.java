package AoC2020.Day22.Task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Input {

    private String input = "Player 1:\n" +
            "9\n" +
            "2\n" +
            "6\n" +
            "3\n" +
            "1\n" +
            "\n" +
            "Player 2:\n" +
            "5\n" +
            "8\n" +
            "4\n" +
            "7\n" +
            "10";

    private String[] bothDecksString = input.split("\n\n");

    public Deque<Integer> getDeck(int playerIndex) {
        String[] deckStrings = bothDecksString[playerIndex].split("\n");
        Deque<Integer> deck = new ArrayDeque<>();
        for (int i = 1; i < deckStrings.length; i++) {
            deck.add(Integer.parseInt(deckStrings[i]));
        }
        return deck;
    }
}
