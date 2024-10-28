public class InterfaceDemo {
    public static void main(String[] args) {
        Person person = new InterfaceDemo().new Employee();

        System.out.println(person.getName());


    }

    private interface Person {

        String getName();

    }

    private class Employee implements  Person {

        @Override
        public String getName() {
            return "I'm a batman";

        }
    }
}
