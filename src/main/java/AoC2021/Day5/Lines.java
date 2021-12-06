package AoC2021.Day5;

import java.util.ArrayList;

public class Lines {

    public ArrayList<Coordinate> stretch = new ArrayList<>();

    public Lines(int startX, int startY, int endX, int endY) {
        if(startX == endX || startY == endY){
            addHorizontalOrVertical(startX, startY, endX, endY);
        } else{
            addDiagonal(startX, startY, endX, endY);
        }
    }
    private void addHorizontalOrVertical(int startX, int startY, int endX, int endY){
        if (startX == endX) {
            if (startY < endY) {
                for (int i = startY; i <= endY; i++) {
                    stretch.add(new Coordinate(startX, i));
                }
            } else {
                for (int i = endY; i <= startY; i++) {
                    stretch.add(new Coordinate(startX, i));
                }
            }
        } else if(startY == endY){
            if (startX < endX) {
                for (int i = startX; i <= endX; i++) {
                    stretch.add(new Coordinate(i, startY));
                }
            } else {
                for (int i = endX; i <= startX; i++) {
                    stretch.add(new Coordinate(i, startY));
                }
            }
        }
    }

    private void addDiagonal(int startX, int startY, int endX, int endY){
        if(startX < endX && startY < endY){
            for(int i=0; i<=(endX-startX); i++){
                stretch.add(new Coordinate(startX+i, startY+i));
            }
        } else if(startX < endX && startY > endY){
            for(int i=0; i<=(endX-startX); i++){
                stretch.add(new Coordinate(startX+i, startY -i));
            }
        } else if(startX > endX && startY < endY){
            for(int i=0; i<=(startX-endX); i++){
                stretch.add(new Coordinate(startX-i, startY+i));
            }
        } else if(startX> endX && startY > endY){
            for(int i=0; i<= (startX-endX); i++){
                stretch.add(new Coordinate(startX-i, startY-i));
            }
        }
    }

    public ArrayList<Coordinate> getStretch() {
        return stretch;
    }
}
