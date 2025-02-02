import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDemo {
    /**
     *           Symbol                      Meaning              Examples
     *            y or Y                      Year              20, 2020
     *            M,MM, MMM, MMMM             Month             1, 01, Jan, January
     *            d,dd                         day              5, 05
     *            h, hh                       Hour              9, 09
     *            m                           Minute            45
     *            s                           Second            52
     *            a                           a.m/p.m           A.M, P.M
     *            z                         Time Zone Name      Eastern Standard Time, EST
     *            Z                         Time Zone Offset    -0400
     */
    public static void main(String[] args) {

        LocalDateTime localDateTime1 = LocalDateTime.now();

        // prints  2024-12-28T23:32:15.162637800 (time when I executed on my system)
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.of(2024, Month.DECEMBER, 28, 23, 30, 20);

        // prints 2024-12-28T23:30
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        // prints 2024-12-28T23:32:15.163637400 (time when I executed on my system)
        System.out.println(localDateTime3);

        // prints 23
        System.out.println(localDateTime2.getHour());

        // prints 30
        System.out.println(localDateTime2.getMinute());

        // prints 20
        System.out.println(localDateTime2.getSecond());

        // prints 0
        System.out.println(localDateTime2.getNano());

        DateTimeFormatter dft = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // prints 2024-12-28T23:30:20
        System.out.println(localDateTime2.format(dft));

        // prints 2024-12-28T23:30:20
        System.out.println(dft.format(localDateTime2));


        // prints 28/12/2024 11:30:20 PM
        DateTimeFormatter customDft = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");

        System.out.println(customDft.format(localDateTime2));

        // Adding Custom Text Values
        // the text 'at' is ignored as it's wrapped within single quotes
        var dft2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm:ss a");

        // December 28, 2024 at 11:30:20 PM
        System.out.println(localDateTime2.format(dft2));

        // an extra ' is added after the text 'Party's' to escape the symbol '
        // December 28, Party's at 11:30
        var dft3 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
        System.out.println(dft3.format(localDateTime2));
    }
}
