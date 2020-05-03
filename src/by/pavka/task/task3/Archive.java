package by.pavka.task.task3;

import by.pavka.task.task3.parser.ArchiveParser;
import by.pavka.task.task3.person.Student;
import by.pavka.task.task3.person.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

//This Singleton keeps Students' Files and Users' Authentication data
public enum Archive {
    INSTANCE;

    private ConcurrentHashMap<Student, Double> folder;
    private ConcurrentSkipListSet<User> users;
    private AtomicInteger count;
    private boolean folderIsModified;
    private boolean authIsModified;

    private final File archiveLocation = new File("archive.xml");
    private final File authLocation = new File("auth.xml");

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
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            if(!authLocation.createNewFile()) {
                users = loadAuth();
            }
            else {
                users = new ConcurrentSkipListSet<>();
            }
        } catch (IOException | SAXException | ParserConfigurationException e ) {
            e.printStackTrace();
        }

    }

    public int incrementAndGetCount() {
        return count.incrementAndGet();
    }

    //Read student file
    public String read(int studentId) {
        Student student = getById(studentId);
        if(student != null) {
            return student + ", Average Mark is " + folder.get(student);
        }
        else {
            return "There is no Student with id = " + studentId;
        }
    }

    public String modifyMark(int studentId, double newMark) {
        Student student = getById(studentId);
        if(student != null) {
            double oldMark = folder.get(student);
            folder.put(student, newMark);
            folderIsModified = true;
            return student + ", Average Mark is " + oldMark + ", modified to " + newMark;
        }
        else {
            return "There is no Student with id = " + studentId;
        }
    }

    public String addFile(Student student, double mark) {
        folder.put(student, mark);
        folderIsModified = true;
        return "File for " + student + " with Mark " + mark + " added to the Archive";
    }

    //Add user rights to a new user
    public boolean addUser(User user) {
        if(users.add(user)) {
            authIsModified = true;
            return true;
        }
        return false;
    }

    public String grantPermission(User user) {
        if(users.contains(user) && !user.canModify()) {
            user.setPermission();
            authIsModified = true;
            return "Permission granted";
        }
        return "Either user already has permission or doesn't exist";
    }


    public User getByLogin(String login) {
        for(User u: users) {
            if(u.getLogin().equals(login)) return u;
        }
        return null;
    }

    public void close() throws TransformerException, ParserConfigurationException {
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

    private ConcurrentHashMap<Student, Double> loadFolder() throws IOException, SAXException, ParserConfigurationException {
        return new ConcurrentHashMap<>(ArchiveParser.loadStudents(archiveLocation));
    }

    private AtomicInteger updateCount() throws ParserConfigurationException, SAXException, IOException {
        return new AtomicInteger(ArchiveParser.getCount(archiveLocation));
    }

    private void writeData() throws TransformerException, ParserConfigurationException {
        ArchiveParser.writeFolder(folder, archiveLocation, count.get());
    }

    private ConcurrentSkipListSet<User> loadAuth() throws IOException, SAXException, ParserConfigurationException {
        ConcurrentSkipListSet<User> set = new ConcurrentSkipListSet<>(ArchiveParser.loadUsers(authLocation));
        return set;
    }

    private void writeAuth() throws TransformerException, ParserConfigurationException {
        ArchiveParser.writeAuth(users, authLocation);
    }


}
