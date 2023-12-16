package AoC2023.Day16;

import java.util.ArrayList;
import java.util.List;

public class Day16 {
    private Tile[][] map;

    public Day16(String i) {
        map = new Input(i).parseInput();
    }

    public long task1() {
        List<Beam> beamList = new ArrayList<>();
        beamList.add(new Beam(-1, 0, 'r'));
        return energize(beamList);
    }

    private long energize(List<Beam> beamList) {
        while (!beamList.isEmpty()) {
            List<Beam> toRemove = new ArrayList<>();
            List<Beam> toAdd = new ArrayList<>();
            for (Beam beam : beamList) {
                beam.move();
                if (beam.getCurrentX() > map[0].length - 1 || beam.getCurrentX() < 0 || beam.getCurrentY() < 0 || beam.getCurrentY() > map.length - 1) {
                    toRemove.add(beam);
                } else {
                    Tile tile = map[beam.getCurrentY()][beam.getCurrentX()];
                    if (tile.hasBeenVisitedFromDirection(beam.getDirection())) {
                        toRemove.add(beam);
                    } else {
                        tile.setEnergized(true);
                        tile.addVisitedDirection(beam.getDirection());
                        if (tile.getSymbol() == '/') {
                            if (beam.getDirection() == 'r') {
                                beam.setDirection('u');
                            } else if (beam.getDirection() == 'l') {
                                beam.setDirection('d');
                            } else if (beam.getDirection() == 'u') {
                                beam.setDirection('r');
                            } else if (beam.getDirection() == 'd') {
                                beam.setDirection('l');
                            }
                        } else if (tile.getSymbol() == '\\') {
                            if (beam.getDirection() == 'r') {
                                beam.setDirection('d');
                            } else if (beam.getDirection() == 'l') {
                                beam.setDirection('u');
                            } else if (beam.getDirection() == 'u') {
                                beam.setDirection('l');
                            } else if (beam.getDirection() == 'd') {
                                beam.setDirection('r');
                            }
                        } else if (tile.getSymbol() == '|') {
                            if (beam.getDirection() == 'l' || beam.getDirection() == 'r') {
                                toAdd.add(new Beam(beam.getCurrentX(), beam.getCurrentY(), 'u'));
                                beam.setDirection('d');
                            }
                        } else if (tile.getSymbol() == '-') {
                            if (beam.getDirection() == 'u' || beam.getDirection() == 'd') {
                                toAdd.add(new Beam(beam.getCurrentX(), beam.getCurrentY(), 'l'));
                                beam.setDirection('r');
                            }
                        }
                    }
                }
            }
            beamList.removeAll(toRemove);
            beamList.addAll(toAdd);
        }

        long countEnergized = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x].isEnergized()) {
                    countEnergized++;
                    map[y][x].setEnergized(false);
                    map[y][x].deletedVisitedFromDirection();
                }
            }
        }
        return countEnergized;
    }

    public long task2() {
        long res = -1;
        for (int x = 0; x < map[0].length - 1; x++) {

            List<Beam> beamList = new ArrayList<>();
            beamList.add(new Beam(x, -1, 'd'));
            long r = energize(beamList);
            if (res < r) {
                res = r;
            }
        }
        for (int x = 0; x < map[0].length - 1; x++) {

            List<Beam> beamList = new ArrayList<>();
            beamList.add(new Beam(x, map.length, 'u'));
            long r = energize(beamList);
            if (res < r) {
                res = r;
            }
        }
        for (int y = 0; y < map.length; y++) {
            List<Beam> beamList = new ArrayList<>();
            beamList.add(new Beam(-1, y, 'r'));
            long r = energize(beamList);
            if (res < r) {
                res = r;
            }
        }
        for (int y = 0; y < map.length; y++) {
            List<Beam> beamList = new ArrayList<>();
            beamList.add(new Beam(map[0].length, y, 'l'));
            long r = energize(beamList);
            if (res < r) {
                res = r;
            }
        }
        return res;
    }
}
