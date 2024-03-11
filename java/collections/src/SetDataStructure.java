import java.util.*;

/**
 * Explore all data structures exposed as part of Set Collection
 * Operations that should be covered
 * 1. Insertion
 * 2. Search
 * 3. Deletion
 */
public class SetDataStructure {
    public static void main(String[] args) {
        System.out.println("-------------HashSet---------------");
        exploreHashSet();

        System.out.println("-------------LinkedHashSet---------------");
        exploreLinkedHashSet();

        System.out.println("-------------SortedSet---------------");
        exploreSortedSet();

        System.out.println("-------------NavigableSet---------------");
        exploreNavigableSet();
    }

    private static void exploreHashSet(){
        /**
         * HashSet is an implementation of Set interface.
         * The insertion order of the element in Set is not guaranteed.
         */

        Set<Integer> hashSet = new HashSet<>();

        //1. Insertion
        System.out.println("-------------------Insertion-----------------------");

        /**
         * TimeComplexity is O(1)
         */
        hashSet.add(3);
        hashSet.add(13);
        hashSet.add(2);
        hashSet.add(67);
        hashSet.add(98);
        printSet(hashSet);

        //2. Search
        System.out.println("-------------------Search-----------------------");

        /**
         * TimeComplexity is O(n)
         */
        System.out.println(hashSet.contains(new Integer(67)));
        System.out.println(hashSet.contains(new Integer(1)));

        //4. Deletion
        System.out.println("-------------------Deletion-----------------------");

        /**
         * TimeComplexity is O(1)
         */
        hashSet.remove(new Integer(98));
        printSet(hashSet);
    }

    private static void exploreLinkedHashSet(){
        /**
         * LinkedHashSet is an implementation of Set interface.
         * The insertion order of the element in Set is guaranteed.
         */

        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        //1. Insertion
        System.out.println("-------------------Insertion-----------------------");

        /**
         * TimeComplexity is O(1)
         */
        linkedHashSet.add(3);
        linkedHashSet.add(13);
        linkedHashSet.add(2);
        linkedHashSet.add(67);
        linkedHashSet.add(98);
        printSet(linkedHashSet);

        //2. Search
        System.out.println("-------------------Search-----------------------");

        /**
         * TimeComplexity is O(n)
         */
        System.out.println(linkedHashSet.contains(new Integer(67)));
        System.out.println(linkedHashSet.contains(new Integer(1)));

        //4. Deletion
        System.out.println("-------------------Deletion-----------------------");

        /**
         * TimeComplexity is O(1)
         */
        linkedHashSet.remove(new Integer(98));
        printSet(linkedHashSet);
    }

    private static void exploreSortedSet(){
        /**
         * TreeSet is an implementation of SortedSet interface.
         * The elements are always in sorted order, by default in natural order or the one specified.
         */

        SortedSet<Integer> sortedSet = new TreeSet<>();

        //1. Insertion
        System.out.println("-------------------Insertion-----------------------");

        /**
         * TimeComplexity is O(logn)
         */
        sortedSet.add(3);
        sortedSet.add(13);
        sortedSet.add(2);
        sortedSet.add(67);
        sortedSet.add(98);
        printSet(sortedSet);

        //2. Search
        System.out.println("-------------------Search-----------------------");

        /**
         * TimeComplexity is O(logn)
         */
        System.out.println(sortedSet.contains(new Integer(67)));
        System.out.println(sortedSet.contains(new Integer(1)));

        //4. Deletion
        System.out.println("-------------------Deletion-----------------------");

        /**
         * TimeComplexity is O(logn)
         */
        sortedSet.remove(new Integer(98));
        printSet(sortedSet);
    }

    private static void exploreNavigableSet(){
        /**
         * NavigableSet is an extension of SortedSet interface.
         * It provides convenient navigation methods which provides either set of keys or sub sets.
         * TreeSet is the  implementation class of NavigableSet interface
         */

        NavigableSet<Integer> navigableSet = new TreeSet<>();

        //1. Insertion
        System.out.println("-------------------Insertion-----------------------");

        /**
         * TimeComplexity is O(logn)
         */
        navigableSet.add(3);
        navigableSet.add(13);
        navigableSet.add(2);
        navigableSet.add(67);
        navigableSet.add(98);
        printSet(navigableSet);

        //Getting set of keys
        System.out.println("\n -------Navigation methods------- \n");

        System.out.println("Key immediate lower than the provided key 13 -> " + navigableSet.lower(13));

        System.out.println("Key immediate lower than or equal to the provided key 13 -> " + navigableSet.floor(13));

        System.out.println("Key immediate higher than the provided key 13 -> " + navigableSet.higher(13));

        System.out.println("Key immediate higher than or equal to the provided key 13 -> " + navigableSet.ceiling(13));


        //Getting subsets
        System.out.println("\n --------Methods to create subset-------- \n");

        System.out.println("Get subset starting from head till the key provided");
        printSet(navigableSet.headSet(13, true));

        System.out.println("Get subset starting from key provided till the tail of the set");
        printSet(navigableSet.tailSet(13, true));

        System.out.println("Get subset based on provided from-key till to-key excluding to-key");
        printSet(navigableSet.subSet(3, 67));
    }

    private static void printSet(Set<Integer> set){
        System.out.println(Arrays.toString(set.toArray()));
    }
}
