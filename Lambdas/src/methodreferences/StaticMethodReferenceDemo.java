package methodreferences;

import java.util.Arrays;
import java.util.List;

class StringUtils {
    public static String capitalize(String str) {
        return str.toUpperCase();
    }
}
public class StaticMethodReferenceDemo {

    // Method references are a special type of lambda expressions
    // They're are often used to create simple lambda expressions
    // by referencing existing methods
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("Lion", "Tiger", "Monkey", "Elephant");

        // both the statements below work the same
        animals.forEach(animal -> {
            System.out.println(StringUtils.capitalize(animal));
        });

        // uses the static method of an arbitrary class and calls the method for each argument
        animals.stream().map(StringUtils::capitalize).forEach(System.out::println);
    }
}