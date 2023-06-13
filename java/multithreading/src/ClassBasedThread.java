
public final class ClassBasedThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }

    /**
     * There are 2 ways to create threads.
     * Below is one way of creating threads by extending Thread class
     */
    private static final class Task extends Thread {
        @Override
        public void run() {
            System.out.println("Execute Task extended from Thread");
        }
    }
}
