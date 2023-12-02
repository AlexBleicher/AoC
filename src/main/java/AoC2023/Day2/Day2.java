package AoC2023.Day2;

import java.util.List;

public class Day2 {

    private List<Game> games;

    public Day2(String input) {
        games = new Input(input).parseInput();
    }

    public int task1() {
        int res = 0;
        int limitBlue = 14;
        int limitRed = 12;
        int limitGreen = 13;
        int index = 1;
        for (Game game : games) {
            if (game.isPossible(limitRed, limitGreen, limitBlue)) {
                res += index;
            }
            index++;
        }
        return res;
    }

    public long task2() {

        return games.stream().map(Game::getPower)
                .reduce(0, Integer::sum);

    }
}
