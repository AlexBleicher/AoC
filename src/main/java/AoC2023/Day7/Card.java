package AoC2023.Day7;

public class Card {

    private char label;
    private int strength;

    public Card(char l) {
        label = l;
        if (Character.isDigit(l)) {
            strength = Character.getNumericValue(l);
        } else {
            if (l == 'T') {
                strength = 10;
            } else if (l == 'J') {
                strength = 11;
            } else if (l == 'Q') {
                strength = 12;
            } else if (l == 'K') {
                strength = 13;
            } else if (l == 'A') {
                strength = 14;
            }
        }
    }

    public char getLabel() {
        return label;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
