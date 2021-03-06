package by.pavka.task.task3.person;

import by.pavka.task.task3.Archive;

import java.util.Objects;

//This class presents the Archive users

public class User implements Comparable<User>{

    private String login;
    private int passHash;
    private boolean canModify;

    public User(String login, String password) {
        this.login = login;
        passHash = Objects.hash(login, password);
        canModify = false;
    }

    public User(String login, int passHash, boolean canModify) {
        this.login = login;
        this.passHash = passHash;
        this.canModify = canModify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return passHash == user.passHash &&
                login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, passHash);
    }

    //This method gives the user permission to modify students' files, but not add students
    public void setPermission() {
        canModify = true;
    }

    public String getLogin() {
        return login;
    }


    public int getPassHash() {
        return passHash;
    }

    public boolean canModify() {
        return canModify;
    }



    public String readFile(int studentId) {
        return Archive.INSTANCE.read(studentId);
    }

    //This method invokes Archive method to modify the student's file
    public String modifyMark(int studentId, double mark) {
        if(!canModify) {
            return "Only Teachers and Admin can do it";
        }
        else {
            return Archive.INSTANCE.modifyMark(studentId, mark);
        }
    }

    //This action is allowed to Admin only
    public String addFile(Student student, double mark) {
        if(login.equals("Admin")) {
            return Archive.INSTANCE.addFile(student, mark);
        }
        else return "Only Admin can do it";
    }

    //This method lets Admin grant permissions to other users to modify students' files
    public String grantPermission (User user) {
        if(login.equals("Admin")) {
            return Archive.INSTANCE.grantPermission(user);
        }
        else {
            return "Only Admin can do it";
        }

    }

    @Override
    public int compareTo(User o) {
        return login.compareTo(o.login);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passHash=" + passHash +
                ", canModify=" + canModify +
                '}';
    }
}
