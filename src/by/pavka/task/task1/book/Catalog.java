package by.pavka.task.task1.book;

import java.util.ArrayList;
import java.util.List;


public class Catalog extends Book {

    private static Catalog instance;

    private List<BookEntry> books;

    private int currentPage;
    private BookEntry selectedEntry;

    private boolean isModified;

    public static Catalog getInstance() {
        if(instance == null) {
            instance = new Catalog();
        }
        return instance;
    }


    private Catalog() {
        super(Type.DIGITAL, "Home Library Catalog", "Pavel Kassitchev");
        books = new ArrayList<>();
    }

    public void setBooks(List<BookEntry> books) {
        this.books = books;
    }

    public List<BookEntry> getBooks() {
        return books;
    }

    public boolean isModified() {
        return isModified;
    }

    public BookEntry getSelectedEntry() {
        return selectedEntry;
    }

    public BookEntry searchBookEntry(String title) {
        if(books.isEmpty()) {
            System.out.println("The Catalog is empty yet");
            return null;
        }

        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getBook().getTitle().equals(title)) {
                selectedEntry = books.get(i);
                currentPage = i + 1;
                System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
                return selectedEntry;
            }
        }
        System.out.println("The book is not found");
        return null;
    }

    public void addBook(BookEntry bookEntry) {
        books.add(bookEntry);
        currentPage = books.size();
        selectedEntry = books.get(books.size() - 1);
        System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
        isModified = true;
    }


    public void relocateBook(Book book, String location) {
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).contains(book)) {
                selectedEntry = books.get(i);
                currentPage = i + 1;
                books.get(i).setLocation(location);
                System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
                isModified = true;
                return;
            }
        }
    }


    public void modifyDescription(Book book, String description) {
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).contains(book)) {
                selectedEntry = books.get(i);
                currentPage = i + 1;
                selectedEntry.setDescription(description);
                System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
                isModified = true;
                return;
            }
        }
    }


    public void open() {
        if(books.isEmpty()) {
            System.out.println("The Catalog is empty yet");
        }
        else {
            currentPage = 1;
            selectedEntry = books.get(0);
            System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
        }
    }

    public void nextPage() {
        if(!books.isEmpty() && currentPage < books.size()) {
            selectedEntry = books.get(currentPage);
            currentPage++;
            System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
        }
        else if(books.isEmpty()) {
            System.out.println("The Catalog is empty yet");
        }
        else {
            System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
        }
    }

    public void prevPage() {
        if(!books.isEmpty() && currentPage > 1) {
            selectedEntry = books.get(currentPage - 2);
            currentPage--;
            System.out.println("PAGE " + currentPage + '\n' + selectedEntry);
        }
        else open();
    }

}
