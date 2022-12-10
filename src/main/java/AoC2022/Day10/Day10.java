package AoC2022.Day10;

import java.util.ArrayList;
import java.util.List;

public class Day10 {

    int xValue;
    int cycle;
    int mul;
    String crtOutput;
    int spritePosition;
    String line;
    int linecount;
    private List<Instruction> instructions;
    private List<Long> importantXValues;

    public Day10(String input) {
        instructions = new Input(input).parseInput();
        importantXValues = new ArrayList<>();
        xValue = 1;
        cycle = 0;
        mul = 1;
        crtOutput = "";
        linecount = 0;
        line = "";
        generateCRTline();
        spritePosition = 0;
    }

    public long task1() {
        followInstructions();
        return importantXValues.stream()
                .mapToInt(Long::intValue).sum();
    }

    private void followInstructions() {
        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getCycles(); i++) {
                waitCycle();
            }
            xValue += instruction.getValue();
            spritePosition = xValue;
        }
    }

    private void waitCycle() {
        if (cycle == 40 || cycle == 80 || cycle == 120 || cycle == 160 || cycle == 200) {
            line += "\n";
            crtOutput += line;
            line = "";
            generateCRTline();
            linecount++;
        }
        drawInstructionCycle();
        cycle++;
        if (cycle == 20 * mul) {
            importantXValues.add((long) xValue * cycle);
            mul += 2;
        }
    }

    public String task2() {
        followInstructions();
        crtOutput += line;
        System.out.println(crtOutput);
        return crtOutput;
    }

    private void generateCRTline() {
        for (int j = 0; j < 40; j++) {
            line += " ";
        }

    }

    private void drawInstructionCycle() {
        if ((cycle - 40 * linecount) == spritePosition || (cycle - 40 * linecount) == spritePosition + 1 || (cycle - 40 * linecount) == spritePosition - 1) {
            char[] myChars = line.toCharArray();
            myChars[(cycle - 40 * linecount)] = '#';
            line = String.valueOf(myChars);
        } else {
            char[] myChars = line.toCharArray();
            myChars[(cycle - 40 * linecount)] = '.';
            line = String.valueOf(myChars);
        }
    }
}
