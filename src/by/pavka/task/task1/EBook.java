package by.pavka.task.task1;

public class EBook extends Book {


    public EBook(String title, String... author) {
        super(title, author);
    }

    @Override
    public String generateId() {
        return Book.getIdNumber() + "E";
    }

//    @Override
//    public String loadContent() {
//        //TODO
//        return null;
//    }
}
