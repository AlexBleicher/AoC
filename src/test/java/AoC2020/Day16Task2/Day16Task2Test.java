package AoC2020.Day16Task2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day16Task2Test {

    @Test
    public void testDetermineFieldIndex() {
        List<Field> testFieldList = new ArrayList<>();
        List<Ticket> testTicketList = new ArrayList<>();

        Field f1 = new Field("Class", new ArrayList<>(Arrays.asList(0, 1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)));
        Field f2 = new Field("Row", new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)));
        Field f3 = new Field("Seat", new ArrayList<>(Arrays.asList(0, 1, 2, 3, 16, 17, 18, 19)));

        testFieldList.add(f1);
        testFieldList.add(f2);
        testFieldList.add(f3);

        Ticket t1 = new Ticket(new ArrayList<>(Arrays.asList(3, 9, 18)));
        Ticket t2 = new Ticket(new ArrayList<>(Arrays.asList(15, 1, 5)));
        Ticket t3 = new Ticket(new ArrayList<>(Arrays.asList(5, 14, 9)));
        Ticket t4 = new Ticket(new ArrayList<>(Arrays.asList(11, 12, 13)));
        testTicketList.add(t1);
        testTicketList.add(t2);
        testTicketList.add(t3);
        testTicketList.add(t4);

        for (Field field : testFieldList) {
            List<Integer> range = field.getRange();
            field.setIndex(0);
            for (int i = 0; i < testFieldList.size(); i++) {
                for (Ticket ticket : testTicketList) {
                    List<Integer> ticketValues = ticket.getValues();
                    int currentValue = ticketValues.get(i);
                    if (!range.contains(currentValue) && i != testFieldList.size() - 1) {
                        field.setIndex(i + 1);
                    }
                }
            }
        }


        System.out.println(f1.getIndex());
        System.out.println(f2.getIndex());
        System.out.println(f3.getIndex());

        assert (f1.getIndex() == 1 && f2.getIndex() == 0 && f3.getIndex() == 2);
    }

    /*
    class: 0-1 or 4-19
row: 0-5 or 8-19
seat: 0-13 or 16-19

your ticket:
11,12,13

nearby tickets:
3,9,18
15,1,5
5,14,9
     */

}