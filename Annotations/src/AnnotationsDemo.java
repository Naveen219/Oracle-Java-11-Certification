
@interface Dance {
    long rhythm() default 66;
    int[] value();
    String track() default "";
    final boolean fast = true;
}
class Sing {
    String album;
}



@Dance(value = {2, 3}, rhythm =  23)
@interface Cricket {
    // all elements are public static final by default, just like elements in an interface
     int a = 23;
     // default, default value should be a compile time a constant, cannot be a null or new String()
    // "" is a valid default value
    // the element type must be primitive type, a String, a Class, an enum, another
    // annotation or an array of any of these types. Note that this excludes wrapper
    // classes and arrays of arrays
     String batsman() default "Sehwag";
     //String batsman default "";
//     String batsman();
//    String  value();
    String[] value();
}

//@Cricket("Hello") valid with the string [] value and string value()
//@Cricket({"Hello", "Namaste"}) valid with String[]
//@Cricket(batsman = "Kohli", value = "Namaste") valid with batsman() and value()
public class AnnotationsDemo {
    public static void main(String[] args) {

    }


}
