package AoC2022.Day5;

import java.util.List;
import java.util.Stack;

public class Day5 {

    private List<Stack<String>> stacks;
    private List<Instruction> instructions;

    public Day5(String input) {
        Input inputParser = new Input(input);
        stacks = inputParser.parseInput1();
        instructions = inputParser.paseInput2();
    }

    public String task1() {
        String result = "";
        doInstructions();
        for (Stack<String> stack : stacks) {
            result += stack.peek();
        }
        return result;
    }

    private void doInstructions() {
        for (Instruction instruction : instructions) {
            Stack<String> stackFrom = stacks.get(instruction.getIndexFrom() - 1);
            Stack<String> stackTo = stacks.get(instruction.getIndexTo() - 1);
            for (int i = 0; i < instruction.getAmount(); i++) {
                String crate = stackFrom.pop();
                stackTo.push(crate);
            }
        }
    }

    public String task2() {
        String result = "";
        doInstructionsWithNewCrane();
        for (Stack<String> stack : stacks) {
            if (!stack.empty())
                result += stack.peek();
        }
        return result;
    }

    private void doInstructionsWithNewCrane() {
        for (Instruction instruction : instructions) {
            Stack<String> stackFrom = stacks.get(instruction.getIndexFrom() - 1);
            Stack<String> stackTo = stacks.get(instruction.getIndexTo() - 1);
            List<String> crates = stackFrom.subList(stackFrom.size() - instruction.getAmount(), stackFrom.size());
            stackTo.addAll(crates);
            for(int i=0; i<instruction.getAmount(); i++){
                stackFrom.pop();
            }

        }
    }
}
