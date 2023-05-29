
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Explore all data structures exposed as part of List Collection
 * Operations that should be covered
 * 1. Insertion
 * 2. Search
 * 3. access
 * 4. sorting (asc, desc)
 * 5. Deletion
 */
public class ListDataStructure {
    public static void main(String[] args) {
        System.out.println("--------------------------ArrayList---------------------------------");
        exploreArrayList();

        System.out.println("--------------------------LinkedList---------------------------------");
        exploreLinkedList();

        System.out.println("--------------------------CopyOnWriteArrayList------------------------");
        exploreCopyOnWriteArrayList();
    }

    private static void exploreArrayList(){
        /*
          List can be bounded(fixed size) or unbounded
          Below is Unbounded ArrayList. The default capacity of an arraylist is 10
          When the arraylist reaches the end, it doubles the size of an array
        */
        List<Integer> numbers = new ArrayList<Integer>();

        //1.Insertion
        System.out.println("-----------------------------Insertion-------------------------");

        /*
          add method adds element at the end of an arraylist.
          TimeComplexity of this is O(1)
        */
        numbers.add(13);
        numbers.add(45);
        numbers.add(9);
        numbers.add(78);
        numbers.add(25);
        numbers.add(39);
        printListDataStructure(numbers);

        /*
          add method with index adds element at the specified index
          TimeComplexity of this is O(n), because it causes shifting of elements

          Below example is to add element 67 at index 1
        */
        numbers.add(1, 67);
        printListDataStructure(numbers);

        //2. Search
        System.out.println("---------------------------Search---------------------------------");

        /*
          It will return true / false based on if the element is present in the list or not
          TimeComplexity of this is O(n)
         */
        System.out.println(numbers.contains(new Integer(78)));

        //3. Access
        System.out.println("-----------------------------Access--------------------------------");

        /*
          access element at index 1
          TimeComplexity of this is O(1)
         */
        System.out.println(numbers.get(1));

        //4. Sorting
        System.out.println("----------------------------Sorting------------------------------");

        /*
         * All below sort methods use merge sort algorithm with O(nlogn) time complexity.
         * The Stream API will have additional overhead of stream creation
         * */

        //asc sorting using sort method of arraylist
        System.out.println("Ascending using sort method of ArrayList");
        numbers.sort(Comparator.naturalOrder());
        printListDataStructure(numbers);
        //desc sorting using sort method of arraylist
        System.out.println("Descending using sort method of ArrayList");
        numbers.sort(Comparator.reverseOrder());
        printListDataStructure(numbers);

        //asc sorting using sort method of Collections utility class
        System.out.println("Ascending using sort method of Collections utility class");
        Collections.sort(numbers);
        printListDataStructure(numbers);
        //desc sorting using sort method of Collections utility class
        System.out.println("Descending using sort method of Collections utility class");
        Collections.sort(numbers, Comparator.reverseOrder());
        printListDataStructure(numbers);

        //asc sorting using sort method of Stream API. Stream API generates a new list, it doesn't update the source
        System.out.println("Ascending using sort method of Stream API");
        printListDataStructure(numbers.stream().sorted().collect(Collectors.toList()));
        //desc sorting using sort method of Stream API
        System.out.println("Descending using sort method of Stream API");
        printListDataStructure(numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        // 5.Deletion
        System.out.println("-------------------------Deletion-------------------------------");

        //remove by actual element
        numbers.remove(new Integer(13));
        printListDataStructure(numbers);

        //remove by index
        numbers.remove(2);
        printListDataStructure(numbers);
    }

    private static void exploreLinkedList(){
        /**
         * LinkedList is an unbound list data structure
         */
        List<Integer> linkedList = new LinkedList<>();

        //1. Insertion
        System.out.println("--------------------------Insertion------------------------------");

        /**
         * add method adds an element at the end of the linkedlist
         * TimeComplexity is O(1)
         */
        linkedList.add(3);
        linkedList.add(13);
        linkedList.add(1);
        linkedList.add(24);
        linkedList.add(9);
        linkedList.add(15);

        printListDataStructure(linkedList);

        /**
         * insertion at a specific index
         * TimeComplexity is O(n) because it has traverse till the index is found
         */

        linkedList.add(2, 56);
        printListDataStructure(linkedList);

        //2. Search
        System.out.println("---------------------------Search---------------------------");

        /**
         * returns true or false if the element is found or not
         * TimeComplexity is O(n)
         */
        System.out.println(linkedList.contains(new Integer(1)));

        //3. Access
        System.out.println("-------------------------Access------------------------------");

        /**
         * returns element at the given index
         * TimeComplexity is O(n) because it has to traverse the list to access the element
         */
        System.out.println(linkedList.get(2));

        //4. Sorting
        System.out.println("------------------------Sorting------------------------------");

        /**
         * TimeComplexity is O(nlogn) because sorting internally uses merge sort
         */

        System.out.println("Ascending using sort method of List");
        //asc sort using sort method of list datastructure
        linkedList.sort(Comparator.naturalOrder());
        printListDataStructure(linkedList);
        System.out.println("Descending using sort method of LinkedList");
        //desc sort using sort method of list datastructure
        linkedList.sort(Comparator.reverseOrder());
        printListDataStructure(linkedList);

        System.out.println("Ascending using sort method of Collections utility class");
        //asc using Collections.sort
        Collections.sort(linkedList);
        printListDataStructure(linkedList);
        System.out.println("Descending using sort method of Collections utility class");
        //desc using Collections.sort
        Collections.sort(linkedList, Comparator.reverseOrder());
        printListDataStructure(linkedList);

        System.out.println("Ascending using sort method of Stream API");
        //asc using Stream API sort method
        List<Integer> ascSortedList = linkedList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        printListDataStructure(ascSortedList);
        System.out.println("Descending using sort method of Stream API");
        //desc using Stream API sort method
        List<Integer> descSortedList = linkedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        printListDataStructure(descSortedList);

        //5. Deletion
        System.out.println("-----------------------Deletion------------------------------");

        /**
         * TimeComplexity is O(n) because it has traverse the list
         */

        //deletion by index
        linkedList.remove(5);
        printListDataStructure(linkedList);
        //deletion by element
        linkedList.remove(new Integer(13));
        printListDataStructure(linkedList);
    }

    private static void exploreCopyOnWriteArrayList(){
        /**
         * CopyOnWriteArrayList is same as ArrayList with 2 differences
         * 1. It is threadsafe
         * 2. It is Fail-safe, doesn't throw ConcurrentModificationException on modifying list while iterating v/s
         *    ArrayList which is Fail-fast throws ConcurrentModificationException on modifying list while iterating
         *
         * So, we'll look at only 2nd point in this method
         */

        List<Integer> threadSafeList = new CopyOnWriteArrayList<>();
        threadSafeList.add(23);
        threadSafeList.add(13);
        threadSafeList.add(34);
        threadSafeList.add(56);
        printListDataStructure(threadSafeList);


        for (Integer num : threadSafeList) {
            //below operation doesn't throw ConcurrentModificationException, but opposite to that ArrayList throws an exception
            if(num == 34)
                threadSafeList.remove(num);
        }

        printListDataStructure(threadSafeList);
    }

    private static void printListDataStructure(List<Integer> list){
        if(list == null || list.isEmpty())
            return;

        System.out.println(list.toString());
    }

}
