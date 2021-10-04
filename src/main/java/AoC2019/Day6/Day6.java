package AoC2019.Day6;

import java.util.ArrayList;

public class Day6 {

    private ArrayList<SpaceObject> allSpaceObjects = new ArrayList<>();

    public Day6(String input) {
        ArrayList<String[]> transformedInput = new Input(input).transformInput();
        generateObjects(transformedInput);
        addDirectOrbits(transformedInput);
    }

    private void generateObjects(ArrayList<String[]> transformedInput) {
        for (String[] strings : transformedInput) {
            SpaceObject object1 = new SpaceObject(strings[0]);
            SpaceObject object2 = new SpaceObject(strings[1]);
            if (!allSpaceObjects.contains(object1)) {
                allSpaceObjects.add(object1);
            }
            if (!allSpaceObjects.contains(object2)) {
                allSpaceObjects.add(object2);
            }
        }
    }

    private void addDirectOrbits(ArrayList<String[]> transformedInput) {
        for (String[] strings : transformedInput) {
            SpaceObject spaceObject = allSpaceObjects.get(allSpaceObjects.indexOf(new SpaceObject(strings[1])));
            SpaceObject directOrbit = allSpaceObjects.get(allSpaceObjects.indexOf(new SpaceObject(strings[0])));
            spaceObject.setDirectOrbit(directOrbit);
        }
    }

    public long task1() {
        long totalAmountOfOrbits = 0;
        for (SpaceObject spaceObject : allSpaceObjects) {
            totalAmountOfOrbits += spaceObject.getTotalAmountOfOrbits();
        }
        return totalAmountOfOrbits;
    }

}
