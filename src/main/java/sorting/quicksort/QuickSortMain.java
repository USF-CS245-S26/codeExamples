package sorting.quicksort;

import java.util.Arrays;

import static sorting.quicksort.QuickSort.quickSort;

public class QuickSortMain {
    public static void main(String[] args) {
        int[] arr2 = {5, 9, 0, 1, 12, 6, 20, 4, 10, 3, 45};
        System.out.println(Arrays.toString(arr2));
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
