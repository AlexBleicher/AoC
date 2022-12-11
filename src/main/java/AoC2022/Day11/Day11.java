package AoC2022.Day11;

import java.util.Comparator;
import java.util.List;

public class Day11 {

    private List<Monkey> monkeys;

    public Day11(String input) {
        monkeys = new Input(input).parseInput();
    }

    public long task1() {
        for (int i = 0; i < 20; i++) {
            doRound();
        }
        Monkey monkeywithMostInspected = monkeys.stream()
                .max(Comparator.comparingInt(Monkey::getCounter))
                .get();
        monkeys.remove(monkeywithMostInspected);
        Monkey monkeywithSecondMostInspected = monkeys.stream()
                .max(Comparator.comparingInt(Monkey::getCounter))
                .get();
        return (long) monkeywithMostInspected.getCounter() * monkeywithSecondMostInspected.getCounter();
    }

    private void doRound() {
        for (Monkey monkey : monkeys) {
            int size = monkey.getItems().size();
            for (int i = 0; i < size; i++) {
                int indexToThrowAt = monkey.dealWithItem();
                monkeys.get(indexToThrowAt).getItems().add(monkey.getItems().remove(0));
            }
        }
    }

    private void doRound2() {
        long allDivisorMul = 1;
        for (Monkey monkey : monkeys) {
            allDivisorMul *= monkey.getFactorTest();
        }
        for (Monkey monkey : monkeys) {
            int size = monkey.getItems().size();
            for (int i = 0; i < size; i++) {
                int indexToThrowAt = monkey.dealWithItem2(allDivisorMul);
                monkeys.get(indexToThrowAt).getItems().add(monkey.getItems().remove(0));
            }
        }
    }

    public long task2() {
        for (int i = 0; i < 10000; i++) {
            doRound2();
        }
        Monkey monkeywithMostInspected = monkeys.stream()
                .max(Comparator.comparingInt(Monkey::getCounter))
                .get();
        monkeys.remove(monkeywithMostInspected);
        Monkey monkeywithSecondMostInspected = monkeys.stream()
                .max(Comparator.comparingInt(Monkey::getCounter))
                .get();
        return (long) monkeywithMostInspected.getCounter() * monkeywithSecondMostInspected.getCounter();
    }
}
