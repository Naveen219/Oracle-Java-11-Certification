import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    private void removeLions() {
        System.out.println("Removing lions");
    }
    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }
    private void addLions() {
        System.out.println("Adding lions");
    }
    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeLions();

            // barrier for all the threads to execute the removeLions method
            //  proceeds to the next step only after all the threads are done
            // with removing Lion
            c1.await();
            cleanPen();
            // barrier for all the threads to execute the cleanPen method
            //  proceeds to the next step only after all the threads are done
            // with cleaning Pen
            c2.await();
            addLions();
        }
        catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            var cyclicBarrierDemo = new CyclicBarrierDemo();
            // thread pool size has to be at least as large as CyclicBarrier limit value,
            // other wise, the code will hang indefinitely. The barrier would never be reached
            // as the only threads available in the pool are stuck waiting for the barrier to complete.
            // This would result in a deadlock
            var c1 = new CyclicBarrier(4);

            // the lambba function gets executed after all the threads finish executing
            // the cleanPen method
            var c2 = new CyclicBarrier(4, () -> System.out.println("***** Pen Cleaned *****!"));
            for (int i = 0; i < 4; i++) {
                service.submit(()-> cyclicBarrierDemo.performTask(c1, c2));
            }
        }
        finally {
            if (service != null) service.shutdown();

        }
    }
}
