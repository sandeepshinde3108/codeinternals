import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Objects implicit lock/monitor are reenterant by nature.
 * Special ReenterantLock mechanism is provided with some additional features which will see in below example
 */
public class LockExample {
    public static void main(String[] args) {
        System.out.println("-------------------Implicit Reenterant---------------------");
        implicitReenterantExample();

        System.out.println("-------------------Lock-----------------------------");
        reenterantLockExample();

        System.out.println("-------------------ReadWriteLock--------------------");
        reenterantReadWriteLockExample();
    }

    private static void implicitReenterantExample(){
        Thread t1 = new Thread(() -> {
            Customer c = new Customer();
            c.generateInvoice();
        });
        t1.start();
    }

    private static void reenterantLockExample(){
        Thread t1 = new Thread(() -> {
            ExplicitLockCustomer c = new ExplicitLockCustomer();
            c.generateInvoice();
        });
        t1.start();
    }

    private static void reenterantReadWriteLockExample(){
        ReadWriteLockNumCounter c = new ReadWriteLockNumCounter();
        Thread t1 = new Thread(() -> {
            c.increamentCounter();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
           c.getCounter();
        });
        Thread t3 = new Thread(() -> {
            c.getCounter();
        });
        t2.start();
        t3.start();
    }

    private static final class ReadWriteLockNumCounter {
        private int counter = 0;
        /**
         * ReadWriteLock is a reenterant lock where there are 2 separate locks,
         * 1. to update the shared data - only 1 thread can acquire write lock at a time
         * 2. to read the shared data - multiple threads can acquire read lock at the same time
         */
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void getCounter(){
            readWriteLock.readLock().lock();
            System.out.println(counter);
            readWriteLock.readLock().unlock();
        }

        public void increamentCounter(){
            readWriteLock.writeLock().lock();
            counter++;
            readWriteLock.writeLock().unlock();
        }
    }

    private static final class ExplicitLockCustomer {
        /**
         * There's a constructor overload with boolean flag, which when set to true, avoids thread starvation.
         * It is a fairness flag which makes sure that the thread who has come first gets a chance to acquire lock, and then the immediate next thread, and so on
         */
        private Lock lock = new ReentrantLock();

        public void generateInvoice(){
            /**
             * there are variations to acquire lock which are
             * 1. lock() returns void, acquires lock if available
             * 2. tryLock() which returns boolean flag, returns true if lock is acquired else false
             * 3. tryLock(long time, TimeUnit unit) which returns boolean flag, returns true if lock is acquired within specified time (it waits for specified time if lock is not available) before return false
             */
            lock.lock();
            getCustomerDetails();

            System.out.println("generated Invoice");
        }

        public void getCustomerDetails(){
            System.out.println("fetched customer details");
            lock.unlock();
        }
    }

    private static final class Customer {
        public synchronized void generateInvoice(){
            getCustomerDetails();

            System.out.println("generated Invoice");
        }

        public synchronized void getCustomerDetails(){
            System.out.println("fetched customer details");
        }
    }
}
