import java.util.concurrent.*;

public class FutureDemo {
    private static int counter = 0;
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            // the question mark is a wild card representing an object of any type
            Runnable task = () -> {
                for (int i = 0; i < 500000000; i++) {
                    counter++;
                }
            };
            // execute method doesn't return a future which is used to check if the task is done
            // or cancelled
            service.execute(task);

            Future<?> result = service.submit(task);
            // waits for the task to finish its execution for a max of 5 seconds
            // throws Timeout Exception if it can't finish its execution within the time
            result.get(5, TimeUnit.SECONDS);
            if (result.isDone()) {
                System.out.println("Reached");
            }
        } catch (Exception e) {
            System.out.println("Not reached in time");
            e.printStackTrace();
        }
        finally {
            if (service != null) service.shutdown();
        }
    }
}
