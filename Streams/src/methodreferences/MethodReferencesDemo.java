package methodreferences;

interface Creator<T>  {
    Log create(T t);
}
class Log {
    Log() {
        System.out.println("Hello, How are you doing today?");
    }
    Log(String name) {
        System.out.println("Hello," + name + " " + " How are you doing today?");
    }


}
public class MethodReferencesDemo {
    public static void main(String[] args) {
        Creator<String> obj = Log::new;
        obj.create("Naveen");
    }
}
