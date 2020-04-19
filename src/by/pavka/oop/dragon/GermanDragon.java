package by.pavka.oop.dragon;

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
    public List<Treasure> selectToMatchAmount(int amount) {
        System.out.println("German");
        return null;
    }


}
