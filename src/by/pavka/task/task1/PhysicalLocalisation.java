package by.pavka.task.task1;

public class PhysicalLocalisation implements Locatable {

    private BookCase bookCase;
    private int shelf;

    public PhysicalLocalisation(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    public void setShelf(int shelf) {
        if(shelf < 1) shelf = 1;
        if (shelf > bookCase.getNumberOfShelves()) shelf = bookCase.getNumberOfShelves();
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public int getShelf() {
        return shelf;
    }

    @Override
    public String getLocation() {
        return "BoockCase " + bookCase.getId() + " shelf " + shelf;
    }
}
