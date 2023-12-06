package AoC2023.Day6;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String in;

    public Input(String i) {
        in = i;
    }

    public List<Race> parseInput() {
        String[] split = in.split("\n");
        List<Race> res = new ArrayList<>();
        String[] lineTime = split[0].split(" ");
        String[] lineDistance = split[1].split(" ");
        List<Integer> indexesAlreadyTaken = new ArrayList<>();
        for (int i = 1; i < lineDistance.length; i++) {
            String substringDistance = lineDistance[i];
            if (!substringDistance.isEmpty()) {
                boolean found = false;
                for (int i1 = i; i1 < lineTime.length; i1++) {
                    String substringTime = lineTime[i1];
                    if (!found && !substringTime.isEmpty() && !indexesAlreadyTaken.contains(i1)) {
                        res.add(new Race(Integer.parseInt(substringTime), Integer.parseInt(substringDistance)));
                        found = true;
                        indexesAlreadyTaken.add(i1);
                    }
                }
            }
        }
        return res;
    }

    public Race parseInput2() {
        String[] split = in.split("\n");
        String[] lineTime = split[0].split(" ");
        String[] lineDistance = split[1].split(" ");
        String totalTime = "";
        String totalDistance = "";
        for (int i = 1; i < lineTime.length; i++) {
            if (!lineTime[i].isEmpty()) {
                totalTime += lineTime[i];
            }
        }
        for (int i = 1; i < lineDistance.length; i++) {
            if (!lineDistance[i].isEmpty()) {
                totalDistance += lineDistance[i];
            }
        }
        return new Race(Long.parseLong(totalTime), Long.parseLong(totalDistance));
    }
}
