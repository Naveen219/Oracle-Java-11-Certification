import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static java.time.format.FormatStyle.SHORT;

public class LocalizingDatesDemo {
    public static void print(DateTimeFormatter dtf, LocalDateTime dateTime, Locale locale) {
        // prints the dateTime for the default locale
        System.out.println(dtf.format(dateTime));

        // prints the dateTime for the given locale
        System.out.println(dtf.withLocale(locale).format(dateTime));
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        var italy = new Locale("it", "IT");
        var dt = LocalDateTime.of(2020, Month.OCTOBER, 20, 15, 12, 34);

        // prints 10/20/20
        //  20/10/20
        print(DateTimeFormatter.ofLocalizedDate(SHORT), dt, italy);

        // prints 3:12 PM
        //  15:12
        print(DateTimeFormatter.ofLocalizedTime(SHORT), dt, italy);

        // prints 10/20/20, 3:12 PM
        // 20/10/20, 15:12
        print(DateTimeFormatter.ofLocalizedDateTime(SHORT, SHORT), dt, italy);


    }

}
