package concurrency.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {}
class Water{}

class Fox {
    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println("Got Food!");
            move();
            synchronized (water) {
                System.out.println("Got water!");
            }
        }
    }
    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println("Got Water!!");
            move();
            synchronized (food) {
                System.out.printf("Got Food!!");
            }
        }
    }
    public void move() {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            // handle exception
        }
    }
}
public class DeadlockDemo {
    public static void main(String[] args) {
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food = new Food();
        Water water = new Water();
        ExecutorService service = null;
        try {
           service = Executors.newScheduledThreadPool(10);
           service.submit(() -> tails.drinkAndEat(food, water));
            service.submit(() -> foxy.eatAndDrink(food, water));
        }
        finally {
            if (service != null) service.shutdown();
        }
    }
}
