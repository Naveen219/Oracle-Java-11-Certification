package methodreferences;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Reference : https://www.baeldung.com/java-method-references
public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");

        List<Bicycle> bicycleList1 = new ArrayList<>();
        for (String bikeBrand : bikeBrands) {
            bicycleList1.add(new Bicycle(bikeBrand));
        }
        bicycleList1.forEach(System.out::println);

        List<Bicycle> bicycleList2 = bikeBrands.stream()
                .map(Bicycle::new)
                .collect(Collectors.toList());

        bicycleList2.forEach(System.out::println);
    }
}
