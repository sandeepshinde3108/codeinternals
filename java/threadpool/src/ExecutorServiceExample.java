import sun.nio.ch.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor is an implementation of ExecutorService
 *
 */
public final class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                4,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2));

        executorService.submit(() -> {
            printThreadDetails("Task1", 500);
        });

        executorService.submit(() -> {
            printThreadDetails("Task2",2000);
        });

        executorService.submit(() -> {
            printThreadDetails("Task3",1000);
        });

        executorService.submit(() -> {
            printThreadDetails("Task4",100);
        });

        executorService.submit(() -> {
            printThreadDetails("Task5",3000);
        });

        executorService.submit(() -> {
            printThreadDetails("Task6",5000);
        });

        System.out.println("Active Threads count : " + ((ThreadPoolExecutor) executorService).getActiveCount());
        System.out.println("Completed Tasks count : " + ((ThreadPoolExecutor) executorService).getCompletedTaskCount());

        if(!executorService.isShutdown()){
            try {
                while(!executorService.awaitTermination(50, TimeUnit.SECONDS)){
                    System.out.println("Active Threads count during shutdown: " + ((ThreadPoolExecutor) executorService).getActiveCount());
                    System.out.println("Completed Tasks count during shutdown: " + ((ThreadPoolExecutor) executorService).getCompletedTaskCount());
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printThreadDetails(String task, long time){
        System.out.println(String.format("Task %s started on thread %s", task, Thread.currentThread().getName()));
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Task %s finished on thread %s", task, Thread.currentThread().getName()));
    }
}
