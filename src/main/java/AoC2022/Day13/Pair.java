package AoC2022.Day13;

public class Pair {

    private Packet leftThisPair;
    private Packet rightThisPair;

    public Pair(Packet left, Packet right) {
        this.leftThisPair = left;
        this.rightThisPair = right;
    }

    private int leftComesBeforeRight(Packet left, Packet right) { //0 check next step; 1 left comes first; 2 right should come first
        for (int i = 0; i < left.items.size(); i++) {
            //Right ran out of items first
            if (i > right.items.size() - 1) {
                return 2;
            }
            Item itemLeft = left.items.get(i);
            Item itemRight = right.items.get(i);
            if (itemLeft.isInt) {
                if (itemRight.isInt) {
                    if (itemLeft.value < itemRight.value) {
                        return 1;
                    } else if (itemLeft.value > itemRight.value) {
                        return 2;
                    }
                }
                //Turn left item into list and compare
                else {
                    int result = leftComesBeforeRight(new Packet("" + itemLeft.value), itemRight.valuePackage);
                    if (result == 1 || result == 2) {
                        return result;
                    }
                }
            } else {
                //Turn right item into list and compare
                if (itemRight.isInt) {
                    int result = leftComesBeforeRight(itemLeft.valuePackage, new Packet("" + itemRight.value));
                    if (result == 1 || result == 2) {
                        return result;
                    }
                }
                //Compare Packages
                else {
                    int result = leftComesBeforeRight(itemLeft.valuePackage, itemRight.valuePackage);
                    if (result == 1 || result == 2) {
                        return result;
                    }
                }
            }
        }
        if (left.items.size() < right.items.size()) {
            return 1;
        }
        return 0;
    }

    public boolean packetsInOrder() {
        boolean rightOrder = leftComesBeforeRight(leftThisPair, rightThisPair) == 1;
        return rightOrder;
    }
}
