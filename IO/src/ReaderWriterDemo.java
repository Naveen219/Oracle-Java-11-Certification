import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterDemo {
    public static void main(String[] args) {
        /**
         Reader is an abstract class that contains a read method to read the data in bytes
         int read() throws IOException

         FileReader     -> Reads file data as characters

         BufferedReader -> Reads character data from an existing Reader in a buffered manner,
         which improves efficiency and performance

         */

        try (var reader = new FileReader("IO/examples/greeting.txt")
             ; var writer = new FileWriter("IO/examples/greetings-copy.txt")) {
            int b;
            while ((b = reader.read()) != -1) {
                System.out.print((char) b);
                writer.write(b);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        /**
         Writer is an abstract class that contains a write method to write the data in bytes
         void write(int bytes) throws IOException

         FileWriter -> Writes file data as characters

         BufferedWriter-> Writes character data from an existing Writer in a a buffered manner,
         which improves efficiency and performance
         **/

    }
}
