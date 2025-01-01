
/*
 * @author Vunnam, Kumar Naveen
 * @since  11/20/2024
 */

class Parent {
    String name = "Parent";
    Parent() {
        System.out.println("Hello, I'm the constructor of the parent class");
    }
    void Super() {
        System.out.println("Hello, I'm the Super method of the parent class");
    }
    Parent(String name) {
        this.name = name;
        System.out.println("I'm the parameterized constructor of the child class");
    }
    public void print() {
        System.out.println("Hello, I'm the print method in the parent class");
    }
        static class SubClass  {
       public void print() {

       }
     }
}

class Child extends Parent {
    String name = "Child";
    Child() {
        System.out.println("Hello, I'm the constructor of the child class");
        // su
        Super();
    }
    Child(String name) {
        // this and supper cannot be used together in the same scope
        //super();
        this();
        this.name = name;
        System.out.println("I'm the parameterized constructor of the child class");
    }
    public void print() {
        System.out.println("Hello, I'm the print method in the child class");
    }
}

public class SuperKeywordDemo {
    public static void main(String[] args) {
        new Child("Naveen");
    }

}
