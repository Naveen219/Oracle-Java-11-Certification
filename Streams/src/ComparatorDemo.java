import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                    new Person("Naveen", 24),
                    new Person("Kohli", 25),
                    new Person("Dhoni", 24),
                    new Person("Rohit", 25)
        );
        // sorts the personsList based on the age. If two people have the same age, they get sorted based on thir name
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        List<Person> sortedList = personList.stream().sorted(ageComparator.reversed().thenComparing(nameComparator)).collect(Collectors.toList());
        System.out.println(sortedList);
    }
}
