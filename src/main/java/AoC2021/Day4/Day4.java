package AoC2021.Day4;

import java.util.ArrayList;

public class Day4 {

    public ArrayList<Integer> numbers;
    public ArrayList<Board> boards;
    public int score = 0;

    public Day4(String input) {
        this.numbers = new Input(input).getNumbers();
        this.boards = new Input(input).getBoards();
    }

    public int task1() {
        Board winner = playRound();
        return score * winner.calculateScore();
    }

    public Board playRound() {
        int index = 0;
        while (true) {
            int number = numbers.get(index);
            for (Board board : boards) {
                board.callNumber(number);
                if (board.checkIfWon()) {
                    score = number;
                    return board;
                }
            }
            index++;
        }
    }

    public int task2() {
        Board lastWinner = playRoundWithIntentiontoLose();
        return score * lastWinner.calculateScore();
    }

    public Board playRoundWithIntentiontoLose() {
        int index = 0;
        while (true) {
            int number = numbers.get(index);
            ArrayList<Board> allBoardsWinningThisRound = new ArrayList<>();
            score = number;
            for (Board board : boards) {
                board.callNumber(number);
                if (board.checkIfWon()) {
                    if (boards.size() > 1) {
                        allBoardsWinningThisRound.add(board);
                    } else {
                        score = number;
                        return boards.get(0);
                    }
                }
            }
            boards.removeAll(allBoardsWinningThisRound);
            index++;
        }
    }
}
