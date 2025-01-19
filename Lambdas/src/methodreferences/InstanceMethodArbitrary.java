package methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InstanceMethodArbitrary {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);

        List<Integer> numbers1 = new ArrayList<>(numbers);

        List<Integer> numbers2 = new ArrayList<>(numbers);

       List<Integer> result1 =  numbers1.stream()
                .sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());


        List<Integer> result2 =  numbers2.stream()
                .sorted(Integer::compare).collect(Collectors.toList());

        // prints true
        System.out.println(result1.equals(result2));
    }
}
