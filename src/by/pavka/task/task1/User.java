package by.pavka.task.task1;

import java.util.Objects;

public class User implements Locatable {

    public static int userId;
    private String name;
    private int id;
    private int passHash;

    public User(String name, String password) {
        this.name = name;
        id = ++userId;
        passHash = Objects.hash(name, id, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", passHash=" + passHash +
                '}';
    }

    @Override
    public String getLocation() {
        return name;
    }
}
