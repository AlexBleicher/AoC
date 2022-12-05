package AoC2022.Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Stack<String>> parseInput1(){
        List<Stack<String>> stacks = new ArrayList<>();
        String[] stackLines= input.split("\n\n")[0].split("\n");
        String lastLine = stackLines[stackLines.length-1];
        String[] numbers = lastLine.split(" ");
        int amountOfStacks = Integer.parseInt(numbers[numbers.length-1]);
        for(int i=0; i<amountOfStacks; i++){
            stacks.add(new Stack<String>());
        }
        for(int i=stackLines.length-1; i>=0; i--){
            String line = stackLines[i];
            String[] cratesInLine = line.split("(?<=\\G.{4})");
            for (int j = 0; j < cratesInLine.length; j++) {
                Stack<String> stack = stacks.get(j);
                String subString = cratesInLine[j];
                if(subString.startsWith("[")){
                    stack.add(subString.substring(1,2));
                }
            }
        }
        return stacks;
    }

    public List<Instruction> paseInput2(){
        List<Instruction> instructions = new ArrayList<>();
        String[] instructionLines = input.split("\n\n")[1].split("\n");
        for (String instructionLine : instructionLines) {
            String[] splitInstruction = instructionLine.split(" ");
            int amount = Integer.parseInt(splitInstruction[1]);
            int fromIndex = Integer.parseInt(splitInstruction[3]);
            int toIndex = Integer.parseInt(splitInstruction[5]);
            instructions.add(new Instruction(amount, fromIndex, toIndex));
        }
        return instructions;
    }
}
