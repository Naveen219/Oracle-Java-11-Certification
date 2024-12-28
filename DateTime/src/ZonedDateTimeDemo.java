import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDemo {
    public static void main(String[] args) {

        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();

       // prints  2024-12-29T00:28:50.301317+05:30[Asia/Calcutta]
        System.out.println(zonedDateTime1);

        // prints Asia/Calcutta as my system uses Asia/Calcutta time zone
        System.out.println(zonedDateTime1.getZone());

        // prints +05:30 as Asia/Calcutta time zone is 5:30 ahead of GMT/UTC
        System.out.println(zonedDateTime1.getOffset());

        LocalDate localDate = LocalDate.of(2024, Month.DECEMBER, 28);
        LocalTime localTime = LocalTime.of(23, 30, 40);
        // prints the availableZoneIds
        System.out.println(ZoneId.getAvailableZoneIds());

        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDate, localTime, ZoneId.of("America/New_York"));

        // prints 2024-12-28T23:30:40-05:00[America/New_York]
        System.out.println(zonedDateTime2);

        DateTimeFormatter isoInstant = DateTimeFormatter.ISO_INSTANT;

        //prints 2024-12-29T04:30:40Z
        System.out.println(isoInstant.format(zonedDateTime2));

        DateTimeFormatter isoZonedDateTime = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        // prints 2024-12-28T23:30:40-05:00[America/New_York]
        System.out.println(isoZonedDateTime.format(zonedDateTime2));

    }
}
