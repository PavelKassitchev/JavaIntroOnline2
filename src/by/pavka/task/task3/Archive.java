package by.pavka.task.task3;

import by.pavka.task.task3.user.User;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

public enum Archive {
    INSTANCE;

    private ConcurrentHashMap<Student, Double> folder;
    private ConcurrentSkipListSet<User> users;
    private AtomicInteger count;
    private boolean folderIsModified;
    private boolean authIsModified;

    private final File archiveLocation = new File("archive.xml");
    private final File auth = new File("auth.xml");

    Archive() {
        try {
            if(!archiveLocation.createNewFile()) {
                count = updateCount();
                folder = loadFolder();
            }
            else {
                count = new AtomicInteger();
                folder = new ConcurrentHashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("archive.xml cannot be created");
        }
        try {
            if(!auth.createNewFile()) {
                users = loadAuth();
            }
            else {
                users = new ConcurrentSkipListSet<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int incrementAndGetCount() {
        return count.incrementAndGet();
    }

    public void read(int studentId) {
        Student student = getById(studentId);
        if(student != null) {
            System.out.println(student + ", Average Mark is " + folder.get(student));
        }
        else {
            System.out.println("There is no Student with id = " + studentId);
        }
    }

    public void modifyMark(int studentId, double newMark) {
        Student student = getById(studentId);
        if(student != null) {
            System.out.println(student + ", Average Mark is " + folder.get(student) + ", modified to " + newMark);
            folder.put(student, newMark);
            folderIsModified = true;
        }
        else {
            System.out.println("There is no Student with id = " + studentId);
        }
    }

    public void addFile(Student student, double mark) {
        System.out.println("File for " + student + " with Mark " + mark + " added to the Archive");
        folder.put(student, mark);
        folderIsModified = true;
    }

    public void addUser(User user) {
        users.add(user);
        authIsModified = true;
    }

    public void grantPermission(User user) {
        if(users.contains(user)) {
            user.setPermission();
            authIsModified = true;
        }
    }

    public void close() {
        if(folderIsModified) {
           writeData();
        }
        if(authIsModified) {
            writeAuth();
        }
    }

    private Student getById(int studentId) {
        for(Student s: folder.keySet()) {
            if(s.getId() == studentId) return s;
        }
        return null;
    }

    private ConcurrentHashMap<Student, Double> loadFolder() {
        //TODO
        return new ConcurrentHashMap<>();
    }

    private AtomicInteger updateCount() {
        //TODO
        return new AtomicInteger();
    }

    private void writeData() {
        //TODO
    }

    private ConcurrentSkipListSet<User> loadAuth() {
        //TODO
        return null;
    }

    private void writeAuth() {
        //TODO
    }


}
