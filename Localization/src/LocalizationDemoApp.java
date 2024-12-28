import java.util.Locale;

public class LocalizationDemoApp {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        // prints the default local in language_country format
        // e.g en_US
        // country is optional
        // the language is always in lower case and the country in upper case
        System.out.println(locale);

        // prints just the language -> de
        System.out.println(Locale.GERMAN);

        // prints the language along with the country code -> de_DE
        System.out.println(Locale.GERMANY);

        // creates a locale object containing the values (Hindi, India)
        Locale indiaLocale1 = new Locale("hi", "IN");

        Locale indiaLocale2 = new Locale.Builder()
                .setLanguage("HI")
                .setRegion("IN")
                .build();
        // prints hi_IN
        System.out.println(indiaLocale1);

        // prints hi_IN
        System.out.println(indiaLocale2);

    }
}
