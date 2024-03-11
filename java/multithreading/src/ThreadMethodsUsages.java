public final class ThreadMethodsUsages {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(8000));
        thread1.setName("Thread-1");
        System.out.println("Thread1 State : " + thread1.getState());
        thread1.start();
        System.out.println("Thread1 State : " + thread1.getState());

        //interrupt method is used to awake the thread from sleep / waiting state
        //and if the thread is not in sleep / waiting state and if interrupt method is called then it just sets the interrupt flag to true
        thread1.interrupt();

        Thread thread2 = new Thread(new Task(5000));
        thread1.setName("Thread-2");
        System.out.println("Thread2 State : " + thread2.getState());
        thread2.start();
        System.out.println("Thread2 State : " + thread2.getState());

        try {
            /**
             * Join method is used to wait for the completion of thread execution
             * Below call will wait for thread1 to complete
             */
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread2 State : " + thread2.getState());
        System.out.println("Thread1 State : " + thread1.getState());
    }

    private static final class Task implements Runnable {
        private long sleepTime;

        public Task(long sleepTime){
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println("Executed : " + Thread.currentThread().getName());
            try {
                //Sleep method is used to stop progressing thread for a  specific time
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}
