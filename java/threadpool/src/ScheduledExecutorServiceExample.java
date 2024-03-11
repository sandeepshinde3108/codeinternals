import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor is an implementation of ScheduledExecutorService
 * It provides mechanism to schedule tasks and execute them at a specified delayed time
 */
public final class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);

        //Below task will execute after 10 seconds from the application is started
        scheduledExecutorService.schedule(() -> {
            printScheduledTask("Task1");
        }, 10, TimeUnit.SECONDS);

        //Below task will execute after 5 seconds from the application is started
        scheduledExecutorService.schedule(() -> {
            printScheduledTask("Task2");
        }, 5, TimeUnit.SECONDS);

        //Below task will execute after 20 seconds from the application is started
        scheduledExecutorService.schedule(() -> {
            printScheduledTask("Task3");
        }, 20, TimeUnit.SECONDS);

        if(!scheduledExecutorService.isShutdown()){
            try {
                while (!scheduledExecutorService.awaitTermination(30, TimeUnit.SECONDS)){
                    scheduledExecutorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printScheduledTask(String task){
        System.out.println(String.format("Executing %s on %s", task, Thread.currentThread().getName()));
    }
}
