import java.io.FileNotFoundException;
import java.io.IOException;

interface Reader {
    public void read () throws IOException;
}
class Printer implements Reader {
    @Override
    // the child method can extend the exception behavior of the parent method but not modify or change it
    // FileNotFoundException is the child class of IOException class (valid case)
    // throws a compile time error if we try to add a new checked exception like SQLException
    // ArraysIndexOutOfBoundsException is allowed as it's a runtime exception.And it's optional
    // to declare Runtime Exceptions
    public void read() throws FileNotFoundException, ArrayIndexOutOfBoundsException {
        // logic to read data from the file
        throw new FileNotFoundException("File doesn't exist");
        // throw new IOException or new Exception throws a compile time error
        // as they are parent classes of FileNotFoundException and cannot be converted to
        // the child class without explicit casting
        // In other words, define the most generic exception that takes care of all the exceptions
        // thrown in the method
    }
}
public class ThrowsKeywordDemo {
    public static void main(String[] args) {
        Reader reader = new Printer();
        try {
            reader.read();
        } catch (IOException e) {
            // handles if there's an IOException
            e.printStackTrace();
        }
    }
}
