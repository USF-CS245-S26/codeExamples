package heaps;

public class MinHeapExample {

    public static void main(String[] args) {
        // Building the Min-Heap by inserting one element at a time
        MinHeap minheap = new MinHeap(7);
        minheap.insert(10);
        minheap.insert(2);
        minheap.insert(15);
        minheap.insert(7);
        minheap.insert(1);
        minheap.insert(4);
        minheap.print(); // 1 2 4 10 7 15
        System.out.println(minheap.removeMin());
        // minheap.print();

        /*
        // Building the heap from the bottom up
        int[] arr = { 8, 6, 14, 5, 3, 11, 15};
        MinHeap newHeap = new MinHeap(8);
        newHeap.buildBottomUp(arr);
        newHeap.print();
         */
    }
}
