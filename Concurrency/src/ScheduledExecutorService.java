import java.util.concurrent.*;

public class ScheduledExecutorService {
    public static void main(String[] args) {
        java.util.concurrent.ScheduledExecutorService service =  Executors.newSingleThreadScheduledExecutor();
        Runnable task1= () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> result1 = service.schedule(task1, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> result2 = service.schedule(task2, 10, TimeUnit.SECONDS);
        try {
            System.out.println(result2.get(2,TimeUnit.MINUTES));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        // creates a new task and submits to the executor every period
        // regardless of whether the previous task finished
        java.util.concurrent.ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();
        service2.scheduleAtFixedRate(task1, 2, 5, TimeUnit.SECONDS);

       //creates a new task only after the previous task has finished
        service2.scheduleWithFixedDelay(task1, 2, 5, TimeUnit.SECONDS);

        if (service != null) service.shutdown();
        if (service2 != null) service2.shutdown();
    }

}
