package by.pavka.task.task3.user;

import by.pavka.task.task3.Archive;
import by.pavka.task.task3.Student;

import java.util.Objects;

public class User {
    private String login;
    private int passHash;
    private boolean canModify;

    public User(String login, String password) {
        this.login = login;
        passHash = Objects.hash(login, password);
        canModify = false;
    }

    public void setPermission() {
        canModify = true;
    }

    public void readFile(int studentId) {
        Archive.INSTANCE.read(studentId);
    }

    public void modifyMark(int studentId, double mark) {
        if(!canModify) {
            System.out.println("Only Teachers and Admin can do it");
        }
        else {
            Archive.INSTANCE.modifyMark(studentId, mark);
        }
    }

    public void addFile(Student student, double mark) {
        System.out.println("Only Admin can do it");
    }

    public void grantPermission (User user) {
        System.out.println("Only Admin can do it");
    }
}
