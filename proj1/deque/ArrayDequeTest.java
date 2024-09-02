package deque;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;

import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
/*
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
*/
    }

    @Test
    public void bigLLDequeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addFirst(i);
        }
        System.out.println(lld1.get(0));


        for (double i = 0; i < 500000; i++) {
            //System.out.println(i);
            //System.out.println(lld1.removeFirst());
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }


    }

    @Test
    public void EqualsTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addFirst(i);
        }
        boolean b = ad1.equals(null);

    }

    @Test
    public void IteratorTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addFirst(i);
        }
        Iterator it = ad1.iterator();
        while(it.hasNext()) {
            Object i = it.next();
            System.out.println(i);
        }
        boolean b = it.hasNext();

    }




}
