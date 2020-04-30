package by.pavka.task.task1.book;

import java.util.Arrays;
import java.util.Objects;

public class Book {

    public  String[] author;
    private String title;
    private Type type;


    public Book(Type type, String title, String... author) {

        this.type = type;
        this.author = author;
        this.title = title;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String aut = "";
        if (author != null) {
            StringBuilder authors = new StringBuilder();
            for (int i = 0; i < author.length - 1; i++) {
                authors.append(author[i] + ',');
            }
            authors.append(author[author.length - 1]);
            aut = authors.toString();
        }
        return "Book " + type + ", TITLE: " + title + '\n' + "Author(s): " + aut + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Arrays.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                type == book.type;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, type);
        result = 31 * result + Arrays.hashCode(author);
        return result;
    }
}
