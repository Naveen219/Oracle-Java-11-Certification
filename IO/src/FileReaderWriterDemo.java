import java.io.*;

public class FileReaderWriterDemo {
    /*
     //A class with the word InputStream or OutputStream in its name is used for reading or writing binary
     or byte data, respectively.
     //A class with the word Reader or Writer in its name is used for reading or writing character or string
     data, respectively.
     //Most, but not all, input classes have a corresponding output class.
     //A low-level stream connects directly with the source of the data.
     //A high-level stream is built on top of another stream using wrapping.
     //A class with Buffered in its name reads or writes data in groups of bytes or characters and often
     improves performance in sequential file systems.
     // With a few exceptions, you only wrap a stream with another stream if they share the same abstract
      parent.

     */
    /*
    Class Name               Description
    InputStream         Abstract class for all input byte streams
    OutputStream        Abstract class for all output byte streams
    Reader              Abstract class for all input character streams
    Writer              Abstract class for all output character streams

     */
    public static void main(String[] args) {
        try (var inputReader= new FileReader("IO/examples/greeting.txt")
             ;var outputReader = new FileWriter("IO/examples/greetings-copy.txt")) {
            int b;
            while ((b = inputReader.read()) != -1) {
                System.out.print((char)b);
                outputReader.write(b);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
