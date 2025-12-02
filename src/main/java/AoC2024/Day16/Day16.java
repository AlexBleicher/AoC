package AoC2024.Day16;

import java.util.ArrayList;
import java.util.List;

public class Day16 {

    long currentMin = Long.MAX_VALUE;
    boolean[][] visited;
    private char[][] map;

    public Day16(String i) {
        map = new Input(i).parseInput();
        visited = new boolean[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                visited[y][x] = false;
            }
        }
    }

    public long task1() {

        long currentPoints = 0;
        int currentX = 0;
        int currentY = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 'S') {
                    currentX = x;
                    currentY = y;
                }
            }
        }
        String dir = "east";
        moveThroughMaze(currentX, currentY, dir, currentPoints);
        return currentMin;
    }

    private void moveThroughMaze(int cx, int cy, String dir, long currentPoints) {
        List<String> otherDirs = new ArrayList<>();
        int nextX = cx;
        int nextY = cy;
        if (dir.equals("east")) {
            otherDirs.add("north");
            otherDirs.add("south");
            nextX = cx + 1;
        }
        if (dir.equals("west")) {
            otherDirs.add("north");
            otherDirs.add("south");
            nextX = cx - 1;
        }
        if (dir.equals("north")) {
            otherDirs.add("east");
            otherDirs.add("west");
            nextY = cy - 1;
        }
        if (dir.equals("south")) {
            otherDirs.add("east");
            otherDirs.add("west");
            nextY = cy + 1;
        }

        if (map[cy][cx] == '#' || visited[nextX][nextY]) {
            return;
        }
        visited[cy][cx] = true;
        if (map[cy][cx] == 'E') {
            if (currentPoints < currentMin) {
                currentMin = currentPoints;
            }
            return;
        }
        if (currentPoints + 1 < currentMin) {
            moveThroughMaze(nextX, nextY, dir, currentPoints + 1);
        }
        if (currentPoints + 1000 < currentMin) {
            for (String otherDir : otherDirs) {
                moveThroughMaze(cx, cy, otherDir, currentPoints + 1000);
            }
        }
    }
}
