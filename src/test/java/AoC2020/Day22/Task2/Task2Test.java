package AoC2020.Day22.Task2;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

class Task2Test {

    @Test
    public void testPreventInfiniteRecursion() {
        Task2 testObject = new Task2();

        Deque<Integer> deck1 = new ArrayDeque<>();
        Deque<Integer> deck2 = new ArrayDeque<>();

        deck1.add(1);
        deck1.add(2);
        deck1.add(3);

        deck2.add(1);
        deck2.add(2);
        deck2.add(3);

        /*Deque<Integer> test1 = testObject.calculateWinner(deck1, deck2);
        Deque<Integer> test2 = testObject.calculateWinner(deck1, deck2);


        assertEquals(test1, null);
        assertEquals(test2, deck1);
    */
    }

}