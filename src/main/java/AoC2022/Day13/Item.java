package AoC2022.Day13;

public class Item {

    public boolean isInt;
    public int value;
    public Packet valuePackage;

    public Item(boolean isInt, int value, Packet valuePackage) {
        this.isInt = isInt;
        this.value = value;
        this.valuePackage = valuePackage;
    }
}
