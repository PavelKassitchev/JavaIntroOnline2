package by.pavka.task.task1;

public class PaperBook extends Book {


    public PaperBook(String title, String... author) {
        super(title, author);
    }

    @Override
    public String generateId() {
        return Book.getIdNumber() + "P";
    }

    @Override
    public String loadContent() {
        return null;
    }
}
