package AoC2021.Day12;

import java.util.*;

public class Cave {

    private boolean isSmallCave;
    private List<Cave> connections = new ArrayList<>();
    private String name;

    public Cave(String name, boolean isSmallCave) {
        this.name = name;
        this.isSmallCave = isSmallCave;
    }

    public void addConnection(Cave neighbor) {
        if (!connections.contains(neighbor)) {
            connections.add(neighbor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return Objects.equals(name, cave.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public List<List<Cave>> findAllPathsToEnd(List<Cave> allVisitedInThisAttempt) {
        if (isSmallCave && allVisitedInThisAttempt.contains(this)) {
            return Collections.emptyList();
        }
        List<List<Cave>> allPathsToEndFromThis = new ArrayList<>();
        List<Cave> path = new ArrayList<>();
        path.addAll(allVisitedInThisAttempt);
        path.add(this);
        if (name.equals("end")) {
            allPathsToEndFromThis.add(path);
            return allPathsToEndFromThis;
        }
        for (Cave neighbor : connections) {
            allPathsToEndFromThis.addAll(neighbor.findAllPathsToEnd(path));
        }
        return allPathsToEndFromThis;
    }

    public int findAllPathsToEnd2(Set<Cave> visitedCaves, boolean smallCaveVisitedTwice) {
        if (name.equals("end")) {
            return 1;
        }
        int result = 0;
        if (!isSmallCave || !visitedCaves.contains(this)) {
            Set<Cave> allVisitedCaves = new HashSet<>();
            allVisitedCaves.addAll(visitedCaves);
            allVisitedCaves.add(this);
            for (Cave neighbor : connections) {
                result += neighbor.findAllPathsToEnd2(allVisitedCaves, smallCaveVisitedTwice);
            }
        } else if (isSmallCave && !name.equals("start") && !smallCaveVisitedTwice) {
            for (Cave neighbor : connections) {
                result += neighbor.findAllPathsToEnd2(visitedCaves, true);
            }
        }
        return result;
    }
}