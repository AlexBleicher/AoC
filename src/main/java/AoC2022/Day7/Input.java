package AoC2022.Day7;

import java.util.*;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Command> parseInput(){
        List<Command> resultList=new ArrayList<>();
        String[] commands=input.split("\\$");
        for (int i=1; i<commands.length; i++) {
            String command=commands[i];
            command = command.trim();
            String[] split = command.split("\n");
            if(split.length>1){
                String listContent = "";
                for(int j=1;j<split.length;j++){
                    listContent+=split[j]+"\n";
                }
                resultList.add(new Command(split[0], listContent));
            }
            else{
                String[] splitDirectory=split[0].split(" ");
                resultList.add(new Command(splitDirectory[0], splitDirectory[1]));
            }
        }
        return resultList;
    }
}
