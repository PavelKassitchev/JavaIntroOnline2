package by.pavka.task.task1;

import java.util.Objects;

public class BookCase {
    private String id;
    private int numberOfShelves;

    public BookCase(String id, int numberOfShelves) {
        this.id = id;
        this.numberOfShelves = numberOfShelves;
    }

    public String getId() {
        return id;
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }

    @Override
    public String toString() {
        return "BookCase{" +
                "id='" + id + '\'' +
                ", numberOfShelves=" + numberOfShelves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCase)) return false;
        BookCase bookCase = (BookCase) o;
        return id.equals(bookCase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
