

public final class InterfaceBasedThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }

    /**
     * There are 2 ways to create threads.
     * Below is one way of creating threads by implementing Runnable interface
     */
    private static final class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Execute Task implemented from Runnable");
        }
    }
}
