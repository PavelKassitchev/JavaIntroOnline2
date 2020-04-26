package by.pavka.task.task1;

import java.util.Objects;

public class User implements Locatable {

    public static int userId;
    private String name;
    private String email;
    private int id;
    private int passHash;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        id = ++userId;
        passHash = Objects.hash(name, email, password);
    }

    public String getName() {
        return name;
    }

    public int getPassHash() {
        return passHash;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", passHash=" + passHash +
                '}';
    }

    @Override
    public String getLocation() {
        return name;
    }
}
