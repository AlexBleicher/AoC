package AoC2023.Day9;

import java.util.ArrayList;
import java.util.List;

public class History {

    private List<Integer> values;

    public History(List<Integer> values) {
        this.values = values;
    }

    public int predictNextValue() {
        List<Integer> diffs = new ArrayList<>();
        if (values.size() > 1) {
            for (int i = 0; i < values.size() - 1; i++) {
                int currentValue = values.get(i);
                int nextValue = values.get(i + 1);
                diffs.add(nextValue - currentValue);
            }
            if (diffs.stream().allMatch(integer -> integer == 0)) {
                return (values.get(values.size() - 1));
            }
            int value = values.get(values.size() - 1) + new History(diffs).predictNextValue();
            return value;
        }
        return values.get(0);
    }

    public int predictPrevValue() {
        List<Integer> diffs = new ArrayList<>();
        if (values.size() > 1) {
            for (int i = 0; i < values.size() - 1; i++) {
                int currentValue = values.get(i);
                int nextValue = values.get(i + 1);
                diffs.add(nextValue - currentValue);
            }
            if (diffs.stream().allMatch(integer -> integer == 0)) {
                return (values.get(0));
            }
            int value = values.get(0) - new History(diffs).predictPrevValue();
            return value;
        }
        return values.get(0);
    }
}
