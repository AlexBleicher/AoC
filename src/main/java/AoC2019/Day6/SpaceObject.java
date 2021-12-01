package AoC2019.Day6;

import java.util.Objects;

public class SpaceObject {

    private String name;
    private SpaceObject directOrbit;

    public SpaceObject(String name) {
        this.name = name;
    }

    public void setDirectOrbit(SpaceObject directOrbit) {
        this.directOrbit = directOrbit;
    }

    public long getTotalAmountOfOrbits() {
        if (this.name.equals("COM")) {
            return 0;
        }
        return 1 + directOrbit.getTotalAmountOfOrbits();
    }

    public SpaceObject getDirectOrbit() {
        return directOrbit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceObject spaceObject = (SpaceObject) o;
        return Objects.equals(name, spaceObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
