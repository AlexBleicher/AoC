package AoC2020.Day22.Task1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Input {

    private String input = "Player 1:\n" +
            "45\n" +
            "10\n" +
            "43\n" +
            "46\n" +
            "25\n" +
            "36\n" +
            "16\n" +
            "38\n" +
            "30\n" +
            "15\n" +
            "26\n" +
            "34\n" +
            "9\n" +
            "2\n" +
            "44\n" +
            "1\n" +
            "4\n" +
            "40\n" +
            "5\n" +
            "24\n" +
            "49\n" +
            "3\n" +
            "41\n" +
            "19\n" +
            "13\n" +
            "\n" +
            "Player 2:\n" +
            "28\n" +
            "50\n" +
            "37\n" +
            "20\n" +
            "6\n" +
            "42\n" +
            "32\n" +
            "47\n" +
            "39\n" +
            "22\n" +
            "14\n" +
            "7\n" +
            "21\n" +
            "17\n" +
            "27\n" +
            "8\n" +
            "48\n" +
            "11\n" +
            "23\n" +
            "12\n" +
            "18\n" +
            "35\n" +
            "29\n" +
            "33\n" +
            "31";

    private String[] bothDecksString = input.split("\n\n");

    public Deque<Integer> getDeck(int player) {
        String[] deckStrings = bothDecksString[player].split("\n");
        Deque<Integer> deck = new ArrayDeque<>();
        for (int i = 1; i < deckStrings.length; i++) {
            deck.add(Integer.parseInt(deckStrings[i]));
        }
        return deck;
    }
}
