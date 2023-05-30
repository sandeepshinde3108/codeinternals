import java.util.*;

/**
 * Explore all data structures exposed as part of Queue Collection
 * Operations that should be covered
 * 1. Insertion
 * 2. Search
 * 3. access
 * 5. Deletion
 */
public final class QueueDataStructure {
    public static void main(String[] args) {
        System.out.println("-------------------------Queue---------------------------");
        exploreQueue();

        System.out.println("---------------------PriorityQueue-----------------------");
        explorePriorityQueue();
    }

    private static void exploreQueue(){
        /**
         * LinkedList provides the implementation for Queue
         * There are 2 ways to add/remove elements to/from queue
         * 1. add() / remove() / element() methods - these methods throw exceptions when the queue is full / empty
         * 2. offer() / poll() / peek() methods - these methods return null / false when the queue is full or empty
         */
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("----------------add()/remove()/element()-------------------");
        //1. Insertion

        /**
         * TimeComplexity is O(1)
         */
        queue.add(1);
        queue.add(2);
        printQueue(queue);

        //2. Search

        /**
         * TimeComplexity is O(n)
         */
        System.out.println(queue.contains(new Integer(1)));

        //3. Access

        /**
         * TimeComplexity is O(1)
         */
        System.out.println(queue.element());

        //4. Deletion

        /**
         * TimeComplexity is O(1)
         */
        queue.remove();
        printQueue(queue);

        queue.clear();
        System.out.println("---------------offer()/poll()/peek()----------------------");
        //1. Insertion

        /**
         * TimeComplexity is O(1)
         */
        queue.offer(1);
        queue.offer(2);
        printQueue(queue);

        //2. Search

        /**
         * TimeComplexity is O(n)
         */
        System.out.println(queue.contains(new Integer(1)));

        //3. Access

        /**
         * TimeComplexity is O(1)
         */
        System.out.println(queue.peek());

        //4. Deletion

        /**
         * TimeComplexity is O(1)
         */
        queue.poll();
        printQueue(queue);
    }

    private static void explorePriorityQueue(){
        /**
         * PriorityQueue is an implementation of Queue which gives priority to the element based on its order.
         * Look at the constructor param which specifies the order (i.e. bigger number should be given priority)
         * in which the element should be fetched / removed.
         * This order is applied only while fetching / removing elements from the queue.
         */

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        //1. Insertion

        /**
         * TimeComplexity is O(log n)
         */
        priorityQueue.offer(23);
        priorityQueue.offer(33);
        priorityQueue.offer(3);
        priorityQueue.offer(56);
        priorityQueue.offer(47);

        printQueue(priorityQueue);

        //2. Search

        /**
         * TimeComplexity is O(n)
         */

        System.out.println(priorityQueue.contains(new Integer(56)));

        //3. Access

        /**
         * TimeComplexity is O(1)
         */

        System.out.println(priorityQueue.peek());

        //4. Deletion

        /**
         * TimeComplexity is O(log n)
         */

        priorityQueue.poll(); // this will remove the largest number first because of descending order
        priorityQueue.poll(); // remove next largest

        printQueue(priorityQueue);
    }

    private static void printQueue(Queue<Integer> queue){
        System.out.println(Arrays.toString(queue.toArray()));
    }
}
