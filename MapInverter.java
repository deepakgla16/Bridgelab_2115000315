import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Add key to the list of keys for this value
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        // Sample input
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);

        // Print output
        System.out.println("Inverted Map: " + invertedMap);
    }
}
