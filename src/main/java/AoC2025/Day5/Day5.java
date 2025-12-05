package AoC2025.Day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day5 {

    private List<Long> freshIds;
    private List<Long> ids;

    public Day5(String i) {
        Input in = new Input(i);
        List<List<Long>> l = in.parseInput();
        freshIds = l.get(0);
        ids = l.get(1);
    }

    public long task1() {
        long res = 0;
        for (Long id : ids) {
            boolean foundInFresh = false;
            for (int i = 0; i < freshIds.size() && !foundInFresh; i++) {
                long currentRangeBegin = freshIds.get(i);
                long currentRangeEnd = freshIds.get(++i);
                if (id >= currentRangeBegin && id <= currentRangeEnd) {
                    foundInFresh = true;
                    res++;
                }
            }
        }
        return res;
    }

    public long task2() {
        long res = 0;
        List<Tuple> tuples = new ArrayList<>();
        int ind = 0;
        for (int i = 0; i < freshIds.size(); i++) {
            if (i % 2 == 0) {
                Tuple t = new Tuple();
                t.setStart(freshIds.get(i));
                tuples.add(t);
            } else {
                Tuple t = tuples.get(ind);
                t.setEnd(freshIds.get(i));
                ind++;
            }
        }
        while (!tuples.isEmpty()) {
            List<Tuple> tuplesSortedSmall = tuples.stream().sorted(Comparator.comparingLong(Tuple::getStart)).toList();
            long currentEnd = tuplesSortedSmall.get(0).getEnd();
            List<Tuple> tuplesUsed = new ArrayList<>();
            tuplesUsed.add(tuplesSortedSmall.get(0));
            int index = 0;
            boolean stop = false;
            while (index < (tuplesSortedSmall.size() - 1) && !stop) {
                long start = tuplesSortedSmall.get(index + 1).getStart();
                if (start > currentEnd) {
                    stop = true;
                } else {
                    Tuple e = tuplesSortedSmall.get(index + 1);
                    tuplesUsed.add(e);
                    if (e.getEnd() > currentEnd) {
                        currentEnd = e.getEnd();
                    }
                    index++;
                }
            }
            res += (currentEnd + 1 - tuplesSortedSmall.get(0).getStart());
            tuples.removeAll(tuplesUsed);
        }
        return res;
    }
}
