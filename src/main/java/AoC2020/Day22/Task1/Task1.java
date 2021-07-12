package AoC2020.Day22.Task1;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static Input input = new Input();
    public static List<Integer> deckPlayer1 = new ArrayList<>();
    public static List<Integer> deckPlayer2 = new ArrayList<>();

    public static void main(String[] args) {
        deckPlayer1 = input.getDeck(0);
        deckPlayer2 = input.getDeck(1);

    }

    public static void playRound() {
        while (deckPlayer1.size() != 0 && deckPlayer2.size() != 0) {
            playTurn();
        }
    }

    public static void playTurn() {
        int card1 = deckPlayer1.get(0);
        deckPlayer1.remove(card1);
        int card2 = deckPlayer2.get(0);
        deckPlayer2.remove(card2);
        if (card1 > card2) {
            deckPlayer1.add(card1);
            deckPlayer1.add(card2);
        } else {
            deckPlayer2.add(card2);
            deckPlayer2.add(card2);
        }
    }
}
