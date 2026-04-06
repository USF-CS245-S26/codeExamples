package hashtables.openhashing;

public class HashTableExample {
    public static void main(String[] args) {
            HashTable ht = new HashTable(7);
            ht.insert(15);
            ht.insert(25);
            ht.insert(35);
            ht.insert(5);
            ht.insert(0);
            ht.insert(8);
            ht.insert(12);
            ht.printTable();

            System.out.println("Contains 25? " + ht.contains(25));
            System.out.println("Contains 100? " + ht.contains(100));

    }
}
