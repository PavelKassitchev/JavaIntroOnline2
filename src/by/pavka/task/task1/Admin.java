package by.pavka.task.task1;

public class Admin extends User {

    public static final String ADMIN_EMAIL = "pavkascool@gmail.com";

    public Admin() {
        super(ADMIN_EMAIL);
    }

    @Override
    public void addBookEntry(BookEntry bookEntry) {
        getCatalog().addBook(bookEntry);
    }
}
