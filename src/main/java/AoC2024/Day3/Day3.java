package AoC2024.Day3;

import java.util.List;

public class Day3 {

    private List<Multiplication> multiplications;
    private List<Enabled> enableds;

    private String input;

    public Day3(String i) {
        this.input = i;
        Input in = new Input(i);
        multiplications = in.parseInput();
        enableds = in.parseEnabledInstructions();
    }

    public long task1() {
        long res = 0;
        for (Multiplication multiplication : multiplications) {
            res += multiplication.doInstruction();
        }
        return res;
    }

    public long task2() {
        long res = 0;
        boolean enabled = true;
        int lastBlockEnd = 0;
        int nextBlockStart = 0;
        for (Enabled enabled1 : enableds) {
            nextBlockStart = enabled1.getStartIndex();
            if (enabled) {
                int finalLastBlockEnd = lastBlockEnd;
                int finalNextBlockStart = nextBlockStart;
                List<Multiplication> allInRange = multiplications.stream().filter(multiplication -> multiplication.isInRange(finalLastBlockEnd, finalNextBlockStart)).toList();
                for (Multiplication multiplication : allInRange) {
                    res += multiplication.doInstruction();
                }
            }
            lastBlockEnd = nextBlockStart;
            enabled = enabled1.isEnabled();
        }
        if (enabled) {
            int finalLastBlockEnd = lastBlockEnd;
            int finalNextBlockStart = input.length();
            List<Multiplication> allInRange = multiplications.stream().filter(multiplication -> multiplication.isInRange(finalLastBlockEnd, finalNextBlockStart)).toList();
            for (Multiplication multiplication : allInRange) {
                res += multiplication.doInstruction();
            }
        }
        return res;
    }
}
