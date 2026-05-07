package sorting.binsort;

import java.util.Iterator;
import java.util.LinkedList;

public class BinSort {
    /**
     * Bin sort implementation -  add each element to the linked list
     * for the correct "bin", then use the array of bins to sort arr.
     * @param arr input array of records
     * @param maxValue largest value of the key; all keys are from 0 to maxValue.
     */
    public static void binSort(Elem[] arr, int maxValue) {
        int i;
        // Create bins
        LinkedList<Elem>[] bins = new LinkedList[maxValue + 1];
        // Create an empty linked list for each bin
        for (i = 0; i <= maxValue; i++)
            bins[i] = new LinkedList<Elem>();

        // Iterate over elements of arr, and add each element
        // to the linked list of the correct "bin"
        for (int j = 0; j < arr.length; j++) {
            Elem currElement = arr[j];
            int binIndex = currElement.getKey();
            LinkedList<Elem> llist = bins[binIndex];
            llist.add(currElement);
        }
        // Iterate over bins, and place elements from each linked
        // list back into arr
        int k = 0; // index in the resulting array
        // iterate over the bins array
        for (i = 0; i < bins.length; i++ ) {
            LinkedList<Elem> llist = bins[i];
            Iterator<Elem> it = llist.iterator();
            while (it.hasNext()) {
                Elem currElem = it.next();
                arr[k] = currElem;
                k++;
            }
        }

    }
}
