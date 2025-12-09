package AoC2025.Day9;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 {

    private List<RedTile> tiles;

    public Day9(String i) {
        tiles = new Input(i).parseInput();
    }

    public long task1() {
        long res;
        long largest = 0;
        for (int i = 0; i < tiles.size(); i++) {
            RedTile tile1 = tiles.get(i);
            for (int i1 = i + 1; i1 < tiles.size(); i1++) {
                RedTile tile2 = tiles.get(i1);
                long area = tile1.calcArea(tile2);
                if (area > largest) {
                    largest = area;
                }
            }
        }
        res = largest;
        return res;
    }

    public long task2() {
        Set<RedTile> greenTiles = new HashSet<>();
        for (int i = 1; i < tiles.size() - 1; i++) {
            RedTile tileBefore = tiles.get(i - 1);
            RedTile tile = tiles.get(i);
            createGreenTiles(greenTiles, tileBefore, tile);
        }
        RedTile tileBefore = tiles.get(tiles.size() - 1);
        RedTile tile = tiles.get(0);
        createGreenTiles(greenTiles, tileBefore, tile);
        List<RedTile> listSortedY = tiles.stream().sorted(Comparator.comparingInt(RedTile::getY)).toList();
        List<RedTile> listSortedX = tiles.stream().sorted(Comparator.comparingInt(RedTile::getX)).toList();
        for (int y = listSortedY.get(0).getY(); y < listSortedY.get(listSortedY.size() - 1).getY(); y++) {
            boolean leftBorder = false;
            for (int x = listSortedX.get(0).getX(); x < listSortedX.get(listSortedX.size() - 1).getX(); x++) {
                RedTile t = new RedTile();
                t.setX(x);
                t.setY(y);
                if (greenTiles.contains(t)) {
                    leftBorder = !leftBorder;
                }
                if (leftBorder) {
                    greenTiles.add(t);
                }
            }
        }
        /*for (int y = listSortedY.get(0).getY()-2; y < listSortedY.get(listSortedY.size()-1).getY()+2; y++) {
            for (int x = listSortedX.get(0).getX()-2; x < listSortedX.get(listSortedX.size()-1).getX()+2; x++) {
                RedTile t = new RedTile();
                t.setX(x);
                t.setY(y);
                if(greenTiles.contains(t)){
                    System.out.println("X");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }*/
        long largest = 0;
        for (int i = 0; i < tiles.size(); i++) {
            RedTile tile1 = tiles.get(i);
            for (int i1 = i + 1; i1 < tiles.size(); i1++) {
                RedTile tile2 = tiles.get(i1);
                boolean possible = true;
                int upperY = Math.min(tile1.getY(), tile2.getY());
                for (int j = Math.min(tile1.getX(), tile2.getX()); j < Math.max(tile1.getX(), tile2.getX()) && possible; j++) {
                    RedTile t = new RedTile();
                    t.setX(j);
                    t.setY(upperY);
                    if (!greenTiles.contains(t)) {
                        possible = false;
                    }
                }
                int lowerY = Math.max(tile1.getY(), tile2.getY());
                for (int j = Math.min(tile1.getX(), tile2.getX()); j < Math.max(tile1.getX(), tile2.getX()) && possible; j++) {
                    RedTile t = new RedTile();
                    t.setX(j);
                    t.setY(lowerY);
                    if (!greenTiles.contains(t)) {
                        possible = false;
                    }
                }
                int leftX = Math.min(tile1.getX(), tile2.getX());
                for (int j = Math.min(tile1.getY(), tile2.getY()); j < Math.max(tile1.getY(), tile2.getY()) && possible; j++) {
                    RedTile t = new RedTile();
                    t.setY(j);
                    t.setX(leftX);
                    if (!greenTiles.contains(t)) {
                        possible = false;
                    }
                }
                int rightX = Math.max(tile1.getX(), tile2.getX());
                for (int j = Math.min(tile1.getY(), tile2.getY()); j < Math.max(tile1.getY(), tile2.getY()) && possible; j++) {
                    RedTile t = new RedTile();
                    t.setY(j);
                    t.setX(rightX);
                    if (!greenTiles.contains(t)) {
                        possible = false;
                    }
                }
                if (possible) {
                    long area = tile1.calcArea(tile2);
                    if (area > largest) {
                        largest = area;
                    }
                }
            }
        }
        return largest;
    }

    private void createGreenTiles(Set<RedTile> greenTiles, RedTile tileBefore, RedTile tile) {
        if (tile.getX() == tileBefore.getX()) {
            for (int j = Math.min(tileBefore.getY(), tile.getY()); j < Math.max(tileBefore.getY(), tile.getY()); j++) {
                RedTile g = new RedTile();
                g.setX(tileBefore.getX());
                g.setY(j);
                greenTiles.add(g);
            }
        } else if (tile.getY() == tileBefore.getY()) {
            for (int j = Math.min(tileBefore.getX(), tile.getX()); j < Math.max(tileBefore.getX(), tile.getX()); j++) {
                RedTile g = new RedTile();
                g.setY(tileBefore.getY());
                g.setX(j);
                greenTiles.add(g);
            }
        }
    }
}
