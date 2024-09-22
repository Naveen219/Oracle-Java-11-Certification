import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // Predicate Demo
        Predicate<Integer> evenNumberFilter = (a) -> a % 2 == 0;
        List<Integer> numbers = List.of(1, 2,  2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 18, 20);
        List<Integer> evenNumbers = numbers
                .stream()
                .filter(evenNumberFilter.and((a) -> a > 10))
                .collect(Collectors.toList());
        evenNumbers.forEach(System.out::print);

        System.out.println();


        // Consumer Demo
        Consumer<Integer> consumer = (a) ->{ System.out.print(a + 5 + " ");};

        numbers.stream().forEach(consumer);


        // Optional Demo





        List<Employee> employeeList = List.of(
                new Employee("Naveen", 24),
                new Employee("Virat", 24),
                new Employee("Dhoni", 28),
                new Employee("Rohit", 26)
        );

//        int index = 5;
//        try {
//            System.out.print(employeeList.get(index));
//        }
//        catch (Exception anyException) {
//            System.out.println("index out of bound exception");
//            anyException.printStackTrace();
//        }
//         Employee employeeOptional  = Optional.of(employeeList.get(25)).orElseThrow(
//                 () -> new RuntimeException("Element doesn't exist"));

//        if (employeeOptional.isPresent()) {
//            System.out.println("Employee: " + employeeList.get(index));
//        }
        System.out.println(employeeList);
        Employee []employees = employeeList.toArray(new Employee[employeeList.size()]);

        Arrays.stream(employees).forEach(System.out::println);


        // searching in streams

        Predicate<Integer> searchFilter = (a) -> a == 2;
        Optional<Integer> specificElement = numbers.stream().filter(searchFilter).findFirst();

        Optional<Integer> anyElement = numbers.stream().filter(searchFilter).findAny();

        specificElement.ifPresent(System.out::println);

        anyElement.ifPresent(System.out::println);

        boolean anyElementFound = numbers.stream().anyMatch(searchFilter);

        boolean noMatchFound  = numbers.stream().noneMatch(searchFilter);
        boolean allMatchFound = numbers.stream().allMatch(searchFilter);

        System.out.println(anyElementFound);

        System.out.println(noMatchFound);

        System.out.println(allMatchFound);


        // flatMaps

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(namesFlatStream);


        // advanced streams
        Stream<UUID> uuids  = Stream.generate(UUID::randomUUID);
        uuids.limit(10).forEach(System.out::println);

        Stream<BigInteger> powerOfTwos =  Stream.iterate(BigInteger.ONE,
                n -> n.multiply(BigInteger.TWO));
        powerOfTwos.limit(20).forEach(System.out::println);


        Stream<Character> alphabet = Stream.iterate('A',
                letter -> letter <= 'Z', letter -> (char)(letter + 1));
        alphabet.forEach(System.out::println);


        Stream.Builder<String> builder = Stream.builder();
        builder.add("one");
        builder.add("two");
        builder.add("three");
        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }
    private static class Employee {
        private String name;
        private Integer age;
        public Employee(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
