import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class CustomException extends Exception{

    public CustomException() {
        super();
    }
    public CustomException(String msg) {
        super(msg);
    }
    public CustomException(String msg, Exception ex) {
        super(msg, ex);
    }

}
public class CustomExceptionDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        int []arr = new int[]{1, 2, 3, 4};
        int res = 0;
        try {
             //res = num1 / num2;
            System.out.println(res);
            System.out.println(arr[5]);
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
            // handles ArithmeticException and ArrayIndexOutOfBoundsException, but not a good practise to a handle exceptions
            // Exceptions that are related, cannot be handled this way
            // FileNotFoundException is a child class of IOException
            // catch(FileNotFoundException | IOException) throws a compile time error
            ex.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("I'm a generic exception handler");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            String userPath = Paths.get("").toAbsolutePath().toString();
            Path path = Paths.get( userPath,"/Exceptions/src/names.txt");
            if (Files.exists(path)) {
                System.out.println();
                FileReader file = new FileReader(path.toFile());
                String content = "";
                int x;
                while (( x = file.read()) != -1) {
                    content += (char)x;
                }
                System.out.println(content);

            }
        }
        // exceptions for inherited class have to be defined this way
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            throw new CustomException("I'm a custom exception");
        }
        catch (CustomException ex) {
            System.out.println("I'm the specific exception handler");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("I'm a generic exception handler");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            // executes irrespective of exception being thrown
            // try should always be followed by catch or finally for Checked Exceptions or else compiler throws an error
            System.out.println("I'm the final block of CustomException");
        }

    }

}
