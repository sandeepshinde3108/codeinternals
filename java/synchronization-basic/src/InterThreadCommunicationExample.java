import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunicationExample {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        Thread producer = new Thread(new Producer(sharedQueue));
        producer.start();
        Thread consumer = new Thread(new Consumer(sharedQueue));
        consumer.start();
    }

    private static final class Producer implements Runnable {
        private Queue<Integer> sharedQueue;

        public Producer(Queue<Integer> sharedQueue){
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for(int i = 1; i <= 10; i++){
                synchronized (sharedQueue){
                    while(sharedQueue.size() > 5){
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    sharedQueue.offer(i);
                    System.out.println("Produced: " + i);
                    sharedQueue.notify();
                }
            }
        }
    }

    private static final class Consumer implements Runnable {
        private Queue<Integer> sharedQueue;

        public Consumer(Queue<Integer> sharedQueue){
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while(true){
                synchronized (sharedQueue){
                    while (sharedQueue.isEmpty()){
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Consumed: "+sharedQueue.poll());
                    sharedQueue.notify();
                }
            }
        }
    }
}
