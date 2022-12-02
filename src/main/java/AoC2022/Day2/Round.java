package AoC2022.Day2;

public class Round {

    private Choice opponentsChoice;
    private Choice yourChoice;
    private int score;

    public Round(Choice opponentsChoice, Choice yourChoice) {
        this.opponentsChoice = opponentsChoice;
        this.yourChoice = yourChoice;
        calculateScoreOfRound();
    }

    public int getScore() {
        return score;
    }

    public void calculateScoreOfRound(){
        if(yourChoice==Choice.Rock){
            score+=1;
        }
        else if(yourChoice==Choice.Paper){
            score+=2;
        }
        else if(yourChoice==Choice.Scissors){
            score+=3;
        }
        score += roundOutcome();
    }

    private int roundOutcome(){
        if((yourChoice==Choice.Rock&&opponentsChoice==Choice.Scissors)||(yourChoice==Choice.Paper&&opponentsChoice==Choice.Rock)||(yourChoice==Choice.Scissors &&opponentsChoice==Choice.Paper)){
            return 6;
        }
        else if(yourChoice==opponentsChoice){
            return 3;
        }
        else{
            return 0;
        }
    }
}
