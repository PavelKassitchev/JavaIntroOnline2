package by.pavka.task.task1.user;

import by.pavka.task.task1.HomeLibrary;
import by.pavka.task.task1.book.Book;
import by.pavka.task.task1.book.BookEntry;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;
import java.util.Set;

public class Admin extends User {

    public static final String ADMIN_EMAIL = "pavkascool@gmail.com";

    public Admin() {
        super(ADMIN_EMAIL);
    }

    @Override
    public void addBookEntry(BookEntry bookEntry) {
        addBooksFromReaders();
        getCatalog().addBook(bookEntry);
    }

    @Override
    public void relocateBook(Book book, String location) {
        getCatalog().relocateBook(book, location);
    }

    @Override
    public void modifyDescription(Book book, String description) {
        getCatalog().modifyDescription(book, description);
        Set<String> emails = HomeLibrary.getAuthentication().stringPropertyNames();
        for(String s: emails) {
            //Method below may cause authentication problems
            //sendNewDescriptionByEmail(s, book.getTitle() + " - new description", description);
        }
    }

    private void sendNewDescriptionByEmail(String address, String subject, String description) {
        final String USERNAME = "java_user@mail.ru";
        final String PASSWORD = "MY_SECRET_PASSWORD";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(address));
            message.setSubject(subject);
            message.setText(description);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    //Below are two stub methods to imitate process of getting books from users' emails and putting them into the library
    private void addBooksFromReaders() {
        File library = new File("HOME_LIBRARY");
        library.mkdir();
        putBooksToLibrary(library);
    }

    private void putBooksToLibrary(File file) {
        //TODO
    }


}
