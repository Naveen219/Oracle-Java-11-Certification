package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
    /*
    Serialization is the process of converting an in-memory object to a byte stream. Likewise, deserialization
    is the process of converting from a byte stream into an object. Serialization often involves writing an object
    to a stored or transmittable format, while deserialization is the reciprocal process.

     */

    // Serializing
    private static void saveToFile(List<Object> animals, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Object animal : animals) {
                out.writeObject(animal);
            }
        }
    }

    // Deserializing
    private static List<?> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
        var animals = new ArrayList<>();
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {

            while (true) {
                var object = in.readObject();
                if (object instanceof Gorilla) {
                    animals.add((Gorilla) object);
                }
                if (object instanceof Dog) {
                    animals.add((Dog)object);
                }
            }
        } catch (EOFException e) {

        }
        return animals;
    }

    public static void main(String[] args) {
        var animals = new ArrayList<Object>();
        animals.add(new Gorilla("Grodd", 5, false, "leaves"));
        animals.add(new Gorilla("Ishmeal", 5, false, "stems"));
        animals.add(new Dog("Tommy", 1));
        animals.add(new Dog("Jimmy", 1));
        File dataFile = new File("IO/examples/gorilla.data");
        try {
            saveToFile(animals, dataFile);
            var gorillasFromDisk = readFromFile(dataFile);
            System.out.println(gorillasFromDisk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

