package AoC2021.Day4;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    private HashMap<Integer, Boolean> numbersOnBoard = new HashMap<>();
    private int[][] boardStructure = new int[5][5];

    public Board(ArrayList<Integer> numbers) {
        int index = 0;
        for (Integer number : numbers) {
            numbersOnBoard.put(number, false);
            boardStructure[index / 5][index % 5] = number;
            index++;
        }
    }

    public void callNumber(int number) {
        if (numbersOnBoard.containsKey(number)) {
            numbersOnBoard.replace(number, false, true);
        }
    }

    public boolean checkIfWon() {
        for (int x = 0; x < 5; x++) {
            boolean wonVertical = true;
            boolean wonHorizontal = true;
            for (int y = 0; y < 5; y++) {
                if (!numbersOnBoard.get(boardStructure[x][y])) {
                    wonVertical = false;
                }
                if (!numbersOnBoard.get(boardStructure[y][x])) {
                    wonHorizontal = false;
                }
            }
            if (wonVertical || wonHorizontal) {
                return true;
            }
        }
        return false;
    }

    public int calculateScore() {
        int score = 0;
        for (Integer integer : numbersOnBoard.keySet()) {
            if (!numbersOnBoard.get(integer)) {
                score += integer;
            }
        }
        return score;
    }
}
