package AoC2024.Day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day11 {

    Map<Params, Long> map = new HashMap<>();
    private List<Stone> stoneList;

    public Day11(String i) {
        stoneList = new Input(i).parseInput();
    }

    public long task1() {
        for (int i = 0; i < 25; i++) {
            List<Stone> listAfterBlink = new ArrayList<>();
            for (Stone stone : stoneList) {
                listAfterBlink.addAll(stone.getAfterBlink());
            }
            stoneList = listAfterBlink;
        }
        return stoneList.size();
    }

    public long task2() {
        List<Long> values = stoneList.stream().map(Stone::getNumberEngraved).toList();
        long res = 0;
        for (Long value : values) {
            res += func(value, 75);
            System.out.println("One Value done");
        }
        return res;
    }

    private long func(long value, int count) {
        if (count == 0) {
            return 1;
        }
        if (value == 0) {
            return func(1, count - 1);
        }
        String valueAsString = "" + value;
        if (valueAsString.length() % 2 == 0) {
            Params p1 = new Params(Long.parseLong(valueAsString.substring(0, valueAsString.length() / 2)), count - 1);
            Params p2 = new Params(Long.parseLong(valueAsString.substring(valueAsString.length() / 2)), count - 1);
            long f1;
            long f2;
            if (map.containsKey(p1)) {
                f1 = map.get(p1);
            } else {
                f1 = func(p1.getValue(), p1.getCount());
                map.put(p1, f1);
            }

            if (map.containsKey(p2)) {
                f2 = map.get(p2);
            } else {
                f2 = func(p2.getValue(), p2.getCount());
                map.put(p2, f2);
            }
            return f1 + f2;
        }
        return func(2024 * value, count - 1);
    }
}
