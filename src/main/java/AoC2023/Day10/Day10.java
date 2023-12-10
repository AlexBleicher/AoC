package AoC2023.Day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day10 {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_CYAN = "\u001B[36m";
    Pipe[][] pipeMap;

    public Day10(String i) {
        pipeMap = new Input(i).parseInput();
    }

    public long task1() {
        Pipe start = new Pipe('0');
        for (Pipe[] pipes : pipeMap) {
            for (int x = 0; x < pipeMap.length; x++) {
                if (pipes[x].getForm() == 'S') {
                    start = pipes[x];
                }
            }
        }
        Pipe current1 = null;
        Pipe current2 = null;
        List<Pipe> neighbors = new ArrayList<>();
        neighbors.add(start.getNorth());
        neighbors.add(start.getSouth());
        neighbors.add(start.getEast());
        neighbors.add(start.getWest());
        for (Pipe neighbor : neighbors) {
            if (neighbor != null && neighbor.getForm() != '.') {
                List<Pipe> nneighbors = new ArrayList<>();
                nneighbors.add(neighbor.getNorth());
                nneighbors.add(neighbor.getSouth());
                nneighbors.add(neighbor.getEast());
                nneighbors.add(neighbor.getWest());
                for (Pipe nneighbor : nneighbors) {
                    if (nneighbor != null) {
                        if (neighbor.travelForm(nneighbor) == start) {
                            if (current1 == null) {
                                current1 = neighbor;
                            } else {
                                current2 = neighbor;
                            }
                        }
                    }
                }
            }
        }
        long steps = 1;
        Pipe lastPipe1 = start;
        Pipe lastPipe2 = start;
        while (current1 != current2) {
            steps++;
            Pipe c = current1;
            current1 = current1.travelForm(lastPipe1);
            lastPipe1 = c;
            if (current1 == lastPipe2) {
                return steps;
            }
            c = current2;
            current2 = current2.travelForm(lastPipe2);
            lastPipe2 = c;
        }
        return steps;
    }

    public long task2() {
        Pipe start = new Pipe('0');
        for (Pipe[] pipes : pipeMap) {
            for (int x = 0; x < pipeMap[0].length; x++) {
                if (pipes[x].getForm() == 'S') {
                    start = pipes[x];
                }
            }
        }

        start.setOnLoop(true);
        Pipe current1 = null;
        List<Pipe> neighbors = new ArrayList<>();
        neighbors.add(start.getNorth());
        neighbors.add(start.getSouth());
        neighbors.add(start.getEast());
        neighbors.add(start.getWest());
        for (Pipe neighbor : neighbors) {
            if (neighbor != null && neighbor.getForm() != '.') {
                List<Pipe> nneighbors = new ArrayList<>();
                nneighbors.add(neighbor.getNorth());
                nneighbors.add(neighbor.getSouth());
                nneighbors.add(neighbor.getEast());
                nneighbors.add(neighbor.getWest());
                for (Pipe nneighbor : nneighbors) {
                    if (nneighbor != null) {
                        if (neighbor.travelForm(nneighbor) == start) {
                            if (current1 == null) {
                                current1 = neighbor;
                            }
                        }
                    }
                }
            }
        }
        List<Pipe> loop = new ArrayList<>();
        loop.add(start);
        Pipe lastPipe1 = start;
        while (current1 != null && current1.travelForm(lastPipe1) != start) {
            current1.setOnLoop(true);
            Pipe c = current1;
            loop.add(current1);
            current1 = current1.travelForm(lastPipe1);
            lastPipe1 = c;
        }
        Set<Pipe> outside = new HashSet<>();
        Set<Pipe> inside = new HashSet<>();
        String currentDirectionOutside = "l";
        int indexStart = -1;
        Pipe startPipe = null;
        int xStart = 0;
        while (startPipe == null) {
            boolean isSet = false;
            for (int y = 0; y < pipeMap.length; y++) {
                Pipe pipe = pipeMap[y][xStart];
                if (pipe.isOnLoop() && !isSet && pipe.getForm() == '|') {
                    startPipe = pipe;
                    isSet = true;
                }
            }
            xStart++;
        }
        for (int i = 0; i < loop.size(); i++) {
            if (loop.get(i) == startPipe) {
                indexStart = i;
            }
        }
        int index = indexStart;
        boolean moveForward = true;
        for (int i = 0; i < loop.size(); i++) {
            Pipe pipe1 = null;
            if (moveForward) {
                pipe1 = loop.get(index++);
            } else {
                pipe1 = loop.get(index--);
            }
            if (index >= loop.size()) {
                moveForward = false;
                index = indexStart - 1;
            }
            char form = pipe1.getForm();
            int xOfPipe = 0;
            int yOfPipe = 0;
            for (int y = 0; y < pipeMap.length; y++) {
                for (int x = 0; x < pipeMap[0].length; x++) {
                    if (pipeMap[y][x] == pipe1) {
                        xOfPipe = x;
                        yOfPipe = y;
                    }
                }
            }
            if (currentDirectionOutside.equals("l")) {
                boolean reachedOtherBorder = false;
                for (int x = xOfPipe - 1; x > 0 && !reachedOtherBorder; x--) {
                    Pipe outsidePipe = pipeMap[yOfPipe][x];
                    if (outsidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    inside.remove(outsidePipe);
                    outside.add(outsidePipe);
                }
                reachedOtherBorder = false;
                for (int x = xOfPipe + 1; x < pipeMap[0].length && !reachedOtherBorder; x++) {
                    Pipe insidePipe = pipeMap[yOfPipe][x];
                    if (insidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    outside.remove(insidePipe);
                    inside.add(insidePipe);
                }
            }
            if (currentDirectionOutside.equals("r")) {
                boolean reachedOtherBorder = false;
                for (int x = xOfPipe - 1; x > 0 && !reachedOtherBorder; x--) {
                    Pipe outsidePipe = pipeMap[yOfPipe][x];
                    if (outsidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    outside.remove(outsidePipe);
                    inside.add(outsidePipe);
                }
                reachedOtherBorder = false;
                for (int x = xOfPipe + 1; x < pipeMap[0].length && !reachedOtherBorder; x++) {
                    Pipe insidePipe = pipeMap[yOfPipe][x];
                    if (insidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    inside.remove(insidePipe);
                    outside.add(insidePipe);
                }
            }
            if (currentDirectionOutside.equals("u")) {
                boolean reachedOtherBorder = false;
                for (int y = yOfPipe - 1; y > 0 && !reachedOtherBorder; y--) {
                    Pipe outsidePipe = pipeMap[y][xOfPipe];
                    if (outsidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    inside.remove(outsidePipe);
                    outside.add(outsidePipe);
                }
                reachedOtherBorder = false;
                for (int y = yOfPipe + 1; y < pipeMap.length && !reachedOtherBorder; y++) {
                    Pipe insidePipe = pipeMap[y][xOfPipe];
                    if (insidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    outside.remove(insidePipe);
                    inside.add(insidePipe);
                }
            }
            if (currentDirectionOutside.equals("d")) {
                boolean reachedOtherBorder = false;
                for (int y = yOfPipe + 1; y < pipeMap.length && !reachedOtherBorder; y++) {
                    Pipe outsidePipe = pipeMap[y][xOfPipe];
                    if (outsidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    inside.remove(outsidePipe);
                    outside.add(outsidePipe);
                }
                reachedOtherBorder = false;
                for (int y = yOfPipe - 1; y > 0 && !reachedOtherBorder; y--) {
                    Pipe insidePipe = pipeMap[y][xOfPipe];
                    if (insidePipe.isOnLoop()) {
                        reachedOtherBorder = true;
                    }
                    outside.remove(insidePipe);
                    inside.add(insidePipe);
                }
            }
            if (form == 'L' || form == '7') {
                if (currentDirectionOutside.equals("l")) {
                    currentDirectionOutside = "d";
                } else if (currentDirectionOutside.equals("d")) {
                    currentDirectionOutside = "l";
                } else if (currentDirectionOutside.equals("r")) {
                    currentDirectionOutside = "u";
                } else {
                    currentDirectionOutside = "r";
                }
            }
            if (form == 'J' || form == 'F') {
                if (currentDirectionOutside.equals("l")) {
                    currentDirectionOutside = "u";
                } else if (currentDirectionOutside.equals("d")) {
                    currentDirectionOutside = "r";
                } else if (currentDirectionOutside.equals("r")) {
                    currentDirectionOutside = "d";
                } else {
                    currentDirectionOutside = "l";
                }
            }
            for (int y = 0; y < pipeMap.length; y++) {
                String line = "";
                for (int x = 0; x < pipeMap[0].length; x++) {
                    Pipe p = pipeMap[y][x];
                    if (p == pipe1) {
                        line += (ANSI_CYAN + p.getForm() + ANSI_CYAN);
                    } else if (inside.contains(p)) {
                        line += (ANSI_GREEN + p.getForm() + ANSI_GREEN);
                    } else {
                        line += (ANSI_YELLOW + p.getForm() + ANSI_YELLOW);
                    }
                }
                System.out.println(line);
            }
            System.out.println("Trennung");
        }


        for (int y = 0; y < pipeMap.length; y++) {
            boolean tubeBegan = false;
            for (int x = 0; x < pipeMap[0].length; x++) {
                Pipe p = pipeMap[y][x];
                if (!tubeBegan) {
                    inside.remove(p);
                }
                if (p.isOnLoop()) {
                    tubeBegan = true;
                }
            }
        }
        for (int y = 0; y < pipeMap.length; y++) {
            String line = "";
            for (int x = 0; x < pipeMap[0].length; x++) {
                Pipe p = pipeMap[y][x];
                if (p.isOnLoop()) {
                    line += (ANSI_GREEN + p.getForm() + ANSI_GREEN);
                } else if (inside.contains(p)) {
                    line += (ANSI_CYAN + '.' + ANSI_CYAN);
                } else {
                    line += (ANSI_WHITE + '.' + ANSI_WHITE);
                }
            }
            System.out.println(line); //Visualizing
        }
        return inside.stream().filter(pipe -> !pipe.isOnLoop()).count();

    }
}

