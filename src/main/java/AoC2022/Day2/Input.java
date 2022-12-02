package AoC2022.Day2;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Round> parseInput(){
        List<Round> rounds = new ArrayList<>();
        String[] linesOfInput = input.split("\n");
        for (String s : linesOfInput) {
            String[] choices=s.split(" ");
            Choice opponentsChoice = decipherChoices(choices[0]);
            Choice yourChoice = decipherChoices(choices[1]);
            rounds.add(new Round(opponentsChoice, yourChoice));
        }
        return rounds;
    }

    private Choice decipherChoices(String cipherText){
        if(cipherText.equals("A")||cipherText.equals("X")){
            return Choice.Rock;
        }
        else if(cipherText.equals("B")||cipherText.equals("Y")){
            return Choice.Paper;
        }
        else if(cipherText.equals("C")||cipherText.equals("Z")){
            return Choice.Sissors;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
