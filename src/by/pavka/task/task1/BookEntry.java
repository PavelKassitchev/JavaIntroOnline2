package by.pavka.task.task1;

public class BookEntry {

    private Book book;
    private String description;
    private String location;

    public BookEntry(Book book) {
        this.book = book;
    }

    public BookEntry(Book book, String description) {
        this.book = book;
        this.description = description;
    }



    public BookEntry(Book book, String description, String location) {
        this.book = book;
        this.description = description;
        this.location = location;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean contains(Book b) {
        if(book.equals(b)) return true;
        return false;
    }

    @Override
    public String toString() {
        return book + "description = " + description + '\'' + ", location = " + location + '\'';
    }
}
