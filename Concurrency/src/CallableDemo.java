import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
        try {
            service = Executors.newSingleThreadExecutor();
            Callable<String> task1 = () -> "task1";
            Callable<String> task2 = () -> "task3";
            Callable<String> task3 = () -> "task3";
            List<Callable<String>> taskList = List.of(task1, task2, task3);
            System.out.println("Submitting each tasks manually (task1, task2, task3)");
            for (var task : taskList) {
              Future<String>  result = service.submit(task);
              System.out.println(result.get(1, TimeUnit.MINUTES));
            }
            System.out.println("Executing a task at random out of (task1, task2, task3) with invokeAny");
            System.out.println(service.invokeAny(taskList));
            System.out.println("Executing all tasks (task1, task2, task3) with invokeAll");
            List<Future<String>> taskList2 = service.invokeAll(taskList);
            for (var task : taskList2) {
                try {
                    String res = task.get(1, TimeUnit.MINUTES);
                    System.out.println(res);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (service != null) service.shutdown();
        }
        if (service != null) {
            try {
                // waits for all tasks to finish their execution for a maximum of 1 min
                // throws Interrupted Exception if execution of tasks times out
                service.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Returns true if all the tasks in the blocking queue have finished their execution
            if (service.isTerminated()) System.out.println("Finished");
            else System.out.println("At least one task is still running");
        }
    }
}
