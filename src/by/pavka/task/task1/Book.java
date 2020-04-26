package by.pavka.task.task1;

import java.util.Objects;

public abstract class Book {

    private static int idNumber;

    public final String[] author;
    private final String title;
    private final String content;
    private final String id;

    public Book(String title, String... author) {

        this.author = author;
        this.title = title;
        idNumber++;
        id = generateId();
        content = loadContent();
    }

    public static int getIdNumber() {
        return idNumber;
    }

    public String[] getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }



    @Override
    public String toString() {
        StringBuilder authors = new StringBuilder("Author(s): ");
        for(int i = 0; i < author.length - 1; i++) {
            authors.append(author[i] + ',');
        }
        authors.append(author[author.length - 1]);
        return getClass().getSimpleName() + " " + title + '\n' + authors.toString() + '\n' + "ID = " + id + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract String generateId();
    public abstract String loadContent();


}
