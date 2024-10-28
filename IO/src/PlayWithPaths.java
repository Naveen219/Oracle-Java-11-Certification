import java.nio.file.Path;
import java.nio.file.Paths;

public class PlayWithPaths {
    public static void main(String[] args) {
            Path path1 = Paths.get("IO/examples/example.txt");
        Path path2 = Path.of("IO/examples/example2.txt");

        System.out.println(path1);

        System.out.println(path2);

        System.out.println("File Name: " + path1.getFileName());

        System.out.println("Is absolute: " + path1.isAbsolute());

        System.out.println("Parent: " + path1.getParent());

        System.out.println("Root: " + path1.getRoot());

        // Returns the concatenation of path1 and path2
        // Returns just path1 if path2 is empty
        // Returns just path1 if path2 is absolute path
        // Otherwise, returns the concatenation of path1 and path2
        Path path3 = path1.resolve(path2);

        // Resolves path2 against the  parent of path1
        Path resolveSiblingPath = path1.resolveSibling(path2);

        System.out.println("Resolve Sibling Path: " + resolveSiblingPath);
        System.out.println(path3);

        // Returns relative path of path1 to path2
        // Throws exception if either of the paths are absolute
        Path path4 = path1.relativize(path2);

        System.out.println(path4);



        Path path5 = Paths.get("/examples/../../examples");

        Path normalizedPath = path5.normalize();
        System.out.println(normalizedPath);

    }
}
