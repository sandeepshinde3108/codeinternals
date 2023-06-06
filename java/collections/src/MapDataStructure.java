import java.util.*;

/**
 * Explore all data structures exposed as part of Map Collection
 * Operations that should be covered
 * 1. Insertion
 * 2. Search
 * 3. Access
 * 4. Deletion
 */
public class MapDataStructure {
    public static void main(String[] args) {
        System.out.println("----------------HashMap----------------------");
        exploreHashMap();

        System.out.println("----------------LinkedHashMap----------------");
        exploreLinkedHashMap();

        System.out.println("----------------SortedMap--------------------");
        exploreSortedMap();

        System.out.println("----------------NavigableMap-----------------");
        exploreNavigableMap();
    }

    private static void exploreHashMap(){
        /**
         * HashMap is an implementation of Map interface.
         * The insertion order of the element in Map is not guaranteed.
         */

        Map<Integer, String> hashMap = new HashMap<>();

        //1. Insertion
        System.out.println("-------------Insertion---------------");

        /**
         * TimeComplexity is O(1)
         */
        hashMap.put(3, "John");
        hashMap.put(45, "Sam");
        hashMap.put(89, "Lina");
        printMap(hashMap);

        //2. Search
        System.out.println("-------------Search---------------");

        /**
         * TimeComplexity is O(n)
         */
        System.out.println("Is Key=45 present = " + hashMap.containsKey(45));
        System.out.println("Is Key=5 present = " + hashMap.containsKey(5));

        //3. Access
        System.out.println("-------------Access---------------");

        /**
         * TimeComplexity is O(1)
         */
        System.out.println("Value of key 45 = " + hashMap.get(45));

        //4. Deletion
        System.out.println("-------------Deletion---------------");

        /**
         * TimeComplexity is O(1)
         */
        System.out.println("Remove key=89");
        hashMap.remove(89);
        printMap(hashMap);
    }

    private static void exploreLinkedHashMap(){
        /**
         * LinkedHashMap is an implementation of Map interface.
         * The insertion order of the element in Map is guaranteed.
         */

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        //1. Insertion
        System.out.println("-------------Insertion---------------");

        /**
         * TimeComplexity is O(1)
         */
        linkedHashMap.put(1, "John");
        linkedHashMap.put(2, "Sam");
        linkedHashMap.put(3, "Lina");
        printMap(linkedHashMap);

        //2. Search
        System.out.println("-------------Search---------------");

        /**
         * TimeComplexity is O(n)
         */
        System.out.println("Is Key=2 present = " + linkedHashMap.containsKey(2));
        System.out.println("Is Key=5 present = " + linkedHashMap.containsKey(5));

        //3. Access
        System.out.println("-------------Access---------------");

        /**
         * TimeComplexity is O(1)
         */
        System.out.println("Value of key 3 = " + linkedHashMap.get(3));

        //4. Deletion
        System.out.println("-------------Deletion---------------");

        /**
         * TimeComplexity is O(1)
         */
        System.out.println("Remove key=1");
        linkedHashMap.remove(1);
        printMap(linkedHashMap);
    }

    private static void exploreSortedMap(){
        /**
         * TreeMap is an implementation of SortedMap interface.
         * The elements are always in sorted order, by default in natural order or the one specified.
         */

        SortedMap<Integer, String> sortedMap = new TreeMap<>(Comparator.reverseOrder());

        //1. Insertion
        System.out.println("-------------Insertion---------------");

        /**
         * TimeComplexity is O(logn)
         */
        sortedMap.put(67, "John");
        sortedMap.put(52, "Sam");
        sortedMap.put(98, "Lina");
        printMap(sortedMap);

        //2. Search
        System.out.println("-------------Search---------------");

        /**
         * TimeComplexity is O(logn)
         */
        System.out.println("Is Key=98 present = " + sortedMap.containsKey(98));
        System.out.println("Is Key=5 present = " + sortedMap.containsKey(5));

        //3. Access
        System.out.println("-------------Access---------------");

        /**
         * TimeComplexity is O(1)
         */
        System.out.println("Value of key 52 = " + sortedMap.get(52));

        //4. Deletion
        System.out.println("-------------Deletion---------------");

        /**
         * TimeComplexity is O(logn)
         */
        System.out.println("Remove key=67");
        sortedMap.remove(67);
        printMap(sortedMap);
    }

    private static void exploreNavigableMap(){
        /**
         * NavigableMap is an extension of SortedMap interface.
         * It provides convenient navigation methods which provides either set of keys or sub maps.
         * TreeMap is the  implementation class of NavigableMap interface
         */

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();

        //1. Insertion
        System.out.println("-------------Insertion---------------");

        /**
         * TimeComplexity is O(logn)
         */
        navigableMap.put(23, "Sam");
        navigableMap.put(1, "John");
        navigableMap.put(43, "Lily");
        navigableMap.put(5, "Tom");
        navigableMap.put(12, "Mat");
        printMap(navigableMap);

        //Getting set of keys
        System.out.println("\n -------Navigation methods------- \n");

        System.out.println("Key immediate lower than the provided key 12 -> " + navigableMap.lowerKey(12));
        System.out.println("<Key, Value> pair immediate lower than the provided key 12 -> " + navigableMap.lowerEntry(12).toString());

        System.out.println("Key immediate lower than or equal to the provided key 12 -> " + navigableMap.floorKey(12));
        System.out.println("<Key, Value> pair immediate lower than equal to the provided key 12 -> " + navigableMap.floorEntry(12));

        System.out.println("Key immediate higher than the provided key 12 -> " + navigableMap.higherKey(12));
        System.out.println("<Key, Value> pair immediate higher than the provided key 12 -> " + navigableMap.higherEntry(12).toString());

        System.out.println("Key immediate higher than or equal to the provided key 12 -> " + navigableMap.ceilingKey(12));
        System.out.println("<Key, Value> pair immediate higher than equal to the provided key 12 -> " + navigableMap.ceilingEntry(12));

        //Getting submaps
        System.out.println("\n --------Methods to create submap-------- \n");

        System.out.println("Get submap starting from head till the key provided");
        printMap(navigableMap.headMap(12, true));

        System.out.println("Get submap starting from kep provided till the tail of the map");
        printMap(navigableMap.tailMap(12, true));

        System.out.println("Get submap based on provided from key till to key excluding to key");
        printMap(navigableMap.subMap(5, 23));
    }

    private static void printMap(Map<Integer, String> map){
        System.out.println(map.toString());
    }
}
