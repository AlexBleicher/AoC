package AoC2019.Day6;

import java.util.ArrayList;

public class Object {

    private String name;
    private ArrayList<Object> orbitList = new ArrayList<>();

    public Object(String name) {
        this.name = name;
    }

    public void addOrbits(Object directOrbit) {
        orbitList.add(directOrbit);
        orbitList.addAll(directOrbit.getOrbitList());
    }

    public ArrayList<Object> getOrbitList() {
        return orbitList;
    }

    public String getName() {
        return name;
    }
}
