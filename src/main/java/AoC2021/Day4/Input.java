package AoC2021.Day4;

import java.util.ArrayList;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public ArrayList<Integer> getNumbers() {
        String[] inputSplit = input.split("\n\n");
        String[] numbersSplit = inputSplit[0].split(",");
        ArrayList<Integer> result = new ArrayList<>();
        for (String s : numbersSplit) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    public ArrayList<Board> getBoards() {
        String[] inputSplit = input.split("\n\n");
        ArrayList<Board> result = new ArrayList<>();
        for (int i = 1; i < inputSplit.length; i++) {
            String boardAsString = inputSplit[i];
            String[] lines = boardAsString.split("\n");
            ArrayList<Integer> numbersOnBoard = new ArrayList<>();
            for (String line : lines) {
                String[] s = line.split(" ");
                for (String s1 : s) {
                    if (!s1.equals("")) {
                        numbersOnBoard.add(Integer.parseInt(s1));
                    }
                }
            }
            result.add(new Board(numbersOnBoard));
        }
        return result;
    }
}
