package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/** Demonstrates the use of the iterator */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it = list.iterator(); // ArrayList has a method that returns an iterator
        while (it.hasNext()) { // checks if there is an element to "consume"
            int value = it.next(); //  returns the "next" element in the list and advances the iterator
            System.out.println(value);
        }
    }
}
