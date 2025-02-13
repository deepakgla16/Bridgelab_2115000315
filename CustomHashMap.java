import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16; // Default size of the HashMap
    private LinkedList<Entry<K, V>>[] buckets; // Array of linked lists for separate chaining

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    // Hash function to get bucket index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if key already exists, update value if found
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value
                return;
            }
        }

        // If key does not exist, insert new entry
        buckets[index].add(new Entry<>(key, value));
    }

    // Retrieve a value for a given key
    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;

        buckets[index].removeIf(entry -> entry.key.equals(key)); // Remove the matching key
    }

    // Display the HashMap (for testing)
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("grape", 40);

        System.out.println("Value for 'banana': " + map.get("banana")); // Output: 20
        System.out.println("Value for 'grape': " + map.get("grape"));   // Output: 40

        map.remove("banana");
        System.out.println("Value for 'banana' after removal: " + map.get("banana")); // Output: null

        System.out.println("\nHashMap contents:");
        map.display();
    }
}
