package by.pavka.task.task1;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class BookCreator implements InstanceCreator<Book> {
    @Override
    public Book createInstance(Type type) {
        if(type instanceof EBook) return new EBook("None", "None");
        else return new PaperBook("None", "None");
    }
}
