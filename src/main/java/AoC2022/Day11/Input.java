package AoC2022.Day11;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Monkey> parseInput() {
        List<Monkey> monkeys = new ArrayList<>();
        String[] monkeyLines = input.split("\n\n");
        for (String monkeyLine : monkeyLines) {
            String[] monkeyParameters = monkeyLine.split("\n");
            List<Long> itemsOfMonkey = new ArrayList<>();
            String[] splitItems = monkeyParameters[1].split(": ");
            String[] numbers = splitItems[1].split(", ");
            for (String number : numbers) {
                itemsOfMonkey.add(Long.parseLong(number));
            }
            boolean hasPlus = monkeyParameters[2].contains("+");
            String[] operationSplit = monkeyParameters[2].split(" ");
            int factorOperation;
            if (operationSplit[operationSplit.length - 1].equals("old")) {
                factorOperation = -1;
            } else {
                factorOperation = Integer.parseInt(operationSplit[operationSplit.length - 1]);
            }
            int factorTest;
            String[] testSplit = monkeyParameters[3].split(" ");
            factorTest = Integer.parseInt(testSplit[testSplit.length - 1]);

            String[] trueSplit = monkeyParameters[4].split(" ");
            int monkeyIndexTrue = Integer.parseInt(trueSplit[trueSplit.length - 1]);
            String[] falseSplit = monkeyParameters[5].split(" ");
            int monkeyIndexFalse = Integer.parseInt(falseSplit[falseSplit.length - 1]);

            monkeys.add(new Monkey(itemsOfMonkey, hasPlus, factorOperation, factorTest, monkeyIndexTrue, monkeyIndexFalse));
        }
        return monkeys;
    }
}
