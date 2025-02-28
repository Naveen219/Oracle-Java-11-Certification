import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        // creates a thread pool that creates new threads as needed but
        // will reuse previously constructed threads when they are
        // available
        ExecutorService service = Executors.newCachedThreadPool();

        // prints the numbers of core processors in your cpu
        System.out.println(Runtime.getRuntime().availableProcessors());

        Runnable task1 = () -> {
            System.out.println("Thread id: " + Thread.currentThread().getId());
            System.out.println("Hello, How are you doing? ");
        };
        Runnable task2 = () ->{
            System.out.println("Thread id: " + Thread.currentThread().getId());
            System.out.println("This pleasant morning");
        };


        service.execute(task1);
        service.execute(task2);
        if (service != null) service.shutdown();
    }

}
