import java.util.concurrent.*;

public final class FutureExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(() -> "Hello");
        try {
            System.out.println(future.get());

            if(!service.awaitTermination(5, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
