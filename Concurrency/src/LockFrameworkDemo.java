import javax.imageio.plugins.tiff.TIFFDirectory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFrameworkDemo {
    /*
    // Implementation #1 with a synchronized block
    Object object = new Object();
    synchronized(object) {
     // Protected code
     }
    // Implementation #2 with a Lock
    Lock lock = new ReentrantLock();
    try {
        lock.lock();
        // Protected code
      } finally {
        lock.unlock();
      }
      // These two implementations are conceptually equivalent. The ReentrantLock class is a simple
      // monitor that implements the Lock interface and supports mutual exclusion. In other words,
      // at most one thread is allowed to hold a lock at any given time

     // The ReentrantLock class ensures that once a thread has class lock() and obtained the lock, all other
     // threads that call lock() will wait until the first thread calls unlock(). As far as which thread gets
     // the lock next, that depends on the parameters used to create the Lock object
     Method                                 Description
    void lock()                             Requests a lock and blocks until lock is acquired
    void unlock()                           Releases a lock
    boolean tryLock()                       Requests a lock and returns immediately. Returns a boolean indicating
                                            whether the lock was successfully acquired
    boolean tryLock(long,TimeUnit)          Requests a lock and blocks up to the specified time until lock is required.
                                            Returns a boolean indicating whether the lock was successfully acquired

     */
    private static void printMessage(Lock lock) {
        try {
            // if a thread can't acquire a lock, it waits  for a maximum of 2 seconds to acquire it
            // this is not possible with the synchronized keyword as the other threads have to wait for
            // the main thread or first thread to finish its synchronized block execution
            if (lock.tryLock(2,TimeUnit.SECONDS)) {
                try {
                    System.out.println("Thread: " + Thread.currentThread().getId() + " Lock obtained, entering protected code");
                    System.out.println("Hello, How are you doing today?");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Unable to acquire lock, doing something else");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(false);
        new Thread(() -> printMessage(lock)).start();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> printMessage(lock)).start();
        }
    }
}
