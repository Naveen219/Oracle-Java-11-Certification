import java.io.*;

public class IOStreamDemo {
    public static void main(String[] args) {
        /**
         InputStream is an abstract class that contains a read method to read the date in bytes
         int read() throws IOException

         FileInputStream     -> Reads file data as bytes

         BufferedInputStream -> Reads byte data from an existing InputStream in  a buffered manner,
                                which improves efficiency and performance

         ObjectInputStream -> Deserializes primitive Java data types and graphs of Java objects to an existing
                                InputStream

         */

        try (var inputStream = new FileInputStream("IO/examples/greeting.txt")
             ;var outputStream = new FileOutputStream("IO/examples/greetings-copy.txt")) {
            int b;
            while ((b = inputStream.read()) != -1) {
                System.out.print((char)b);
                outputStream.write(b);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (var bufferedInputStream = new BufferedInputStream(new FileInputStream("IO/examples/months.txt"));
             var bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("IO/examples/months-copy.txt")))   {
            byte []buffer = new byte[10];
            int lengthRead;
            while ((lengthRead = bufferedInputStream.read(buffer)) > 0) {
                bufferedOutputStream.write(buffer, 0, lengthRead);

                // to flush output to the file in each iteration instead of flushing the output at the end
                // when the close() method gets called after the try block execution because of try resources statement
                bufferedOutputStream.flush();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        /**
         OutputStream is an abstract class that contains a write method to write the data in bytes
         void write(int bytes) throws IOException

         FileOutputStream -> Writes file data as bytes

         BufferedOutputStream -> Writes byte data from an existing InputStream in a a buffered manner,
                                 which improves efficiency and performance

         ObjectOutputStream -> Serializes primitive Java data types and graphs of Java objects to an existing
                                OutputStream



         **/

    }
}
