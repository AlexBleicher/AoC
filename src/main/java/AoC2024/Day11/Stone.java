package AoC2024.Day11;

import java.util.ArrayList;
import java.util.List;

public class Stone {

    private long numberEngraved;

    public Stone(long numberEngraved) {
        this.numberEngraved = numberEngraved;
    }

    public List<Stone> getAfterBlink() {
        List<Stone> stonesAfterBlink = new ArrayList<>();
        if (numberEngraved == 0) {
            stonesAfterBlink.add(new Stone(1));
            return stonesAfterBlink;
        }
        String numbersAsString = "" + numberEngraved;
        if (numbersAsString.length() % 2 == 0) {
            String firstPart = numbersAsString.substring(0, numbersAsString.length() / 2);
            String secondPart = numbersAsString.substring(numbersAsString.length() / 2);
            stonesAfterBlink.add(new Stone(Long.parseLong(firstPart)));
            stonesAfterBlink.add(new Stone(Long.parseLong(secondPart)));
            return stonesAfterBlink;
        }
        stonesAfterBlink.add(new Stone(numberEngraved * 2024));
        return stonesAfterBlink;
    }

    public long getNumberEngraved() {
        return numberEngraved;
    }
}
