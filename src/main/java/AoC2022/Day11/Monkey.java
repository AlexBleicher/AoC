package AoC2022.Day11;

import java.util.List;

public class Monkey {
    private List<Long> items;
    private boolean operationAdds;
    private int factor; //if factor is negative: Use the itemworrylevel itself
    private long factorTest;
    private int indexMonkeyTrue;
    private int indexMonkeyFalse;

    private int counter = 0;

    public Monkey(List<Long> items, boolean operationAdds, int factor, int factorTest, int indexMonkeyTrue, int indexMonkeyFalse) {
        this.items = items;
        this.operationAdds = operationAdds;
        this.factor = factor;
        this.factorTest = factorTest;
        this.indexMonkeyTrue = indexMonkeyTrue;
        this.indexMonkeyFalse = indexMonkeyFalse;
    }

    public List<Long> getItems() {
        return items;
    }

    public int getCounter() {
        return counter;
    }

    public int dealWithItem() {
        counter++;
        long item = items.get(0);
        long factorForOperation = factor;
        if (factor == -1) {
            factorForOperation = items.get(0);
        }
        if (operationAdds) {
            item += factorForOperation;
        } else {
            item *= factorForOperation;
        }
        item /= 3;
        items.set(0, item);
        if (items.get(0) % factorTest == 0) {
            return indexMonkeyTrue;
        } else {
            return indexMonkeyFalse;
        }
    }

    public long getFactorTest() {
        return factorTest;
    }

    public int dealWithItem2(long allDivisorMul) {
        counter++;
        long item = items.get(0);
        long factorForOperation = factor;
        if (factor == -1) {
            factorForOperation = items.get(0);
        }
        if (operationAdds) {
            item += factorForOperation;
        } else {
            item *= factorForOperation;
        }
        item = item % allDivisorMul;
        items.set(0, item);
        if (items.get(0) % factorTest == 0) {
            return indexMonkeyTrue;
        } else {
            return indexMonkeyFalse;
        }
    }
}
