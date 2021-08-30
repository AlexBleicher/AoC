package AoC2020.Day20.Task1;

import java.util.List;

public class Image {

    private int id;
    private String picture;
    private Image neighborTop;
    private Image neighborLeft;
    private Image neighborBottom;
    private Image neighborRight;
    private boolean locked = false;

    public Image(int id, String picture) {
        this.id = id;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public void turn() {
        String turnedPicture = "";
        String[] allLines = picture.split("\n");
        for (int i = allLines.length - 1; i >= 0; i--) {
            String line = allLines[i];
            for (int j = line.length() - 1; j >= 0; j--) {
                turnedPicture += line.charAt(j);
            }
            turnedPicture += "\n";
        }
        picture = turnedPicture;
    }

    public void flip() {
        String flipedPicture = "";
        String[] allLines = picture.split("\n");
        for (String line : allLines) {
            for (int i = line.length() - 1; i >= 0; i--) {
                flipedPicture += line.charAt(i);
            }
            flipedPicture += "\n";
        }
        picture = flipedPicture;
    }

    public boolean fitsEdge(String thisEdge, String otherEdge) {
        for (int i = 0; i < thisEdge.length(); i++) {
            if (thisEdge.charAt(i) != otherEdge.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String getRightEdge() {
        String rightEdge = "";
        String[] allLines = picture.split("\n");
        for (String line : allLines) {
            rightEdge += line.charAt(line.length() - 1);
        }
        return rightEdge;
    }

    public String getLeftEdge() {
        String leftEdge = "";
        String[] allLines = picture.split("\n");
        for (String line : allLines) {
            leftEdge += line.charAt(0);
        }
        return leftEdge;
    }

    public void lockImage(List<Image> possibleNeighbors) {
        String rightEdge = getRightEdge();
        for (Image possibleNeighbor : possibleNeighbors) {
            locked = fitsEdge(rightEdge, possibleNeighbor.getRightEdge());
            if (locked) {
                possibleNeighbor.setLocked(true);
                possibleNeighbor.setNeighborLeft(this);
                neighborRight = possibleNeighbor;
                return;
            } else {
                possibleNeighbor.flip();
            }

        }
    }

    public void setNeighborLeft(Image neighborLeft) {
        this.neighborLeft = neighborLeft;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
