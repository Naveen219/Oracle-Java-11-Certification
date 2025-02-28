import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        // creates a thread pool that reuses a fixed number of threads
        // operating off a shared unbounded queue
        // as long as the number of tasks is less than the number of threads
        // all tasks will be executed concurrently. If at any point the number of tasks
        // exceeds the number of threads in the pool, they will wait in a similar manner
        // to that of single thread executor
        ExecutorService service = Executors.newFixedThreadPool(4);


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
