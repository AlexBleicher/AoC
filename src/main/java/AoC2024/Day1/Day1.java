package AoC2024.Day1;

import java.util.List;
import java.util.Objects;

public class Day1 {

    private List<List<Long>> listOfLists;

    public Day1(String i) {
        listOfLists = new Input(i).parseInput();
    }

    public long task1() {
        List<Long> listLeft = listOfLists.get(0);
        List<Long> listRight = listOfLists.get(1);
        List<Long> left = listLeft.stream().sorted().toList();
        List<Long> right = listRight.stream().sorted().toList();
        long res = 0;
        for (int i = 0; i < left.size(); i++) {
            long l = left.get(i);
            long r = right.get(i);
            if (l > r) {
                res += l - r;
            } else {
                res += r - l;
            }
        }
        return res;
    }

    long task2() {
        List<Long> left = listOfLists.get(0);
        List<Long> right = listOfLists.get(1);
        long res = 0;
        for (Long l : left) {
            res += right.stream().filter(a -> Objects.equals(a, l)).count() * l;
        }
        return res;
    }
}
