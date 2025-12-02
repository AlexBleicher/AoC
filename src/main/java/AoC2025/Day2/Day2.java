package AoC2025.Day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private List<List<Long>> idRanges;

    public Day2(String i) {
        idRanges = new Input(i).parseInput();
    }

    public long task1() {
        List<Long> invalidIDs = new ArrayList<>();
        for (List<Long> idRange : idRanges) {
            for (Long l : idRange) {
                String string = l.toString();
                String substring1 = string.substring(0, string.length() / 2);
                String substring2 = string.substring(string.length() / 2);
                boolean possiblyInvalid = true;
                if (substring1.length() != substring2.length()) {
                    possiblyInvalid = false;
                } else {
                    for (int i = 0; i < substring1.length() && possiblyInvalid; i++) {
                        if (substring2.charAt(i) != substring1.charAt(i)) {
                            possiblyInvalid = false;
                        }
                    }
                }
                if (possiblyInvalid) {
                    invalidIDs.add(l);
                }
            }
        }
        return invalidIDs.stream().mapToLong(Long::longValue).sum();
    }
}
