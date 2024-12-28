import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    public static void main(String[] args) {
        var us = new Locale("en", "US");
        var france = new Locale("fr", "FR");
        printWelcomeMessage(us);
        printWelcomeMessage(france);


        /*
                Picking a Resource Bundle
                Step                   Looks for file                          Reason
                1                      Zoo_fr_FR.properties           The requested locale
                2                      Zoo_fr.properties              The language we requested with no country
                3                      Zoo_en_US.properties           The default Locale
                4                      Zoo_en.properties              The default locale's language with no country
                5                      Zoo.properties                 No locale at all - the default bundle
                6                    If still not found, throw        No locale or default bundle available
                                      MissingResourceException

        1. Look for the resource bundle for the requested locale, followed by the one for the default locale.
        2. For each locale, check language/country, followed by just the language.
        3. Use the default resource bundle if no matching locale can be found.
         */
    }

    private static void printWelcomeMessage(Locale locale) {
        /*
        Resource Bundle is a file that contains all the mappings
        It's basically Map that contains key, value pairs
         */
        // the value "Zoo" should match with the file prefix
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}
