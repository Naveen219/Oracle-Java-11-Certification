import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class NIOFilesDemo {
    public static void main(String[] args) {
        System.out.println("Is same File");

        Path path1 = Paths.get("a/b");
        Path path2 = Paths.get("a/b");
        //The method takes two Path objects as input, resolves all path symbols, and follows symbolic links.
        //Despite the name, the method can also be used to determine whether two Path objects refer to the same directory.
        // returns true if path1 and path2 contain the same value despite file not being present
        try {
            System.out.println("Is Same File: " + Files.isSameFile(path1, path2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path3 = Paths.get("IO/examples/paths/test-dir");
        Path path4 = Paths.get("IO/examples/paths/test-dir/abc/xyz");

        // Create directory() will create a directory and thrown an exception if it already
        // exists or the paths leading up to the directory do not exist
        try {
            System.out.println("Directory created:  " + Files.createDirectory(path3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //The createDirectories() works just like the java.io.File method mkdirs(), in that it creates the
            //target directory along with any nonexistent parent directories leading up to the path. If all the directories
            //already exist, createDirectories() will simply complete without doing anything.
            System.out.println("Directories created: "  + Files.createDirectories(path4));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path5 = Paths.get("IO/examples/days.txt");
        Path path6 = Paths.get("IO/examples/days-copy.txt");
        //
        try {
            // will throw an exception if the target already exists without the
            // Replace existing option
            //throws an exception if the source file doesn't exist
            System.out.println(Files.copy(path5, path6, StandardCopyOption.REPLACE_EXISTING));

            // prints the content in the file referred by path6 to the console
            Files.copy(path6, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            //An atomic move is one in which a file is moved within the file system as a single
            //indivisible operation. Put another way, any process monitoring the file system never sees an incomplete or
            //partially written file. If the file system does not support this feature, an
            //AtomicMoveNotSupportedException will be thrown.
            Files.move(Paths.get("IO/examples/paths/planets.txt"), Path.of("IO/examples/archive/planets-archived.txt"),
                    StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // deletes the file if it exists or else it throws an FileNotFoundException
            // To delete a directory, it must be empty
            // If the path is a symbolic link, the symbolic link will not be deleted,
            // not the path that the symbolic points to
            Files.delete(Paths.get("IO/examples/example.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (Files.deleteIfExists(Paths.get("IO/examples/example.txt"))) {
                System.out.println("File has been deleted");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        var path7 = Path.of("/IO/examples/months.txt");
        try {
            //newBufferedReader(), reads the file specified at the Path location using a
            //BufferedReader object.
            try (var reader = Files.newBufferedReader(path7)) {
               String currentLine = null;
               while ((currentLine = reader.readLine()) != null) {
                   System.out.println(currentLine);
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        var animalList = new ArrayList<String>();
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Elephant");
        animalList.add("Fox");
        var path8 = Path.of("IO/examples/animals.txt");
        try {
            //newBufferedWriter(), writes to a file specified at the Path location using a
            //BufferedWriter
            try (var writer = Files.newBufferedWriter(path8)) {
                for (var line : animalList) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

