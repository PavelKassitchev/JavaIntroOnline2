package by.pavka.task.task1;

import java.util.Objects;

public class User {

    private Catalog catalog;

    private String email;
    public User(String email) {
        this.email = email;
        catalog = Catalog.getInstance();
    }

    public String getEmail() {
        return email;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void addBookEntry(BookEntry bookEntry) {
        System.out.println("Only Admin can add BookEntries");
    }

    public void startView() {
        catalog.startView();
    }

    public void next() {
        catalog.viewNextPage();
    }

    public void prev() {
        catalog.viewPrevPage();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if(o.getClass() != getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


}
