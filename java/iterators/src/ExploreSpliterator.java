import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Spliterator is used to split the iterator and iterate parallel
 * Very useful if you have stateless objects and need to reduce time in traversal
 */
public final class ExploreSpliterator {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        numList.add(7);
        numList.add(8);
        numList.add(9);
        numList.add(10);

        Spliterator<Integer> spliterator = numList.spliterator();
        Spliterator<Integer> spliterator1 = spliterator.trySplit();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
           spliterator.forEachRemaining((x) -> System.out.println(Thread.currentThread().getName() + ":" + x));
        });
        executorService.submit(() -> {
            spliterator1.forEachRemaining((x) -> System.out.println(Thread.currentThread().getName() + ":" + x));
        });

        executorService.shutdownNow();
    }
}
