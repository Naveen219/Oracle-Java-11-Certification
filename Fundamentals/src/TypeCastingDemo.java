
/*
 * @author Vunnam, Kumar Naveen
 * @since  11/19/2024
 */


class A {
    String name = "Naveen";
    String getName() {
        return this.name;
    }
    public void print() {
        System.out.println("I'm class A");
    }

}
class B extends A {
    String name = "Kohli";
    String city = "Delhi";
    String getName() {
        return this.name;
    }
    String getCity() {
        return this.city;
    }
    public void print() {
        System.out.println("I'm class B");
    }

}

public class TypeCastingDemo {
    public static void main(String[] args) {
        // b is implicitly an object of A as B extends A
        B b = new B();

        // b is type of parent i.e A
        // a can access the all variables of the parent and the overridden methods of B
        // cannot access child class variables or fields
        // Runtime Polymorphism -> Methods are invoked at the run time based on the run time instance

        A a = new B();



        System.out.println("B is an instance of B: " + (b instanceof B));
        System.out.println("B is an instance of A: " + (b instanceof A));
        System.out.println("A is an instance of A: " + (a instanceof A));
        System.out.println("A is an instance of B: " + (a instanceof B));

        System.out.println(b.getName());

        // prints Kohli as 'a' is created at runtime and overrides the getName method
        System.out.println(a.getName());
        System.out.println(a.name);

        // b is implicitly an object of A as B extends A
        // cannot access child class attributes and methods after upcasting except for overridden methods
        // prints "I'm class B", since child class overrides the print method
        ((A)(b)).print();

        // downcasting a of type A to type B to just access the child class methods
        // downcasting allows you to access child class methods and attributes
        System.out.println(((B)a).getCity());

    }
}