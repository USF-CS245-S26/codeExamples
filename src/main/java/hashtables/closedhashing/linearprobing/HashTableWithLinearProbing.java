package hashtables.closedhashing.linearprobing;

// Implementing a Hash Table using closed hashing with linear probing. Does not support deletion.
public class HashTableWithLinearProbing {
    private HashEntry[] table;
    private int capacity;

    /**
     * A nested class representing one element  (one entry) in the hash table
     */
    private static class HashEntry {
        int key;
        Object value;

        HashEntry(int key, Object value) {
            this.key  = key;
            this.value = value;
        }
    }

    /**
     * Constructor
     * @param size max capacity
     */
    public HashTableWithLinearProbing(int size){
        table = new HashEntry[size];
        capacity = size;
    }

    /** Returns the hash value for a given key
     *
     * @param key key
     * @return index in table
     */
    public int hash(int key){
        if (key < 0)
            throw new IllegalArgumentException();
        return key % capacity;
    }

    /**
     * Inserts a new HashElem with the given key and entry to the hash table
     * @param key key
     * @param value value
     */
    public void insert(int key, Object value){
        // Create a new hash entry with the key and the value
        // Compute the hash function for the key to find the index in the array
        // If this index is available, add the new entry there
        // Otherwise "probe" index+1, index+2 ... (in a circular fashion) to find an available spot
        HashEntry entry = new HashEntry(key, value);
        int index = hash(key);
        int count = 0;
        while(table[index] != null && count < capacity) {
            index = (index + 1) % capacity;
            count++;
        }
        if (count == capacity){
            System.out.println("Hash table is full");
            throw new IllegalStateException();
        }
        table[index] = entry;


    }

    /**
     * Return true if the given key is present in the hash table
     * @param key key
     * @return value
     */
    public boolean contains(int key) {
        int index = hash(key);
        // Check the key at the index, and if not found, Search to the right of this index, in a circular fashion
        int count = 0;
        while (table[index] != null && count < capacity) {
            if (table[index].key == key)
                return true;
            index = (index + 1) % capacity;
            count++;
        }
        return false;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": (" + table[i].key +")");
        }
        System.out.println();
    }
    // This version does not support deletion
}
