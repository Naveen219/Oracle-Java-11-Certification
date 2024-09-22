public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.println("I'm a custom thread: " + Thread.currentThread().getName());
    }

}
