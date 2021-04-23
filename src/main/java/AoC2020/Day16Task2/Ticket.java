package AoC2020.Day16Task2;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private List<Integer> values = new ArrayList<>();
    //private Set<Field> fieldNames = new HashSet<>();

    public Ticket(List<Integer> values) {
        this.values = values;
    }

    public List<Integer> getValues() {
        return values;
    }
}

