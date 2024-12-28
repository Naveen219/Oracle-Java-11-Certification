import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.now();
        // prints the current local date
        // prints in YYYY-MM-DD format
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.of(2024, Month.DECEMBER, 28);

        System.out.println(localDate2);

        // prints SATURDAY
        System.out.println(localDate2.getDayOfWeek());

        // prints DECEMBER
        System.out.println(localDate2.getMonth());

        // prints 2024
        System.out.println(localDate2.getYear());

        // prints 363
        System.out.println(localDate2.getDayOfYear());

        // prints 28
        System.out.println(localDate2.getDayOfMonth());

        // default format -> YYYY-MM-DD
        DateTimeFormatter dft = DateTimeFormatter.ISO_LOCAL_DATE;

        // prints 2024-12-18
        System.out.println(localDate2.format(dft));

        // prints 2024-12-18
        System.out.println(dft.format(localDate2));

        DateTimeFormatter customDft = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // prints 28/12/2024
        System.out.println(customDft.format(localDate2));

        // parses the text in the format specified into local date object
        // throws parseException if the string is not in the given format
        System.out.println(LocalDate.parse("28/12/2024", customDft));


    }
}
