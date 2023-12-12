package AoC2023.Day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Row(List<Gear> g, List<Integer> n) {
        gears = g;
        damagedGroups = n;
    }

    public List<Gear> getGears() {
        return gears;
    }

    public Set<String> getPossibleArrangements(List<Gear> gearsGiven, Set<String> alreadyLookedAt) {
        Set<String> possibleArrangements = new HashSet<>();
        List<Gear> copiedGears1 = new ArrayList<>();
        for (Gear gear : gearsGiven) {
            copiedGears1.add(new Gear(gear.getStatus()));
        }
        List<Gear> copiedGears2 = new ArrayList<>();
        for (Gear gear : gearsGiven) {
            copiedGears2.add(new Gear(gear.getStatus()));
        }
        List<Gear> continousGroup = new ArrayList<>();
        boolean isPossible = true;
        int indexOfGroups = 0;
        for (int i = 0; i < gearsGiven.size() && isPossible; i++) {
            Gear gear = gearsGiven.get(i);
            if (gear.getStatus() == '#') {
                continousGroup.add(gear);
                if (indexOfGroups > damagedGroups.size() - 1) {
                    isPossible = false;
                }
            } else if (gear.getStatus() == '.') {
                if (!continousGroup.isEmpty()) {
                    isPossible = damagedGroups.get(indexOfGroups++) == continousGroup.size();
                    continousGroup = new ArrayList<>();
                }
            } else {
                Gear copiedGear = copiedGears1.get(i);
                copiedGear.setStatus('#');
                String t = "";
                for (Gear gear1 : copiedGears1) {
                    t += gear1.getStatus();
                }
                if (!alreadyLookedAt.contains(t)) {
                    possibleArrangements.addAll(getPossibleArrangements(copiedGears1, alreadyLookedAt));
                    alreadyLookedAt.add(t);
                }
                t = "";
                copiedGear = copiedGears2.get(i);
                copiedGear.setStatus('.');
                for (Gear gear1 : copiedGears2) {
                    t += gear1.getStatus();
                }
                if (!alreadyLookedAt.contains(t)) {
                    possibleArrangements.addAll(getPossibleArrangements(copiedGears2, alreadyLookedAt));
                    alreadyLookedAt.add(t);
                }
            }
        }
        if (indexOfGroups == damagedGroups.size() - 1) {
            isPossible = continousGroup.size() == damagedGroups.get(indexOfGroups);
        } else if (indexOfGroups < damagedGroups.size()) {
            isPossible = false;
        }
        for (Gear gear : gearsGiven) {
            if (gear.getStatus() == '?') {
                isPossible = false;
            }
        }
        if (isPossible) {
            String t = "";
            for (Gear gear : gearsGiven) {
                t += gear.getStatus();
            }
            possibleArrangements.add(t);
        }

        return possibleArrangements;
    }

    public List<Integer> getDamagedGroups() {
        return damagedGroups;
    }
}
