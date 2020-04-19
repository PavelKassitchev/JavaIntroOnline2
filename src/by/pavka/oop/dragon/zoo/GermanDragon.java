package by.pavka.oop.dragon.zoo;

import by.pavka.oop.dragon.nation.Nation;
import by.pavka.oop.dragon.treasure.Treasure;

import java.util.List;

public class GermanDragon extends Dragon {

    public GermanDragon() {
        super(Nation.GERMAN);
    }

    @Override
    public void introduce() {
        System.out.println("Guten Tag! Ich bin ein GermanDragon");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Auf Wiedersehen!");
    }

    @Override
    public List<Treasure> selectToMatchAmount(int amount) {
        System.out.println("German");
        return null;
    }


}
