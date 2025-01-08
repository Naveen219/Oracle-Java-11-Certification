import java.io.File;
import java.io.IOException;

public class PlayWithFiles {
    public static void main(String[] args) {
        File file1 = new File("IO/examples/sample.txt");
        File file2 = new File("examples");
        try {
            // Return true : If the file doesn't exist
            // Returns false: If the file already exists
            System.out.println(
                    file1.createNewFile() ? "File has been created: " + file1.getName()
                                          : "File already exists"
            );

            System.out.println(file1);
            System.out.println("Does Exist: " + file1.exists());
            System.out.println("is Directory: " + file1.isDirectory());
            System.out.println("Is File: " + file1.isFile());

            System.out.println("File Name: " + file1.getName());
            System.out.println("Parent Name: " + file1.getParent());
            System.out.println("Path : " + file1.getPath());

            // prints the file path passed to the file constructor
            System.out.println("Absolute Path: " + file1.getAbsolutePath());

            // prints the path that is a valid system path
            System.out.println("Canonical Path: " + file1.getCanonicalPath());

            System.out.println(file2);
            file2.mkdir();
            System.out.println(
                    file1.mkdir() ? "A directory has been created: " + file2.getName()
                            : "Directory already exists"
            );
            System.out.println("Does Exist: " + file2.exists());
            System.out.println("is Directory: " + file2.isDirectory());
            System.out.println("Is File: " + file2.isFile());

            System.out.println("File Name: " + file2.getName());

            //returns null as the parent doesn't exist
            System.out.println("Parent Name: " + file2.getParent());

            File file3 = new File("IO/emptyFolder");

            // can't be deleted as the directory is not empty
            System.out.println(file2.delete());

            // deletes the directory as it is empty
            System.out.println(file3.delete());
        }
        catch (IOException exception) {
            System.out.println("Error creating file");
            System.out.println(exception);
        }
    }

}
