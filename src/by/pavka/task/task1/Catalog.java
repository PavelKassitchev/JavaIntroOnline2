package by.pavka.task.task1;

import java.util.ArrayList;
import java.util.List;


public class Catalog extends EBook {

    private static Catalog instance;

    private List<BookEntry> books;

    public static Catalog getInstance() {
        if(instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    public void setBooks(List<BookEntry> books) {
        this.books = books;
    }

    public List<BookEntry> getBooks() {
        return books;
    }

    private Catalog() {
        super("Home Library Catalog", "Pavel Kassitchev");
        books = new ArrayList<>();
    }

    public void addBook(BookEntry bookEntry) {
        books.add(bookEntry);
    }

    public void removeBook(Book book) {
        for(BookEntry bookEntry: books) {
            if(bookEntry.contains(book)) {
                books.remove(bookEntry);
                return;
            }
        }
    }

    public void relocateBook(Book book, Locatable locatable) {
        for(BookEntry bookEntry: books) {
            if(bookEntry.contains(book)) {
                bookEntry.setLocatable(locatable);
                return;
            }
        }
    }

    public void modifyDescription(Book book, String description) {
        for(BookEntry bookEntry: books) {
            if(bookEntry.contains(book)) {
                bookEntry.setDescription(description);
                return;
            }
        }
    }
}
