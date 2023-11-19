package AoC2022.Day13;

import java.util.List;

public class Pair {

    private Packet left;
    private Packet right;

    public Pair(String leftString, String rightString) {
        left = new Packet(leftString);
        right = new Packet(rightString);
    }

    public boolean isRightOrder() {
        return compare(left.items, right.items) < 0;
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
