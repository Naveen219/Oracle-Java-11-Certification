import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        // creates a thread pool that creates new threads as needed but
        // will reuse previously constructed threads when they are
        // available
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        Runnable task1 = () -> {
            System.out.println("Thread id: " + Thread.currentThread().getId());
            System.out.println("Hello, How are you doing? ");
        };
        Runnable task2 = () ->{
            System.out.println("Thread id: " + Thread.currentThread().getId());
            System.out.println("This pleasant morning");
        };

        // prints the numbers of core processors in your cpu

        service.schedule(task1, 2, TimeUnit.SECONDS);
        service.schedule(task2,4, TimeUnit.SECONDS);
        if (service != null) service.shutdown();

    }
}
