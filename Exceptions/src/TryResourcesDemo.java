class MyFileReader implements  AutoCloseable {
    private String tag;
    public MyFileReader(String tag) {
        this.tag = tag;
    }

    @Override
    public void close() throws Exception{
        System.out.println("Closed: " + tag);
    }
}
// Reference: https://jenkov.com/tutorials/java-exception-handling/try-with-resources.html
public class TryResourcesDemo {

    public static void main(String[] args) {
        // effectively final -> can be initialized only once before its used
        final var bookReader = new MyFileReader("Monkey");
        var bookReader2 = new MyFileReader("Dog");
        // all the variables declared in try-resources block are implicitly final
        // any attempt to reinitialize them will result in a compile time error
        try (bookReader; bookReader2) {
            System.out.println("Try Block");
            // Resources are closed in the reverse order of their declaration
            // before the control reaches any of the catch or finally blocks
            // i.e Dog, Monkey irrespective of exception being thrown
            throw new Exception("Exception Encountered");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            System.out.println("I'm the final block of try-resources statement");
        }
    }
}
