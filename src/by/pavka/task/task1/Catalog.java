package by.pavka.task.task1;

import java.util.ArrayList;
import java.util.List;


public class Catalog extends Book {

    private static Catalog instance;

    private List<BookEntry> books;

    private int currentPage;

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
        super(Type.DIGITAL, "Home Library Catalog", "Pavel Kassitchev");
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


    public void modifyDescription(Book book, String description) {
        for(BookEntry bookEntry: books) {
            if(bookEntry.contains(book)) {
                bookEntry.setDescription(description);
                return;
            }
        }
    }

    public BookEntry getBookEntry(int i) {
        return books.get(i);
    }

    public void startView() {
        System.out.println("Invoke start");
        if(!books.isEmpty()) {
            System.out.println("PAGE " + (currentPage + 1) + getBookEntry(0));
            currentPage = 0;
        }
    }

    public void viewNextPage() {
        System.out.println("Invoke next");
        if(!books.isEmpty() && currentPage < books.size() - 1) {
            System.out.println("PAGE " + (currentPage + 2) + '\n' + getBookEntry(++currentPage));
        }
    }

    public void viewPrevPage() {
        System.out.println("Invoke prev");
        if(!books.isEmpty() && currentPage > 0) {
            System.out.println("PAGE " + (currentPage) + '\n' + getBookEntry(--currentPage));
        }
    }
}
