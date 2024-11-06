import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class PlayWithPaths {
    public static void main(String[] args)  {
        Path abcPath = Paths.get("IO/examples/paths/abc.txt");
        Path xyzPath = Path.of("IO/examples/paths/xyz.txt");
        Path testPath = Path.of("IO/examples/paths/test");
        Path abcSymLink = Path.of("IO/examples/symbolicLink/abc-sym-link");
        Path testSymLink = Path.of("IO/examples/symbolicLink/test-sym-link");
        Path absAbsPath =
                Paths.get("C:/Users/Administrator/Desktop/Java 11 Certification/coding-practice/IO/examples/paths/abc.txt");

        try {
            Files.list(Paths.get("IO/examples/paths")).forEach((file) -> {
                try {

                    System.out.println("<------------" + "Operations on " + file.getFileName() + " " + "--------->");
                    System.out.println("Is Absolute: " + file.isAbsolute());
                    System.out.println("Parent: " + file.getParent());
                    System.out.println("Root: " + file.getRoot());
                    System.out.println("Is Symbolic Link: " + Files.isSymbolicLink(file));
                    System.out.println("Is Directory: " + Files.isDirectory(file));
                    System.out.println("Is Regular file: " + Files.isRegularFile(file));
                    System.out.println("Last Modified time: " + new Date(Files.getLastModifiedTime(file).toMillis()));
                    System.out.println("File Size:" + Files.size(file));
                    System.out.println("Is Readable: " + Files.isReadable(file));
                    System.out.println("Is Writable: " + Files.isWritable(file));
                    System.out.println("Is Executable: " + Files.isExecutable(file));
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                //user/abc.txt
                // lion

            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (var directory = Files.newDirectoryStream(Paths.get("IO/examples/symbolicLink"))) {
            for (Path file : directory) {
                System.out.println("<------------" + "Operations on " + file.getFileName() + " " + "--------->");
                System.out.println("Is Absolute: " + file.isAbsolute());
                System.out.println("Parent: " + file.getParent());
                System.out.println("Root: " + file.getRoot());
                System.out.println("Is Symbolic Link: " + Files.isSymbolicLink(file));
                System.out.println("Is Directory: " + Files.isDirectory(file));
                System.out.println("Is Regular file: " + Files.isRegularFile(file));
                System.out.println("Is Readable: " + Files.isReadable(file));
                System.out.println("Is Writable: " + Files.isWritable(file));
                System.out.println("Is Executable: " + Files.isExecutable(file));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("<------------" + "Operations on " + absAbsPath.getFileName() + " " + "--------->");
        System.out.println("Is Absolute: " + absAbsPath.isAbsolute());
        System.out.println("Parent: " + absAbsPath.getParent());
        System.out.println("Root: " + absAbsPath.getRoot());
        System.out.println("Is Symbolic Link: " + Files.isSymbolicLink(absAbsPath));
        System.out.println("Is Directory: " + Files.isDirectory(absAbsPath));
        System.out.println("Is Regular file: " + Files.isRegularFile(absAbsPath));
        System.out.println("Is Readable: " + Files.isReadable(absAbsPath));
        System.out.println("Is Writable: " + Files.isWritable(absAbsPath));
        System.out.println("Is Executable: " + Files.isExecutable(absAbsPath));

        try {
            System.out.println("Resolving Symbolic Link for: " + testSymLink + " "  + Files.readSymbolicLink(testSymLink));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if(Files.isDirectory(testSymLink) && Files.isSymbolicLink(testSymLink)) {
            try {
                Files.createDirectory(testSymLink.resolve("testABC"));
                System.out.println("New directory is created in the test folder");
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        // Returns the concatenation of abcPath and path2
        // Returns just abcPath if path2 is empty
        // Returns just abcPath if path2 is absolute path
        // Otherwise, returns the concatenation of abcPath and path2
        Path path3 = abcPath.resolve(xyzPath);

        // Resolves path2 against the  parent of abcPath
        Path resolveSiblingPath = abcPath.resolveSibling(xyzPath);

        System.out.println("Resolve Sibling Path: " + resolveSiblingPath);
        System.out.println(path3);

        // Returns relative path of abcPath to path2
        // Throws exception if either of the paths are absolute
        Path path4 = abcPath.relativize(xyzPath);

        System.out.println(path4);


        Path path5 = Paths.get("/examples/../../examples");

        Path normalizedPath = path5.normalize();
        System.out.println(normalizedPath);

    }
}
