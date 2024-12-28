import java.text.NumberFormat;
import java.util.Locale;

public class LocaleCategoryDemo {
    public static void printCurrency(Locale locale, double money) {
        System.out.println(NumberFormat.getCurrencyInstance().format(money) + " " + locale.getDisplayLanguage());
    }
    public static void main(String[] args) {
       var spain = new Locale("es", "ES");
       var money = 1.23;


       // print with default locale
        Locale.setDefault(new Locale("en", "US"));
        printCurrency(spain, money); // $1.23, Spanish

        // print with default locale and selected local display
        Locale.setDefault(Locale.Category.DISPLAY, spain);
        printCurrency(spain, money); // / $1.23, español

        // print with default locale and selected local display
        Locale.setDefault(Locale.Category.FORMAT, spain);
        printCurrency(spain, money); //  1,23 €, español


    }
}
