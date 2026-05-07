package sorting.mergesort;

import java.util.Arrays;

import static sorting.mergesort.MergeSort.mergeSort;

public class MergeSortMain {
    public static void main(String[] args) {
        //int[] arr = {1, 6, 8, 10, 100, 2, 4, 9, 14};
        int[] arr = {17, 10, 15, 13, 4, 12, 7, 9, 16, 8, 5, 14, 3 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
