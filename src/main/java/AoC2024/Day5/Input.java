package AoC2024.Day5;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Rule> parseInputRules() {
        List<Rule> res = new ArrayList<>();
        String s = input.split("\n\n")[0];
        String[] split = s.split("\n");
        for (String string : split) {
            String[] split1 = string.split("\\|");
            Rule ruleToAdd = new Rule(Long.parseLong(split1[0]), Long.parseLong(split1[1]));
            res.add(ruleToAdd);
        }
        return res;
    }

    public List<Update> parseInputUpdates() {
        List<Update> res = new ArrayList<>();
        String s = input.split("\n\n")[1];
        String[] split = s.split("\n");
        for (String string : split) {
            Update u = new Update();
            String[] split1 = string.split(",");
            for (String s1 : split1) {
                u.addNumber(Long.parseLong(s1));
            }
            res.add(u);
        }
        return res;
    }
}
