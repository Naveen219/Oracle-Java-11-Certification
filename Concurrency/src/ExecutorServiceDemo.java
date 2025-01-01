import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
/**
     *                         ExecutorService
     *  Active                             Shutting Down                       Shutdown
     *  Accepts New tasks                  Rejects New Tasks                   Rejects New Tasks
     *  Executes Tasks                     Executes Tasks                      No Tasks Running
     *  isShutdown() -> false            isShutdown() -> true                   isShutdown() -> true
     *  isTerminated -> false            isTerminated() -> false                isTerminated() -> true
     */
    public static void main(String[] args) {
       ExecutorService service = null;
       Runnable task1 = () ->
               System.out.println("Printing Zoo Inventory");
       Runnable task2 = () -> {
           for (int i = 0; i < 3; i++) {
               System.out.println("Printing record: " + i);
           }
       };
       try {
           // tasks are guaranteed to be executed sequentially
           service = Executors.newSingleThreadExecutor();
           System.out.println("begin");
           service.execute(task1);
           service.execute(task2);
           service.execute(task1);
           System.out.println("end");
           System.out.println(service.isShutdown());
           System.out.println(service.isTerminated());
       }
       finally {
           // A thread executor creates a non-daemon thread on the first task
           // that is executed, so failing to call shutdown() will result
           // in your application never terminating
           if (Objects.nonNull(service)){
               System.out.println("Shutting down the executor service");
               service.shutdown();
           }
       }
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
       // doesn't accept new tasks
        // throws RejectedExecutionExecption
       //service.execute(task1);

    }
}
