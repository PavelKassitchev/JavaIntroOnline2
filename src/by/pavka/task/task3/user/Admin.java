package by.pavka.task.task3.user;

import by.pavka.task.task3.Archive;
import by.pavka.task.task3.Student;

public class Admin extends User {
    public Admin(String password) {
        super("Admin", password);
        setPermission();
    }

    @Override
    public void addFile(Student student, double mark) {
        Archive.INSTANCE.addFile(student, mark);
    }

    @Override
    public void grantPermission(User user) {
        Archive.INSTANCE.grantPermission(user);
    }
}
