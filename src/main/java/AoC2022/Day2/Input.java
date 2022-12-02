package AoC2022.Day2;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public List<Round> parseInput(int task) {
        List<Round> rounds = new ArrayList<>();
        String[] linesOfInput = input.split("\n");
        for (String s : linesOfInput) {
            String[] choices = s.split(" ");
            Choice opponentsChoice;
            Choice yourChoice;
            if (task == 1) {
                opponentsChoice = decipherChoices(choices[0]);
                yourChoice = decipherChoices(choices[1]);
            } else if (task == 2) {
                opponentsChoice = decipherChoices(choices[0]);
                yourChoice = decipherYourChoiceCorrectly(opponentsChoice, choices[1]);
            } else {
                throw new IllegalArgumentException();
            }
            rounds.add(new Round(opponentsChoice, yourChoice));
        }
        return rounds;
    }

    private Choice decipherChoices(String cipherText) {
        if (cipherText.equals("A") || cipherText.equals("X")) {
            return Choice.Rock;
        } else if (cipherText.equals("B") || cipherText.equals("Y")) {
            return Choice.Paper;
        } else if (cipherText.equals("C") || cipherText.equals("Z")) {
            return Choice.Scissors;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Choice decipherYourChoiceCorrectly(Choice opponentsChoice, String winloosedraw) {
        if(winloosedraw.equals("X")){ //loose
            if(opponentsChoice==Choice.Paper){
                return Choice.Rock;
            }
            else if(opponentsChoice==Choice.Rock){
                return Choice.Scissors;
            }
            else if(opponentsChoice == Choice.Scissors){
                return Choice.Paper;
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(winloosedraw.equals("Y")){ //draw
            return opponentsChoice;
        }
        else if(winloosedraw.equals("Z")){//win
            if(opponentsChoice==Choice.Paper){
                return Choice.Scissors;
            }
            else if(opponentsChoice==Choice.Rock){
                return Choice.Paper;
            }
            else if(opponentsChoice == Choice.Scissors){
                return Choice.Rock;
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
