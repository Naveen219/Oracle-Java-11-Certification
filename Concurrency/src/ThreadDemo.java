import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

    public static void main(String[] args)  {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm an anonymous implementation of Runnable: " +Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(() -> System.out.println("I'm a lambda implementation of Runnable: " +
                Thread.currentThread().getName()));

        CustomThread customThread = new CustomThread();

        thread1.start();
        thread2.start();

        customThread.start();

        RunThread runThread1 = new RunThread();

        runThread1.start();
        runThread1.interrupt();

        RunThread runThread2 = new RunThread();


        RunThread runThread3 = new RunThread();

        runThread2.start();

        try {
            // runthread3 waits for runThread2 to finish its execution
            runThread2.join(500);

            // can also specify the time that runThread3 can wait before it starts its execution
//            runThread1.join(1000);

        }
        catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        runThread3.start();




    }



}
