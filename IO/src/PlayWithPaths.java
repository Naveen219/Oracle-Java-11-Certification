import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class PlayWithPaths {
    /**
     * Notes
     * If a path starts with a forward slash (/), it is absolute, with / as the root directory. Examples:
     * /bird/parrot.png and /bird/../data/./info
     *
     * If a path starts with a drive letter (c:), it is absolute, with the drive letter as the root directory.
     *
     * Examples: c:/bird/parrot.png and d:/bird/../data/./info
     * Otherwise, it is a relative path. Examples: bird/parrot.png and bird/../data/./info
     */
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
                    // returns full path of the containing directory
                    // returns null if operated on the root path or at the top of a relative path
                    System.out.println("Parent: " + file.getParent());
                    // returns the root element of the file within the file system or null if the path
                    // is a relative path
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

        // path1 -> abcPath
        // path2 -> xyzPath
        // Returns the concatenation of path1 and path2
        // Returns  path1 if path2 is empty
        // Returns path2 if path2 is absolute. In other words, you can't add a relative path to
        // an absolute path
        // Otherwise, returns the concatenation of abcPath path1 and path2
        Path path3 = abcPath.resolve(xyzPath);

        // Resolves path2 against the  parent of abcPath
        Path resolveSiblingPath = abcPath.resolveSibling(xyzPath);

        System.out.println("Resolve Sibling Path: " + resolveSiblingPath);
        System.out.println(path3);

        // Returns relative path of abcPath to xyzPath
        // Throws exception if either of the paths are absolute
        // what steps would abcPath require to reach xyzPath
        // both the abcPath and xyzPath have to be absolute or relative
        // if they are absolute, they should have the same root
        Path path4 = abcPath.relativize(xyzPath);

        System.out.println(path4);


        /// removed the redundancies like the parent directory ../
        // and the current directory ./
        var path5 = Paths.get("/pony/../weather.txt");
        var path6 = Paths.get("/weather.txt");
        System.out.println(path5.equals(path6));
        System.out.println("Path5 == Path6: " + path5.normalize().equals(path6.normalize()));

        Path normalizedPath = path5.normalize();
        System.out.println(normalizedPath);


        //Real Path demo

        System.out.println("Real Paths Demo");
        try {
            // Normalizes the and returns the absolute path
            System.out.println(Paths.get("IO/examples/./paths/./abc.txt").toRealPath());
            System.out.println("Present Working Directory: " + Paths.get(".").toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
