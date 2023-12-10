package AoC2023.Day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day10 {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";
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

    public void task2() {
        Pipe start = new Pipe('0');
        for (Pipe[] pipes : pipeMap) {
            for (int x = 0; x < pipeMap.length; x++) {
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
        while (current1 != start) {
            current1.setOnLoop(true);
            Pipe c = current1;
            loop.add(current1);
            current1 = current1.travelForm(lastPipe1);
            lastPipe1 = c;
        }

        Set<Pipe> outside = new HashSet<>();
        Set<Pipe> inside = new HashSet<>();
        String currentDirectionOutside = "l";
        int startIndex = -1;
        for (int i = 0; i < loop.size(); i++) {
            Pipe p = loop.get(i);
            if (p.getForm() == '|' && startIndex < 0) {
                startIndex = i;
            }
        }

        for (int y = 0; y < pipeMap.length; y++) {
            String line = "";
            for (int x = 0; x < pipeMap.length; x++) {
                Pipe p = pipeMap[y][x];
                if (p.isOnLoop()) {
                    line += (ANSI_GREEN + p.getForm() + ANSI_GREEN);
                } else if (p.getForm() == '.') {
                    line += (ANSI_WHITE + p.getForm() + ANSI_WHITE);
                } else {
                    line += (" ");
                }
            }
            System.out.println(line); //Visualizing
        }
    }
}

