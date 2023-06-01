import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Explore all data structures exposed as part of DeQueue Collection
 * Operations that should be covered
 * 1. Insertion
 * 2. Search
 * 3. access
 * 5. Deletion
 */
public final class DequeueDataStructure {
    public static void main(String[] args) {
        System.out.println("---------------------ArrayDequeue--------------------");
        exploreArrayDequeue();

        System.out.println("---------------------LinkedListDequeue----------------");
        exploreLinkedListDequeue();
    }

    private static void exploreArrayDequeue(){
        /**
         * This is an Array double ended queue with bound or unbound
         * Created bounded deque below
         */
        Deque<Integer> arrayDeque = new ArrayDeque<>(5);

        //1. Insertion
        System.out.println("---------------------Insertion------------------------");
        /**
         * TimeComplexity is O(1)
         */

        System.out.println("----Insertion from rear----");
        //both methods below add element to the queue at the rear
        arrayDeque.add(1);
        arrayDeque.addLast(2);

        //both methods below add element to the queue at the rear, they don't throw exception on queue full or empty
        arrayDeque.offer(3);
        arrayDeque.offerLast(4);

        printDeque(arrayDeque);

        System.out.println("----Insertion from head----");
        //adds element to the head of the queue
        arrayDeque.addFirst(11);

        //adds element to the head of the queue, they don't throw exception on queue full or empty
        arrayDeque.offerFirst(12);

        printDeque(arrayDeque);


        //2. Search
        System.out.println("---------------------Search------------------------");
        /**
         * TimeComplexity is O(n)
         */
        System.out.println(arrayDeque.contains(11));

        //3. Access
        System.out.println("---------------------Access------------------------");
        /**
         * TimeComplexity is O(1)
         */

        System.out.println("----Access from rear----");
        System.out.println(arrayDeque.peekLast());

        System.out.println("----Access from head----");
        System.out.println(arrayDeque.peekFirst());

        //4. Deletion
        System.out.println("---------------------Deletion------------------------");
        /**
         * TimeComplexity is O(1)
         */

        System.out.println("----Remove from rear----");
        System.out.println(arrayDeque.removeLast());
        System.out.println();

        System.out.println("----Remove from head----");
        System.out.println(arrayDeque.removeFirst());

        printDeque(arrayDeque);
    }

    private static void exploreLinkedListDequeue(){
        /**
         * This is a LinkedList double ended queue which is unbound
         */

        Deque<Integer> linkedListDeque = new LinkedList<>();

        //1. Insertion
        System.out.println("---------------------Insertion------------------------");
        /**
         * TimeComplexity is O(1)
         */

        System.out.println("----Insertion from rear----");
        //both methods below add element to the queue at the rear
        linkedListDeque.add(1);
        linkedListDeque.addLast(2);

        //both methods below add element to the queue at the rear, they don't throw exception on queue full or empty
        linkedListDeque.offer(3);
        linkedListDeque.offerLast(4);

        printDeque(linkedListDeque);

        System.out.println("----Insertion from head----");
        //adds element to the head of the queue
        linkedListDeque.addFirst(11);

        //adds element to the head of the queue, they don't throw exception on queue full or empty
        linkedListDeque.offerFirst(12);

        printDeque(linkedListDeque);


        //2. Search
        System.out.println("---------------------Search------------------------");
        /**
         * TimeComplexity is O(n)
         */
        System.out.println(linkedListDeque.contains(11));

        //3. Access
        System.out.println("---------------------Access------------------------");
        /**
         * TimeComplexity is O(1)
         */

        System.out.println("----Access from rear----");
        System.out.println(linkedListDeque.peekLast());

        System.out.println("----Access from head----");
        System.out.println(linkedListDeque.peekFirst());

        //4. Deletion
        System.out.println("---------------------Deletion------------------------");
        /**
         * TimeComplexity is O(1)
         */

        System.out.println("----Remove from rear----");
        System.out.println(linkedListDeque.removeLast());
        System.out.println();

        System.out.println("----Remove from head----");
        System.out.println(linkedListDeque.removeFirst());

        printDeque(linkedListDeque);
    }

    private static void printDeque(Deque<Integer> deque){
        System.out.println(Arrays.toString(deque.toArray()));
    }
}
