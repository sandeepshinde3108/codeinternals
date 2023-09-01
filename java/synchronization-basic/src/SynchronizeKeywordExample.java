/**
 * Here we are going to see mutually exclusive thread synchronization techniques
 * 1. synchronized method
 * 2. synchronized block
 * 3. static synchronized
 *
 * Uncomment single example at a time
 */
public class SynchronizeKeywordExample {
    public static void main(String[] args) {
//        System.out.println("---------------------synchronized method--------------------");
//        synchronizedMethodExample();

//        System.out.println("---------------------synchronized block---------------------");
//        synchronizedBlockExample();

        System.out.println("----------------------static synchronized-------------------");
        staticSynchronizedMethodExample();
    }

    private static void synchronizedMethodExample(){
        NumberPrinter numberPrinter = new NumberPrinter();
        Thread t1 = new Thread(new Task(numberPrinter, 1,5));
        Thread t2 = new Thread(new Task(numberPrinter, 11, 15));
        t1.start();
        t2.start();
    }

    private static void synchronizedBlockExample(){
        NumberPrinter numberPrinter = new NumberPrinter();
        Thread t1 = new Thread(new BlockTask(numberPrinter, 1,5));
        Thread t2 = new Thread(new BlockTask(numberPrinter, 11, 15));
        t1.start();
        t2.start();
    }

    private static void staticSynchronizedMethodExample(){
        Thread t1 = new Thread(new StaticTask(1,5));
        Thread t2 = new Thread(new StaticTask(11,15));
        Thread t3 = new Thread(new StaticTask(21,25));
        t1.start();
        t2.start();
        t3.start();
    }

    private static final class NumberPrinter{
        /**
         * Try removing synchronized keyword, the output will be mix of numbers from 2 threads
         * But with synchronized keyword,
         * 1. Thread locks the numberPrinter object
         * 2. prints the numbers
         * 3. Releases the lock
         * @param num1
         * @param num2
         */
        public synchronized void print(int num1, int num2){
            printingNumbers(num1, num2);
        }

        /**
         * In below method, only number printing block is synchronized. Hence the status messages at beginning and ending of a method are printed from different threads.
         * But number printing happens for 1 thread after acquiring lock and once the lock is released by that thread only then other thread acquires lock and prints numbers
         * @param num1
         * @param num2
         */
        public void printNumbersWithStatus(int num1, int num2){
            System.out.println(Thread.currentThread().getName() + " : started printing");

            synchronized (this){
                printingNumbers(num1, num2);
            }

            System.out.println(Thread.currentThread().getName() + " : finished printing");
        }

        /**
         * In this case the lock is acquired at the class level.
         * So, no matter how many objects are present, if one thread acquires a lock, all objects of the class are blocked, until the lock is released
         * @param num1
         * @param num2
         */
        public synchronized static void printNums(int num1, int num2){
            for(int i = num1; i <= num2; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }

        private void printingNumbers(int num1, int num2){
            for(int i = num1; i <= num2; i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    private static final class StaticTask implements Runnable {
        private int num1;
        private int num2;

        StaticTask(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public void run() {
            NumberPrinter.printNums(num1, num2);
        }
    }

    private static final class BlockTask implements Runnable {
        private NumberPrinter numberPrinter;
        private int num1;
        private int num2;

        BlockTask(NumberPrinter numberPrinter, int num1, int num2){
            this.numberPrinter = numberPrinter;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public void run() {
            numberPrinter.printNumbersWithStatus(num1, num2);
        }
    }

    private static final class Task implements Runnable {
        private NumberPrinter numberPrinter;
        private int num1;
        private int num2;

        Task(NumberPrinter numberPrinter, int num1, int num2){
            this.numberPrinter = numberPrinter;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public void run() {
            numberPrinter.print(num1, num2);
        }
    }

}
