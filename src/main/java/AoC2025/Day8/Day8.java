package AoC2025.Day8;

import java.util.*;

public class Day8 {

    private List<JunctionBox> junctionBoxes;
    private Set<Tuple> distances = new HashSet<>();

    public Day8(String i) {
        junctionBoxes = new Input(i).parseInput();
    }

    public long task1(int amountConn) {
        long res = 1;
        for (JunctionBox junctionBox : junctionBoxes) {
            JunctionBox jb1 = junctionBox;
            for (int i = junctionBoxes.indexOf(jb1) + 1; i < junctionBoxes.size(); i++) {
                JunctionBox jb2 = junctionBoxes.get(i);
                Tuple t = new Tuple();
                t.setJb1(jb1);
                t.setJb2(jb2);
                t.setDist(jb1.calcDistance(jb2));
                distances.add(t);
            }
        }

        List<List<JunctionBox>> circuits = new ArrayList<>();
        for (
                JunctionBox junctionBox : junctionBoxes) {
            List<JunctionBox> list = new ArrayList<>();
            list.add(junctionBox);
            circuits.add(list);
        }

        List<Tuple> sortedDist = distances.stream().sorted(Comparator.comparingDouble(Tuple::getDist)).toList();
        for (int i = 0; i < amountConn; i++) {
            Tuple t = sortedDist.get(i);
            List<JunctionBox> circuit1 = new ArrayList<>();
            List<JunctionBox> circuit2 = new ArrayList<>();
            for (List<JunctionBox> circuit : circuits) {
                if (circuit.contains(t.getJb1())) {
                    circuit1 = circuit;
                } else if (circuit.contains(t.getJb2())) {
                    circuit2 = circuit;
                }
            }
            if (circuit2 != circuit1) {
                circuit1.addAll(circuit2);
                circuits.remove(circuit2);
            }
        }
        circuits.sort(Comparator.comparing(List::size));
        for (
                int i = 0;
                i < 3; i++) {
            res = res * circuits.get(circuits.size() - (1 + i)).size();
        }
        return res;
    }

    public long task2() {
        long res = 0;

        for (JunctionBox junctionBox : junctionBoxes) {
            JunctionBox jb1 = junctionBox;
            for (int i = junctionBoxes.indexOf(jb1) + 1; i < junctionBoxes.size(); i++) {
                JunctionBox jb2 = junctionBoxes.get(i);
                Tuple t = new Tuple();
                t.setJb1(jb1);
                t.setJb2(jb2);
                t.setDist(jb1.calcDistance(jb2));
                distances.add(t);
            }
        }

        List<List<JunctionBox>> circuits = new ArrayList<>();
        for (
                JunctionBox junctionBox : junctionBoxes) {
            List<JunctionBox> list = new ArrayList<>();
            list.add(junctionBox);
            circuits.add(list);
        }

        List<Tuple> sortedDist = distances.stream().sorted(Comparator.comparingDouble(Tuple::getDist)).toList();
        int index = 0;
        long lastX1 = 0;
        long lastX2 = 0;
        while (circuits.size() > 1) {
            Tuple t = sortedDist.get(index++);
            lastX1 = t.getJb1().getX();
            lastX2 = t.getJb2().getX();
            List<JunctionBox> circuit1 = new ArrayList<>();
            List<JunctionBox> circuit2 = new ArrayList<>();
            for (List<JunctionBox> circuit : circuits) {
                if (circuit.contains(t.getJb1())) {
                    circuit1 = circuit;
                } else if (circuit.contains(t.getJb2())) {
                    circuit2 = circuit;
                }
            }
            if (circuit2 != circuit1) {
                circuit1.addAll(circuit2);
                circuits.remove(circuit2);
            }
        }
        res = lastX1 * lastX2;
        return res;
    }
}
