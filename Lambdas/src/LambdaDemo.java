import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.List;

public class LambdaDemo {

    private String messsage = "I'm in the class";

    public static void main(String[] args) {
        String message = "I'm in the main";
        Runnable runnable1 = new Runnable() {
            private String name = "I'm invevitable";
            @Override
            public void run() {
                System.out.println("I'm"   + " "  + Thread.currentThread().getName());
                System.out.println(message);
                // this accesses the instance field inside the Runnable
                System.out.println(this.name);
            }
        };

        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.DemoMultiThreadingUsingLambda();

        new Thread(runnable1).start();

//        List<Integer> numberList = List.of(1, 2, 3, 4, 7, 2, 5);
//        numberList.stream().forEach(System.out::println);

        System.out.println(Thread.activeCount());

        System.out.println(Thread.currentThread().getName());
    }

    public void DemoMultiThreadingUsingLambda() {
        // this refers to message of the object that's calling this method
        Runnable runnable2 = () -> System.out.println("I'm a lambda expression" + " "  +  this.messsage + "" +
                Thread.currentThread().getName());
        new Thread(runnable2).start();


    }
}
