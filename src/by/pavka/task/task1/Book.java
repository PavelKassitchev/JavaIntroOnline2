package by.pavka.task.task1;

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
        StringBuilder authors = new StringBuilder("Author(s): ");
        for(int i = 0; i < author.length - 1; i++) {
            authors.append(author[i] + ',');
        }
        authors.append(author[author.length - 1]);
        return "Book " + type + " TITLE: " + title + '\n' + authors.toString() + '\n';
    }









}
