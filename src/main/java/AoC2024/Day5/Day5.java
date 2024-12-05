package AoC2024.Day5;

import java.util.List;

public class Day5 {

    private List<Rule> rules;
    private List<Update> updates;

    public Day5(String i) {
        Input in = new Input(i);
        rules = in.parseInputRules();
        updates = in.parseInputUpdates();
    }

    public long task1() {
        long res = 0;
        for (Update update : updates) {
            boolean passes = true;
            for (Rule rule : rules) {
                if (!checkForRule(update, rule)) {
                    passes = false;
                }
            }
            if (passes) {
                List<Long> numbers = update.getNumbers();
                res += numbers.get(numbers.size() / 2);
            }
        }
        return res;
    }

    private boolean checkForRule(Update u, Rule r) {
        List<Long> numbers = u.getNumbers();
        long first = r.getComesFirst();
        long second = r.getComesSecond();
        if (numbers.contains(first) && numbers.contains(second)) {
            for (int i = 0; i < numbers.size(); i++) {
                long number = numbers.get(i);
                if (number == second) {
                    return false;
                }
                if (number == first) {
                    return true;
                }
            }
        }
        return true;
    }

    public long task2() {
        long res = 0;
        for (Update update : updates) {
            boolean use = false;
            for (int i = 0; i < rules.size(); i++) {
                Rule rule = rules.get(i);
                if (!checkForRule(update, rule)) {
                    use = true;
                    do {
                        checkForRuleAndReorder(update, rule);
                    } while (!checkForRule(update, rule));
                    i = 0;
                }
            }
            if (use) {
                List<Long> numbers = update.getNumbers();
                res += numbers.get(numbers.size() / 2);
            }
        }
        return res;
    }

    private Update checkForRuleAndReorder(Update u, Rule r) {
        List<Long> numbers = u.getNumbers();
        long first = r.getComesFirst();
        long second = r.getComesSecond();
        if (numbers.contains(first) && numbers.contains(second)) {
            for (int i = 0; i < numbers.size(); i++) {
                long number = numbers.get(i);
                if (number == second) {
                    numbers.set(i, first);
                    for (int j = i + 1; j < numbers.size(); j++) {
                        if (numbers.get(j) == first) {
                            numbers.set(j, second);
                            u.setNumbers(numbers);
                        }
                    }
                    return u;
                }
                if (number == first) {
                    return u;
                }
            }
        }
        return u;
    }
}
