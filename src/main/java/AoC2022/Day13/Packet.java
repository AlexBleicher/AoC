package AoC2022.Day13;

import java.util.ArrayList;
import java.util.List;

public class Packet {

    public List<Item> items = new ArrayList<>();

    public Packet(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '[') {
                int countOpenBrackets = 1;
                int indexStart = i;
                while (countOpenBrackets > 0) {
                    i++;
                    if (line.charAt(i) == '[') {
                        countOpenBrackets++;
                    } else if (line.charAt(i) == ']') {
                        countOpenBrackets--;
                    }
                }
                Packet packetToAdd = new Packet(line.substring(indexStart + 1, i + 1));
                items.add(new Item(false, 0, packetToAdd));
            } else if (Character.isDigit(line.charAt(i))) {
                items.add(new Item(true, Integer.parseInt(String.valueOf(line.charAt(i))), null));
            }
        }
    }
}
