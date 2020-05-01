package by.pavka.task.task2;

import java.util.Date;

public class Note {

    private String subject;
    private Date date;
    private String email;
    private String content;

    public Note(String sub) {
        subject = sub;
        if(subject == null || subject.isEmpty()) {
            subject = "New Note";
        }
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  '\n' + "" + '\n' + "subject='" + subject + '\'' + '\n' +
                "date=" + date + '\n' +
                "email='" + email + '\'' + '\n' +
                "content='" + content + '\'';

    }
}
