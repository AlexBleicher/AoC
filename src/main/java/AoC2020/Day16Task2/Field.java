package AoC2020.Day16Task2;

import java.util.List;

public class Field {

    private String fieldName;
    private List<Integer> range;
    private int index;

    public Field(String fieldName, List<Integer> range) {
        this.fieldName = fieldName;
        this.range = range;
    }

    public String getFieldName() {
        return fieldName;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public boolean numberIsInRange(int number) {
        return (range.contains(number));
    }
}
