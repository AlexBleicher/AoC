package AoC2024.Day12;

import java.util.*;
import java.util.stream.Collectors;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    /*public List<Region> parseInput(){
        String[] split = input.split("\n");
        List<Region> regions = new ArrayList<>();
        for (int y = 0; y < split.length; y++) {
            String s = split[y];
            List<Position> letterBlock = new ArrayList<>();
            int x =0;
            char currentLetter = s.charAt(0);
            while(x<s.length()){
                char l = s.charAt(x);
                if(l==currentLetter){
                    Position p = new Position(x,y);
                    letterBlock.add(p);
                }
                else{
                    boolean hasBeenInserted = false;
                    for (Region region : regions) {
                        if(region.getLetter()==currentLetter){
                            boolean shouldBeInserted = false;
                            for (Position position : letterBlock) {
                                if(region.checkIfBelongsToPosition(position)){
                                    shouldBeInserted=true;
                                }
                            }
                            if(shouldBeInserted){
                                for (Position position : letterBlock) {
                                    region.addPosition(position);
                                    hasBeenInserted = true;
                                }
                            }
                        }
                    }
                    if(!hasBeenInserted){
                        Region region = new Region(currentLetter);
                        for (Position position : letterBlock) {
                            region.addPosition(position);
                        }
                        regions.add(region);
                    }
                    currentLetter = l;
                    letterBlock = new ArrayList<>();
                    letterBlock.add(new Position(x,y));
                }
                x++;
            }
            boolean hasBeenInserted = false;
            for (Region region : regions) {
                if(region.getLetter()==currentLetter){
                    boolean shouldBeInserted = false;
                    for (Position position : letterBlock) {
                        if(region.checkIfBelongsToPosition(position)){
                            shouldBeInserted=true;
                        }
                    }
                    if(shouldBeInserted){
                        for (Position position : letterBlock) {
                            region.addPosition(position);
                        }
                    }
                    hasBeenInserted = true;
                }
            }
            if(!hasBeenInserted){
                Region region = new Region(currentLetter);
                for (Position position : letterBlock) {
                    region.addPosition(position);
                }
                regions.add(region);
            }

        }

        return regions;
    }*/

    public List<Region> parseInput() {
        String[] split = input.split("\n");
        List<Region> res = new ArrayList<>();
        List<Position> allPos = new ArrayList<>();
        Set<Character> allLetters = new HashSet<>();
        for (int y = 0; y < split.length; y++) {
            String s = split[y];
            for (int x = 0; x < s.length(); x++) {
                allPos.add(new Position(x, y, s.charAt(x)));
                allLetters.add(s.charAt(x));
            }
        }
        for (Position allPo : allPos) {
            for (Position po : allPos) {
                if (po.getX() == allPo.getX() - 1 && po.getY() == allPo.getY()) {
                    allPo.addToNeighbors(po);
                }
                if (po.getX() == allPo.getX() + 1 && po.getY() == allPo.getY()) {
                    allPo.addToNeighbors(po);
                }
                if (po.getX() == allPo.getX() && po.getY() == allPo.getY() - 1) {
                    allPo.addToNeighbors(po);
                }
                if (po.getX() == allPo.getX() && po.getY() == allPo.getY() + 1) {
                    allPo.addToNeighbors(po);
                }
            }
        }

        for (Character letter : allLetters) {
            List<Position> allPosWithLetter = allPos.stream().filter(position -> position.getLetter() == letter).collect(Collectors.toList());
            while (!allPosWithLetter.isEmpty()) {
                List<Position> queue = new LinkedList<>();
                allPosWithLetter.get(0).setVisited(true);
                queue.add(allPosWithLetter.get(0));
                List<Position> allInRegion = new ArrayList<>();
                while (!queue.isEmpty()) {
                    Position current = queue.remove(0);
                    allInRegion.add(current);
                    List<Position> neighbors = current.getNeighbors();
                    for (Position neighbor : neighbors) {
                        if (!neighbor.isVisited() && neighbor.getLetter() == current.getLetter()) {
                            neighbor.setVisited(true);
                            queue.add(neighbor);
                        }
                    }
                }
                allPosWithLetter = allPosWithLetter.stream().filter(position -> !allInRegion.contains(position)).toList();
                Region region = new Region(letter);
                region.addAllPositions(allInRegion);
                res.add(region);
            }
        }

        return res;
    }
}
