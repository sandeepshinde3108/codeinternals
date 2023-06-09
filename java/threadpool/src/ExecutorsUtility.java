import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The way there are implementations of ExecutorService to create thread pool.
 * The job of creating thread pool has been simplified even more by providing an utility class called Executors.
 * In Executors class there are predefined methods to create different types of thread pool, where the executor object
 * creation is delegated to methods in Executors utility class.
 */
public final class ExecutorsUtility {
    public static void main(String[] args) {
        System.out.println("-----------Single Thread Pool----------------");
        exploreSingleThreadPool();

        System.out.println("-----------Fixed Thread Pool (fixed number of threads)----------------");
        exploreFixedThreadPool();

        System.out.println("-----------Cached Thread Pool----------------");
        exploreCachedThreadPool();

        System.out.println("-----------Scheduled Thread Pool----------------");
        exploreScheduledThreadPool();

        System.out.println("-----------WorkStealing Thread Pool (ForkJoin)----------------");
        exploreWorkStealingThreadPool();
    }

    private static void exploreSingleThreadPool(){
        /**
         * This method actually creates an instance of ThreadPoolExecutor with 1 thread pool size
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            printExecutingTaskDetail("Task1", "exploreSingleThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task2", "exploreSingleThreadPool");
        });

        shutdownThreadPool(executorService);
    }

    private static void exploreFixedThreadPool(){
        /**
         * This method actually creates an instance of ThreadPoolExecutor with no of threads passed as argument
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            printExecutingTaskDetail("Task11", "exploreFixedThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task12", "exploreFixedThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task13", "exploreFixedThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task14", "exploreFixedThreadPool");
        });
        shutdownThreadPool(executorService);
    }

    private static void exploreCachedThreadPool(){
        /**
         * This method actually creates an instance of ThreadPoolExecutor with no of threads passed as argument
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            printExecutingTaskDetail("Task11", "exploreCachedThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task12", "exploreCachedThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task13", "exploreCachedThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task14", "exploreCachedThreadPool");
        });
        shutdownThreadPool(executorService);
    }

    private static void exploreScheduledThreadPool(){
        /**
         * This method actually creates an instance of ScheduledThreadPoolExecutor with no of threads passed as argument
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(() -> {
            printExecutingTaskDetail("Task21", "exploreScheduledThreadPool");
        }, 10, TimeUnit.SECONDS);
        executorService.schedule(() -> {
            printExecutingTaskDetail("Task22", "exploreScheduledThreadPool");
        }, 2, TimeUnit.SECONDS);
        executorService.schedule(() -> {
            printExecutingTaskDetail("Task23", "exploreScheduledThreadPool");
        }, 5, TimeUnit.SECONDS);
        executorService.schedule(() -> {
            printExecutingTaskDetail("Task24", "exploreScheduledThreadPool");
        }, 20, TimeUnit.SECONDS);
        shutdownThreadPool(executorService);
    }

    private static void exploreWorkStealingThreadPool(){
        /**
         * This method actually creates an instance of ForkJoinPool using available number of processors for parallelism
         * There's a variation of this method taking parallelism as parameter.
         */
        ExecutorService executorService = Executors.newWorkStealingPool();
        executorService.submit(() -> {
            printExecutingTaskDetail("Task31", "exploreWorkStealingThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task32", "exploreWorkStealingThreadPool");
        });
        executorService.submit(() -> {
            printExecutingTaskDetail("Task33", "exploreWorkStealingThreadPool");
        });
        shutdownThreadPool(executorService);
    }

    private static void printExecutingTaskDetail(String task, String method){
        System.out.println(String.format("%s : Executing %s on %s thread", method, task, Thread.currentThread().getName()));
    }

    private static void shutdownThreadPool(ExecutorService executorService){
        if(!executorService.isShutdown()){
            try {
                while(!executorService.awaitTermination(25, TimeUnit.SECONDS)){
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
