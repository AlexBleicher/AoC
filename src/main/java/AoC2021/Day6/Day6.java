package AoC2021.Day6;

public class Day6 {

    private long[] allFish;

    public Day6(String input) {
        this.allFish = new Input(input).splitInput();
    }

    public long task1() {
        passDays(80);
        long result = 0;
        for (int i = 0; i < 7; i++) {
            result += allFish[i];
        }
        return result;
    }

    public long task2() {
        passDays(256);
        long result = 0;
        for (int i = 0; i < 7; i++) {
            result += allFish[i];
        }
        return result;
    }

    public void passDays(int amountOfDays) {
        long delayed2 = 0;
        long delayed1 = 0;
        long mem = 0;
        for (int i = 1; i <= amountOfDays + 1; i++) {
            for (int j = 0; j < 7; j++) {
                if (i % 7 == j) {
                    mem = delayed1;
                    delayed1 = delayed2;
                    delayed2 = allFish[j];
                    allFish[j] += mem;
                    break;
                }
            }
        }
    }
}
