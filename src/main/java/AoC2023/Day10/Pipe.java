package AoC2023.Day10;

public class Pipe {

    private Pipe north = null;
    private Pipe south = null;
    private Pipe east = null;
    private Pipe west = null;
    private char form;
    private boolean isOnLoop = false;

    public Pipe(char form) {
        this.form = form;
    }

    public boolean isOnLoop() {
        return isOnLoop;
    }

    public void setOnLoop(boolean onLoop) {
        isOnLoop = onLoop;
    }

    public Pipe getNorth() {
        return north;
    }

    public void setNorth(Pipe north) {
        this.north = north;
    }

    public Pipe getSouth() {
        return south;
    }

    public void setSouth(Pipe south) {
        this.south = south;
    }

    public Pipe getEast() {
        return east;
    }

    public void setEast(Pipe east) {
        this.east = east;
    }

    public Pipe getWest() {
        return west;
    }

    public void setWest(Pipe west) {
        this.west = west;
    }

    public char getForm() {
        return form;
    }

    public void setForm(char form) {
        this.form = form;
    }

    public Pipe travelForm(Pipe lastPipe) {
        if (form == '|') {
            if (lastPipe == north) {
                return south;
            } else if (lastPipe == south) {
                return north;
            }
        }
        if (form == '-') {
            if (lastPipe == east) {
                return west;
            } else if (lastPipe == west) {
                return east;
            }
        }
        if (form == 'L') {
            if (lastPipe == north) {
                return east;
            } else if (lastPipe == east) {
                return north;
            }
        }
        if (form == 'J') {
            if (lastPipe == north) {
                return west;
            } else if (lastPipe == west) {
                return north;
            }
        }
        if (form == '7') {
            if (lastPipe == south) {
                return west;
            } else if (lastPipe == west) {
                return south;
            }
        }
        if (form == 'F') {
            if (lastPipe == south) {
                return east;
            } else if (lastPipe == east) {
                return south;
            }
        }
        return null;
    }

}
