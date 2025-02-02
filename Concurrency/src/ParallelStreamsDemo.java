import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamsDemo {
    private static int doWork(int input) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println("Serial stream");
        long start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5)
                .stream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        var timeTaken =  (System.currentTimeMillis() - start) / 1000;
        System.out.println();
        System.out.println("Time taken: " + timeTaken + " seconds");


        System.out.println("Parallel stream");
        start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        timeTaken =  (System.currentTimeMillis() - start) / 1000;
        System.out.println();
        System.out.println("Time taken: " + timeTaken + " seconds");

        System.out.println("Foreach ordered");
        start = System.currentTimeMillis();
        // List.of(1, 2, 3, 5).stream().parallel() or
        List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .map(w -> doWork(w))
                //forces a parallel stream to process the results in order at the cost
                // of performance, but map function performs parallel decomposition to take
                // advantage of the parallel stream
                .forEachOrdered(s -> System.out.print(s + " "));
        timeTaken =  (System.currentTimeMillis() - start) / 1000;
        System.out.println();
        System.out.println("Time taken: " + timeTaken + " seconds");


        // Parallel Reductions
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        // always prints the first element from the stream
        System.out.println(list.stream().findAny().get());

        // prints a random element from the stream
        System.out.println(list.parallelStream().findAny().get());

        // always prints -21, as the stream is serial
        System.out.println(list.stream().reduce(0, (a, b) -> (a - b)));

        // result could be any value
        System.out.println(list.parallelStream().reduce(0, (a, b) -> (a - b)));

        List<String> animals = List.of("lions", "tigers", "bears");
        ConcurrentMap<Integer, String> map = animals
                .stream()
                .parallel()
                .collect(Collectors.toConcurrentMap(String::length,
                        k -> k,
                        (s1,  s2) -> s1 + "," + s2));

        System.out.println(map);

        // groups elements into a list based on the their length
         ConcurrentMap<Integer, List<String>> map1 = animals
                 .parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map1);
    }
}
