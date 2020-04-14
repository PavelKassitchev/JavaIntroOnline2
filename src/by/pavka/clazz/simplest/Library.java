package by.pavka.clazz.simplest;
/*
* Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString().
* Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.

Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.

*
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public static void main(String[] args) {
        Book[] books = new Book[] {
            new Book("id-1", "ABC and CBA", new String[]{"Ivanov"}, "Nauka", 2012, 54, 12, 1),
            new Book("id-2", "Wolf and Rabbit", new String[]{"Ivanov", "Petrov"}, "Skazka", 2010, 5, 120, 2),
            new Book("id-3", "Kamasutra", new String[]{"Bha Mha Dha"}, "India", 301, 5455, 1200, 1),
            new Book("id-4", "Gone With The Wind", new String[]{"Mitchell"}, "Green and Co.", 1935, 333, 102, 2),
            new Book("id-5", "Photon", new String[]{"Landau"}, "Nauka", 1956, 54, 12, 1),
            new Book("id-6", "Air Forces", new String[]{"Captain Ob"}, "US forces", 2010, 4, 2, 2),
        };
        Library library = new Library(books);
        library.byAuthor("Ivanov");
        library.byPublished("Nauka");
        library.byYear(1935);
    }

    public List<Book> byAuthor(String author) {
        List<Book> bks = new ArrayList<>();
        for(Book b: books) {
            for(String s: b.getAuthors()) {
                if(author.equals(s)) {
                    bks.add(b);
                }
            }
        }
        System.out.println(bks);
        return bks;
    }

    public List<Book> byPublished(String published) {
        List<Book> bks = new ArrayList<>();
        for(Book b: books) {
            if(published.equals(b.getPublished())) {
                bks.add(b);
            }
        }
        System.out.println(bks);
        return bks;
    }

    public List<Book> byYear(int year) {
        List<Book> bks = new ArrayList<>();
        for(Book b: books) {
            if(year < b.getYear()) {
                bks.add(b);
            }
        }
        System.out.println(bks);
        return bks;
    }
}

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
