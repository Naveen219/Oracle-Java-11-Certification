package zoo.animal.feeding;
/*
 * @author Vunnam, Kumar Naveen
 * @since  11/5/2024
 */




// To compile the Task class
// Run javac -d mods zoo/animal/feeding/Task.java module-info.java
// To compile all the classes in the feeding directory
// Run javac -d mods zoo/animal/feeding/*.java module-info.java
//  -d  -> output directory -> Compiled files gets written to this folder
//
// To Run the module
// java --module-path mods --module zoo.animal.feeding.module/zoo.animal.feeding.Task
// --module-path or -p -> tells where to find the module jar or modules
// --module or -m -> tells the module name
public class Task {

    public static void main(String[] args) {
        System.out.println("Hello, How are you doing today ?");
    }


}
