import java.util.Arrays;
import java.util.TreeSet;

public class EnumDemo {
    enum Machine {
        // fields are static final by default
        AUTO("Truck"), MEDICAL("Scanner"), DEFAULT;
        protected String type;

        // constructors are private by default
        Machine() {
            System.out.println("I'm the default constructor");
        }
        Machine(String type) {
            System.out.println("I'm the parameterized constructor");
            this.type = type;
        }
        private void setType(String type) {
            this.type = type;
        }
        String getType() {
            return type;
        }


    }

    public static void main(String[] args) {
        System.out.println(Machine.valueOf(Machine.AUTO.name()));
        Machine.AUTO.setType("Sedan");
        for (Machine p : Machine.values()) {
            System.out.println(p.getType());
        }
        Sample sample  = new EnumDemo().new Sample();
        sample.print();
    }

    private class Sample {
        private  void print() {
            System.out.println("I'm a sample method");
        }
    }

}
