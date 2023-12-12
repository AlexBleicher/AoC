package AoC2023.Day12;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Gear> gears = new ArrayList<>();
    private List<Integer> damagedGroups = new ArrayList<>();

    public Row(String gearsString, String groupsString) {
        for (int i = 0; i < gearsString.length(); i++) {
            gears.add(new Gear(gearsString.charAt(i)));
        }
        String[] split = groupsString.split(",");
        for (String s : split) {
            damagedGroups.add(Integer.parseInt(s));
        }
    }

    public List<List<Gear>> getPossibleArrangements(List<Gear> gearsGiven) {
        List<List<Gear>> possibleArrangements = new ArrayList<>();

        List<Gear> conitousGroup = new ArrayList<>();
        int indexOfGroups = 0;
        boolean isPossible = true;
        for (int i = 0; i < gearsGiven.size() && isPossible; i++) {
            Gear gear = gearsGiven.get(i);
            if (gear.getStatus() == '#') {
                conitousGroup.add(gear);
            } else if (gear.getStatus() == '.') {
                if (!conitousGroup.isEmpty()) {
                    isPossible = damagedGroups.get(indexOfGroups++) == conitousGroup.size();
                    conitousGroup = new ArrayList<>();
                }
            } else {
                gear.setStatus('#');
                possibleArrangements.addAll(getPossibleArrangements(gearsGiven));
                gear.setStatus('.');
                possibleArrangements.addAll(getPossibleArrangements(gearsGiven));
            }
        }
        if (indexOfGroups == damagedGroups.size() - 1) {
            isPossible = conitousGroup.size() == damagedGroups.get(indexOfGroups);
        }
        if (isPossible) {
            possibleArrangements.add(gearsGiven);
        }
        return possibleArrangements;
    }

    public List<Gear> getGears() {
        return gears;
    }
}
