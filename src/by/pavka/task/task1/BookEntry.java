package by.pavka.task.task1;

public class BookEntry {

    private Book book;
    private String description;
    private Locatable locatable;

    public BookEntry(Book book) {
        this.book = book;
    }

    public BookEntry(Book book, String description) {
        this.book = book;
        this.description = description;
    }

    public BookEntry(Book book, Locatable locatable) {
        this.book = book;
        this.locatable = locatable;
    }

    public BookEntry(Book book, String description, Locatable locatable) {
        this.book = book;
        this.description = description;
        this.locatable = locatable;
    }

    public Book getBook() {
        return book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Locatable getLocatable() {
        return locatable;
    }

    public void setLocatable(Locatable locatable) {
        this.locatable = locatable;
    }

    public boolean contains(Book b) {
        if(book.equals(b)) return true;
        return false;
    }
}
