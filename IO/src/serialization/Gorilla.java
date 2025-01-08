package serialization;

import java.io.Serializable;

public class Gorilla implements Serializable {

    //The serialVersionUID helps inform the JVM that the stored data may not match the new class
    //definition. If an older version of the class is encountered during deserialization, a
    //java.io.InvalidClassException may be thrown. Alternatively, some APIs support converting data
    //between versions.
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Gorilla(String name, int age, Boolean friendly, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
        this.favoriteFood = favoriteFood;
    }

    private Boolean friendly;

    ///Oftentimes, the transient modifier is used for sensitive data of the class, like a password.
    // There are other objects it does not make sense to serialize,
    //like the state of an in-memory Thread. If the object is part of a serializable object, we just mark it
    //transient to ignore these select instance members.
    private transient String favoriteFood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getFriendly() {
        return friendly;
    }

    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "Gorilla{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendly=" + friendly +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }
}

