import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalizingNumbersDemo {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        Locale germanLocale = Locale.GERMANY;


        // a general purpose formatter
        // prints 23,000,000,000
        System.out.println(NumberFormat.getInstance(defaultLocale).format(23_000_000_000L));
        System.out.println(NumberFormat.getNumberInstance(defaultLocale).format(23_000_000_000L));

        // a general purpose formatter
        // prints 23.000.000.000
        System.out.println(NumberFormat.getInstance(germanLocale).format(23_000_000_000L));
        System.out.println(NumberFormat.getNumberInstance(germanLocale).format(23_000_000_000L));


        // creating indian locale object
        Locale locale = new Locale.Builder()
                .setLanguage("hi")
                .setRegion("IN")
                .build();

        // Currency instances
        String income = "$120000.88";
        var cf = NumberFormat.getCurrencyInstance();
        try {
            double value = (Double) cf.parse(income);
            System.out.println(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // custom Number Formatter
        /*
             Symbol             Meaning                                    Examples
              #         Omit the position if no digit exists for it         $2.2
              0         Put a 0 in the position if no digit exists for it      $002.20
         */
        double value = 1234567.467;
        NumberFormat f1 = new DecimalFormat("$###,###,###.0");
        System.out.println(f1.format(value));
        NumberFormat f2 = new DecimalFormat("$000,000,000.000000");
        System.out.println(f2.format(value));
        NumberFormat f3 = new DecimalFormat("$#,###,###.##");
        System.out.println(f3.format(value));


    }
}
