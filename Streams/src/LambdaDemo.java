
import java.util.List;


@FunctionalInterface
interface EmployeeFilter<T> {
    int age = 20;
    boolean flag = false;
    boolean test(T t);
     static void name() {
        System.out.println("Hello");
        print();
    }
    private static void print() {
         System.out.println("I'm a private static method");
    }
}
class EmployeeFilterImpl implements  EmployeeFilter<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() < 25;
    }
}
class Employee {
    private int age;
    private String name;
    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
}
public class LambdaDemo {

    private String messsage = "I'm in the class";

    private static void printEmployeeLessThanTheAge(List<Employee> employeeList, EmployeeFilter<Employee> employeeFilter) {
        EmployeeFilter.name();
        for (Employee e : employeeList) {
            if (employeeFilter.test(e)) {
                System.out.println(e.getName());
            }
        }
    }
    public static void main(String[] args) {

        List<Employee> employeeList = List.of(new Employee(23,"Naveen Kumar"),
                                              new Employee(24, "Virat Kohli"),
                                              new Employee(35, "MS Dhoni"),
                                              new Employee(40, "Rohit Sharma"));


//        EmployeeFilter<Employee> ageFilter = e -> e.getAge() < 25;
        EmployeeFilter<Employee> ageFilter = new EmployeeFilter<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;

            }
        };
        String message = "I'm in the main";

        printEmployeeLessThanTheAge(employeeList, ageFilter);
        printEmployeeLessThanTheAge(employeeList,  e -> e.getAge() < 25);
        printEmployeeLessThanTheAge(employeeList, new EmployeeFilterImpl());
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
