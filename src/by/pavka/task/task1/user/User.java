package by.pavka.task.task1.user;

import by.pavka.task.task1.book.Book;
import by.pavka.task.task1.book.BookEntry;
import by.pavka.task.task1.book.Catalog;

import java.util.Objects;

public class User {

    private Catalog catalog;

    private String email;
    public User(String email) {
        this.email = email;
        catalog = Catalog.getInstance();
    }

    public String getEmail() {
        return email;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void addBookEntry(BookEntry bookEntry) {
        System.out.println("Only Admin can add BookEntries");
    }

    public void relocateBook(Book book, String location) {
        System.out.println("Only Admin can relocate books");
    }

    public void modifyDescription(Book book, String description) {
        System.out.println("Only Admin can modify BookEntries");
    }

    public BookEntry searchBook(String title) {
        return catalog.searchBookEntry(title);
    }

    public void openCatalog() {
        catalog.open();
    }

    public void nextPage() {
        catalog.nextPage();
    }

    public void prevPage() {
        catalog.prevPage();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if(o.getClass() != getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
