package AoC2024.Day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Multiplication> parseInput() {
        List<String> matches = new ArrayList<>();
        List<Integer> startIndizesMuls = new ArrayList<>();
        Matcher m = Pattern.compile("mul\\(\\d+,\\d+\\)").matcher(input);
        while (m.find()) {
            startIndizesMuls.add(m.start());
            matches.add(m.group());
        }
        List<Multiplication> multiplications = new ArrayList<>();
        int i = 0;
        for (String s : matches) {
            String[] split = s.split(",");
            long a = Long.parseLong(split[0].substring(4));
            long b = Long.parseLong(split[1].substring(0, split[1].length() - 1));
            multiplications.add(new Multiplication(a, b, startIndizesMuls.get(i++)));
        }
        return multiplications;
    }

    public List<Enabled> parseEnabledInstructions() {
        Matcher m = Pattern.compile("do\\(\\)").matcher(input);
        List<Enabled> enableds = new ArrayList<>();
        while (m.find()) {

            int start = m.start();
            enableds.add(new Enabled(start, true));
        }
        m = Pattern.compile("don't\\(\\)").matcher(input);
        while (m.find()) {
            enableds.add(new Enabled(m.start(), false));
        }
        return enableds.stream().sorted(Comparator.comparingInt(Enabled::getStartIndex)).toList();
    }
}
