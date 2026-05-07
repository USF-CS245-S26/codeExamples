package sorting.quicksort;

import java.util.Arrays;

public class QuickSort {

    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int arr[]) {
       quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Sort the given subarray from index low to index high (inclusive) with quick sort.
     * @param arr
     * @param low
     * @param high
     */
    static void quickSort(int arr[], int low, int high) {
        int pivotIndex;
        if (low < high) {
            pivotIndex = partition(arr, low, high);
            System.out.println(Arrays.toString(arr));
            System.out.println("Used pivot " + arr[pivotIndex]);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /** Partition a subarray from index low to index high (inclusive)
     *
     * @param arr input array
     * @param low starting index of the subarray
     * @param high end index of the subarray
     * @return index of the pivot after the partition
     */
    public static int partition(int arr[], int low, int high) {
        int midIndex = (low + high) / 2;
        int pivotElement = arr[midIndex];
        int i = low;
        int j = high - 1;

        // Swap the pivot with the last element in the given chunk
        swap(midIndex, high, arr);

        // Move i and j
        while (i <= j) {
            while (i <= j  && arr[i] < pivotElement) {
                i++;
            }
            while (i <= j  && arr[j] >= pivotElement) {
                j--;
            }
            if (i < j) {
                swap(i, j, arr);
                i++;
                j--;
            }

        }
        // swap the pivot with the element at index i
        swap(i, high, arr);

        return i; // returning the index of the pivotElement
    }

}
