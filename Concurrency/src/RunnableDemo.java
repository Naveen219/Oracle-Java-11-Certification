public class RunnableDemo {
    public static void main(String[] args) {
        // Runnable is an interface that has a run method
        // any class that implements runnable can be used for concurrency
        Runnable task = () -> {
            System.out.println(
                    Thread.currentThread().getName() +  ": Hello, How are you doing today ?");

        };
        Thread thread1 = new Thread(task, "greetingThread");


        thread1.start();

        // cannot start a thread again, once it is executed
        // throws IllegalThreadStarException
        //thread1.start();
    }
}

