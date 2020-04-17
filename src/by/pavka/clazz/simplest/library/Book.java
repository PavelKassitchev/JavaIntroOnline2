package by.pavka.clazz.simplest.library;

import java.util.Arrays;

class Book {

    public final static int SOFT = 1;
    public final static int HARD = 2;

    private String id;
    private String title;
    private String[] authors;
    private String published;
    private int year;
    private int pages;
    private int price;
    private int type;

    public Book(String id, String title, String[] authors, String published, int year, int pages, int price, int type) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.published = published;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return '\n' + Arrays.toString(authors) + '\n' + title + '\n' + published + " " + year + '\n';
    }
}
