package by.pavka.task.task3.person;

import by.pavka.task.task3.Archive;

import java.util.Objects;

//This class describes Students whose files are presented in the Archive

public class Student {


    private String name;
    private String address;
    private int id;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        id = Archive.INSTANCE.incrementAndGetCount();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
