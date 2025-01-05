import jdk.swing.interop.SwingInterOpUtils;

import java.time.chrono.IsoEra;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyDemo {
    /**
     * Method name                          Description
     * get()                        Retrieves the current value
     * set()                        Sets the given value, equivalent to the assignment = operator
     * getAndSet()                  Atomically sets the new value and returns the old value
     * incrementAndGet()            For numeric classes, atomic pre-increment operation equivalent to ++value
     * getAndIncrement()            For numeric classes, atomic post-increment operation equivalent to value++
     * decrementAndGet()            For numeric classes, atomic pre-decrement operation equivalent to --value
     * getAndDecrement()            For numeric classes, atomic post-decrement operation equivalent to value--
     */
    // this is not synchronized
    /// without using atomicInteger, the sheepCount won't be thread safe
    // and may have inconsistent values across thead executions
    private AtomicInteger sheepCount1 = new AtomicInteger(0);
    private int sheepCount2 = 0;

    private void incrementAndReportWithAtomicVariable() {
        System.out.println("Atomic increment: " + sheepCount1.incrementAndGet() + " ");
    }

    private void incrementAndReportWithSynchronizedLock() {
        synchronized (this) {
            System.out.println("Synchronized increment: " +  ++sheepCount2 + " ");
        }

    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        ThreadSafetyDemo threadSafetyDemo = new ThreadSafetyDemo();
        for (int i = 0; i < 10; i++) {
            service.submit(() -> threadSafetyDemo.incrementAndReportWithAtomicVariable());
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            service.submit(() -> threadSafetyDemo.incrementAndReportWithSynchronizedLock());
        }
        if (service != null) service.shutdown();
    }
}
