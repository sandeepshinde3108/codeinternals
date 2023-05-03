
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
        exploreArrayList();

        //exploreLinkedList();

        //exploreCopyOnWriteArrayList();
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

    }

    private static void exploreCopyOnWriteArrayList(){

    }

    private static void printListDataStructure(List<Integer> list){
        if(list == null || list.isEmpty())
            return;

        System.out.println(list.toString());
    }

}
