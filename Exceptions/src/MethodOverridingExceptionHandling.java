/**
 * According to overriding rules, if super class
 * or interface method declares to throw a checked exception,
 * then overriding method of sub class / implementer class has following options:
 * 1. May not declare to throw any checked exception.
 * 2. May declare to throw the same checked exception thrown by super class / interface method.
 * 3. May declare to throw the sub class of the exception thrown by super class / interface method.
 * 4. Cannot declare to throw the super class of the exception thrown by super class / interface method.
 * 5. Cannot declare to throw unrelated checked exception.
 * 6. May declare to throw any RuntimeException or Error.
 *
 *
 *
 */
class Parent {

    void print() {
        System.out.println("I'm parent");
    }

}
class Child extends Parent {
    // if parent method throws a checked exception
    // can declare a runtime exception, or a subclass of a parent method exception or may not declare any exception
    // and cannot declare a new checked exception
    // if parent method doesn't throw a check exception
    // child method cannot a throw a new checked exception
    void print() {
        System.out.println("I'm child");
    }
}
public class MethodOverridingExceptionHandling {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.print();
        System.out.println();

    }

}
