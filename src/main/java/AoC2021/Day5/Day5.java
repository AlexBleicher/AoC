package AoC2021.Day5;

import java.util.ArrayList;

public class Day5 {

    private ArrayList<Lines> lines;
    private ArrayList<Coordinate> overLappingLines = new ArrayList<>();

    public Day5(String input) {
        lines = new Input(input).splitInput();
    }

    public int task1(){
        findOverlappingLinesWithoutVerticals();
        return overLappingLines.size();
    }

    public void findOverlappingLinesWithoutVerticals(){
        for (int i=0; i<lines.size()-1; i++) {
            Lines line = lines.get(i);
            ArrayList<Coordinate> currentStretch = line.getStretch();
            for(int j=i+1; j<lines.size(); j++){
                Lines lineInCheck = lines.get(j);
                for (Coordinate coordinate : currentStretch) {
                    if(lineInCheck.getStretch().contains(coordinate) && !overLappingLines.contains(coordinate)){
                        overLappingLines.add(coordinate);
                    }
                }
            }
        }
    }
}
