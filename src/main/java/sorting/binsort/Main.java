package sorting.binsort;


import java.util.Arrays;

import static sorting.binsort.BinSort.binSort;

public class Main {
    public static void main(String[] args) {
        Elem[] records = {
                new Elem(6, "red"),
                new Elem(1, "blue"),
                new Elem(6, "yellow"),
                new Elem(2, "black"),
                new Elem(1, "brown"),
                new Elem(6, "orange"),
                new Elem(0, "green"),
                new Elem(6, "gray")};
        binSort(records, 6);
        System.out.println(Arrays.toString(records));
    }

}
