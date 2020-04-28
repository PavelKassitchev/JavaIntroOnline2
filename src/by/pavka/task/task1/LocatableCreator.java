package by.pavka.task.task1;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class LocatableCreator implements InstanceCreator<Locatable> {
    @Override
    public Locatable createInstance(Type type) {
        if(type instanceof ERepo) return new ERepo(null);
        else return new PhysicalLocalisation(new BookCase("a", 1));
    }
}
