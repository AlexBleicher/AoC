package AoC2019.Day4;

public class Password {

    private int password;
    private String passwordAsString;

    public Password(int password) {
        this.password = password;
        this.passwordAsString = "" + password;
    }

    public boolean neverDecreases() {
        int lastNumber = 0;
        for (int i = 0; i < passwordAsString.length(); i++) {
            int currentNumber = Integer.parseInt(passwordAsString.substring(i, i + 1));
            if (lastNumber > currentNumber) {
                return false;
            }
            lastNumber = currentNumber;
        }
        return true;
    }

    public boolean hasDouble() {
        char lastChar = ' ';
        for (int i = 0; i < passwordAsString.length(); i++) {
            char currentChar = passwordAsString.charAt(i);
            if (lastChar == currentChar) {
                return true;
            }
            lastChar = currentChar;
        }
        return false;
    }

    public boolean hasLonelyDouble() {
        char lastChar = ' ';
        int amountOfSameChars = 1;
        for (int i = 0; i < passwordAsString.length(); i++) {
            char currentChar = passwordAsString.charAt(i);
            if (lastChar == currentChar) {
                amountOfSameChars++;
            } else {
                if (amountOfSameChars == 2) {
                    return true;
                }
                amountOfSameChars = 1;
            }
            lastChar = currentChar;
        }
        if (amountOfSameChars == 2) {
            return true;
        }
        return false;
    }
}
