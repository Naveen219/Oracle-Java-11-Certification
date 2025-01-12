import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTraversalDemo {
    // Depth First Search:  depth-first search traverses the structure from the root to an arbitrary leaf and then
    //navigates back up toward the root, traversing fully down any paths it skipped along the way. The search
    //depth is the distance from the root to current node. To prevent endless searching, Java includes a search
    //depth that is used to limit how many levels (or hops) from the root the search is allowed to go.

    // Breadth First Search: a breadth-first search starts at the root and processes all elements of each particular depth,
    //before proceeding to the next depth level. The results are ordered by depth, with all nodes at depth 1 read
    //before all nodes at depth 2, and so on. While a breadth-first tends to be balanced and predictable, it also
    //requires more memory since a list of visited nodes must be maintained.

    private static long getSize(Path p) {
        try {
            return Files.size(p);
        } catch (Exception anyException) {
            anyException.printStackTrace();
        }
        return 0L;
    }

    public static void main(String[] args) {
        Path source = Path.of("IO/examples");
        try (var s = Files.walk(source)) {
            var size = s.parallel()
                    .filter(p -> !Files.isDirectory(p))
                    .peek((p) -> System.out.println("File name : " + p))
                    .mapToLong(FileTraversalDemo::getSize)
                    .sum();
            System.out.println(size);
            System.out.printf("Tatal size %.2f kilobytes", (size / 1000.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();


        long minSize = 10;
        //The two parameters of the BiPredicate are a Path object and a BasicFileAttributes object
        //In this manner, NIO.2 automatically retrieves the basic file information for you,
         // allowing you to write complex lambda expressions that have direct access to this object.

        // searches the given path and prints all .txt files with a size of at least 5 bytes ,
        // using a depth limit of 10
        System.out.println("Find Method Demo: ");
        try (var s = Files.find(source, 10, (p, a) -> {
            return a.isRegularFile() && p.toString().endsWith(".txt") && a.size() > minSize;
        })) {
            s.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Files.readAllLines() could result in an OutOfMemoryError as the method tries to all the
        // content into the memroy at one short


        // Files.lines is use to read the content and process lazily which means only a small
        // portion of the file is stored in memory at any given time
        Path path = Paths.get("IO/examples/months.txt");
        try (var s = Files.lines(path)) {
            s.filter(f -> f.contains("u"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
