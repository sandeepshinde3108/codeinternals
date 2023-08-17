import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //runAsync is used to run a task which doesn't return a result
        CompletableFuture.runAsync(() -> {
            System.out.println("---------------------------------");
            System.out.println(Thread.currentThread().getName());
            System.out.println("Hello from ForkJoin Thread");
        }).get();

        CompletableFuture.runAsync(() -> {
            System.out.println("---------------------------------");
            System.out.println(Thread.currentThread().getName());
            System.out.println("Hello from Executor Thread");
        }, executorService).get();

        String strResult = CompletableFuture.supplyAsync(() -> {
            System.out.println("---------------------------------");
            System.out.println(Thread.currentThread().getName());
            return "Hello result from ForkJoin Thread";
        }).get();
        System.out.println(strResult);

        String strResult1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("---------------------------------");
            System.out.println(Thread.currentThread().getName());
            return "Hello result from Executor Thread";
        }, executorService).get();
        System.out.println(strResult1);

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Supply: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "I am Hello from Callback Handler.";
        }, executorService).thenAcceptAsync(result -> {
            System.out.println("Accept: " + Thread.currentThread().getName());
            System.out.println(result);
        }, executorService);

        CompletableFuture.supplyAsync(() -> {
            return "hello world how are you";
        }).thenApply(result -> {
            String[] words = result.split(" ");
            return words;
        }).thenApply(words -> {
            return words.length;
        }).thenAccept(count -> {
            System.out.println("Word count: " + count);
        });

        //combine 2 dependent completable futures
        CompletableFuture<List<String>> names = CompletableFuture
                                                    .supplyAsync(() -> getKeys())
                                                    .thenCompose(keys -> getValues(keys));
        names.thenAccept(values -> {
            values.forEach(System.out::println);
        });

        //combine 2 independent completable futures
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (res1, res2) -> res1 + res2);
        System.out.println(cf3.get());

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "How ";
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "are ";
        });
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "you?";
        });

        List<CompletableFuture<String>> cfList = Arrays.asList(completableFuture1, completableFuture2, completableFuture3);

        //perform operation on completion of all the tasks
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[cfList.size()]))
                .thenApply(cf -> cfList.stream().map(CompletableFuture::join).collect(Collectors.toList()))
                .thenAccept(list -> {
                    StringBuilder sb = new StringBuilder();
                    list.forEach(s -> sb.append(s));
                    System.out.println(sb.toString());
                });

        //perform operation on completion of any of the task
        CompletableFuture.anyOf(cfList.toArray(new CompletableFuture[cfList.size()]))
                .thenAccept(System.out::println);

        //exceptionally
        CompletableFuture.supplyAsync(() -> {
            if(true)
                throw new RuntimeException("Failed from exceptionally()");
            return "Hello from exceptionally()";
        }).exceptionally(ex -> {
            return ex.getMessage();
        }).thenAccept(System.out::println);

        //handle
        CompletableFuture.supplyAsync(() -> {
            if(true)
                throw new RuntimeException("Failed from handle()");
            return "Hello from Handle()";
        }).handle((res, ex) -> {
            if(ex != null){
                return ex.getMessage();
            } else {
                return res;
            }
        }).thenAccept(System.out::println);


        //whenComplete
        CompletableFuture.supplyAsync(() -> {
            if(true)
                throw new RuntimeException("Failed from whenComplete()");
            return "Hello from whenComplete()";
        }).whenComplete((res, ex) -> {
            if(ex != null){
                System.out.println(ex.getMessage());
            } else {
                System.out.println(res);
            }
        });

        System.out.println("End of Main method");

        if(!executorService.awaitTermination(20, TimeUnit.SECONDS)){
            executorService.shutdownNow();
        }
    }

    private static List<Integer> getKeys(){
        return Arrays.asList(2,3,4,5);
    }

    private static CompletableFuture<List<String>> getValues(List<Integer> keys){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");
        map.put(5,"E");
        map.put(6,"F");
        map.put(7,"G");

        List<String> result = map.entrySet()
                .stream()
                .filter(entry -> keys.contains(new Integer(entry.getKey())))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(result);
    }
}
