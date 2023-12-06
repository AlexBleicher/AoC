package AoC2023.Day6;

public class Race {
    private long time;
    private long farthest;

    public Race(long t, long f) {
        time = t;
        farthest = f;
    }

    public long determineWaysToWin() {
        long counter = 0;
        boolean hasWon = false;
        for (long speed = 0; speed < time; speed++) {
            long remainingTime = time - speed;
            if (remainingTime * speed > farthest) {
                counter++;
                hasWon = true;
            } else if (hasWon) {
                return counter;
            }
        }
        return counter;
    }
}
