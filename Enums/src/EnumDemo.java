public class EnumDemo {
    enum Machine {
        AUTO("Truck"), MEDICAL("Scanner");
        private String type;
        Machine(String type) {
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
