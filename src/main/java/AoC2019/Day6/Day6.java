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

    public int calculateShortestWayToSanta(SpaceObject startObject, SpaceObject goalObject) {
        int amountOfShortestSteps = -1;
        int stepsNeeded = 0;
        ArrayList<SpaceObject> allPossibleTransfers = getAllPossibleTransfers(startObject);
        if (allPossibleTransfers.size() != 0) {
            {
                for (SpaceObject possibleTransfer : allPossibleTransfers) {
                    if (possibleTransfer.equals(goalObject)) {
                        return stepsNeeded;
                    }
                    stepsNeeded = 1 + calculateShortestWayToSanta(possibleTransfer, goalObject);
                    if (amountOfShortestSteps == -1) {
                        amountOfShortestSteps = stepsNeeded;
                    } else if (amountOfShortestSteps > stepsNeeded) {
                        amountOfShortestSteps = stepsNeeded;
                    }
                }
            }
        }
        return amountOfShortestSteps;
    }

    private ArrayList<SpaceObject> getAllPossibleTransfers(SpaceObject startObject) {
        ArrayList<SpaceObject> allPossibleTransfers = new ArrayList<>();
        if (startObject.getDirectOrbit() != null) {
            allPossibleTransfers.add(startObject.getDirectOrbit());
        }
        for (SpaceObject spaceObject : allSpaceObjects) {
            if (spaceObject.getDirectOrbit() != null && spaceObject.getDirectOrbit().equals(startObject)) {
                allPossibleTransfers.add(spaceObject);
            }
        }
        return allPossibleTransfers;
    }

    public long task1() {
        long totalAmountOfOrbits = 0;
        for (SpaceObject spaceObject : allSpaceObjects) {
            totalAmountOfOrbits += spaceObject.getTotalAmountOfOrbits();
        }
        return totalAmountOfOrbits;
    }

    public int task2() {
        SpaceObject start = allSpaceObjects.get(allSpaceObjects.indexOf(new SpaceObject("YOU"))).getDirectOrbit();
        SpaceObject goal = allSpaceObjects.get(allSpaceObjects.indexOf(new SpaceObject("SAN"))).getDirectOrbit();
        return calculateShortestWayToSanta(start, goal);
    }
}
