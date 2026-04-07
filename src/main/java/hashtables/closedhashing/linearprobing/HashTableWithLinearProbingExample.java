package hashtables.closedhashing.linearprobing;

public class HashTableWithLinearProbingExample {
    public static void main(String[] args) {
            HashTableWithLinearProbing ht = new HashTableWithLinearProbing(7);
            ht.insert(2, "data2");
            ht.insert(5, "data5");
            ht.insert(0, "data0");
            ht.insert(9, "data9");
            ht.insert(3, "data3");
            ht.insert(16, "data16");
            ht.insert(17, "data17");
            //ht.insert(10, "data10");

            ht.printTable();
             /*
             0  1   2  3  4  5  6
             0  17  2  9  3  5  16

            */

            System.out.println(ht.contains(3)); // true
            System.out.println(ht.contains(17)); // true
            System.out.println(ht.contains(100)); //false

    }
}
