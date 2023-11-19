package AoC2022.Day13;

import java.util.ArrayList;
import java.util.List;

public class Day13 {

    private List<Pair> pairs;

    public Day13(String input) {
        this.pairs = new Input(input).parseInput();
    }

    public int solveTask1() {
        int sum = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if (compare(pairs.get(i).getLeft().items, pairs.get(i).getRight().items) < 0) {
                sum += i + 1;
            }
        }
        return sum;
    }

    public int solveTask2() {
        List<Packet> allPackets = new ArrayList<>();
        for (Pair pair : pairs) {
            allPackets.add(pair.getLeft());
            allPackets.add(pair.getRight());
        }

        List<Packet> dividers = List.of(new Packet("[[2]]"), new Packet("[[6]]"));
        allPackets.addAll(dividers);
        List<List<Object>> sortedPackets = allPackets.stream()
                .map(packet -> packet.items)
                .sorted(this::compare).toList();

        System.out.println(sortedPackets);
        List<List<Object>> dividersAsItems = dividers.stream().map(packet -> packet.items).toList();
        Integer res = dividersAsItems.stream()
                .map(sortedPackets::indexOf)
                .reduce((a, b) -> (a + 1) * (b + 1))
                .orElseThrow();

        return res;
    }

    private int compare(Object leftItem, Object rightItem) {
        if (leftItem instanceof Integer leftInt && rightItem instanceof Integer rightInt) {
            return leftInt - rightInt;
        }

        if (leftItem instanceof List<?> leftList && rightItem instanceof List<?> rightList) {
            if (leftList.isEmpty()) {
                return rightList.isEmpty() ? 0 : -1;
            }
            int minSize = Math.min(leftList.size(), rightList.size());
            for (int i = 0; i < minSize; i++) {
                int compareRes = compare(leftList.get(i), rightList.get(i));
                if (compareRes != 0) {
                    return compareRes;
                }
            }
            return leftList.size() - rightList.size();
        }

        if (leftItem instanceof Integer && rightItem instanceof List<?>) {
            return compare(List.of(leftItem), rightItem);
        }
        if (leftItem instanceof List<?> && rightItem instanceof Integer) {
            return compare(leftItem, List.of(rightItem));
        }

        throw new RuntimeException("Somethings not right here");
    }
}
