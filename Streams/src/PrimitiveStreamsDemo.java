import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreamsDemo {
    // primitive streams are used to perform common mathematical operations
    // like average, sum, min, max which is not possible with actual streams
    // that deal with wrapper objects instead of primitives
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        System.out.println(stream1.reduce(0, (s, n) -> s + n)); // prints 6

        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        // converting Stream<Integer> to IntStream
        System.out.print("Sum: ");
        System.out.println(stream2.mapToInt(x -> x).sum()); // prints 6
        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.print("Average: ");
        avg.ifPresent(System.out::println);


        // converts a primitive stream into a normal stream
        Stream<Integer> stream4 = IntStream.of(1, 2, 3).boxed();

        stream4.forEach(System.out::println);


        var oneValue = DoubleStream.of(3.14);
        oneValue.forEach(System.out::println);

        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        varargs.forEach(System.out::println);

        // generates an infinite stream of random double numbers
        var random = DoubleStream.generate(Math::random);
        // sames as x = 0.5
        // x = x / 0.5 performed for specified number of times
        var fractions = DoubleStream.iterate(.5, d -> d / 2);
        // limits to 3 numbers or prints just the first 3 numbers in the infinite stream
        random.limit(3).forEach(System.out::println);
        // limits to 3 numbers or prints just the first 3 numbers after computation
        fractions.limit(3).forEach(System.out::println); // 0.5, 0.25, 0.125

        System.out.println("Exclusive Range");
        IntStream rangeExclusive = IntStream.range(1, 6);
        rangeExclusive.forEach(System.out::println);

        IntStream rangeInclusive = IntStream.rangeClosed(1, 5);
        System.out.println("Inclusive Range");
        rangeInclusive.forEach(System.out::println);


        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream integerStream = objStream.mapToInt(x -> x.length());

        DoubleStream doubleStream1 = DoubleStream.of(1, 3.3, 4.5);

        Stream<Double> doubleStream2 = doubleStream1.mapToObj(x -> x);

        // summarizing statistics
        // stats contain a statistics like sum, average, min and max of randomly generated integers from 1 t0 100
        IntSummaryStatistics stats = IntStream.generate(() -> (int) (Math.random() * 100 + 1)).limit(10).summaryStatistics();
        if (stats.getCount() != 0) System.out.println(stats.getMax() - stats.getMin());
    }
}
