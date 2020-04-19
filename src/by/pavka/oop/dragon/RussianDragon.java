package by.pavka.oop.dragon;

import java.util.List;

public class RussianDragon extends Dragon {

    public RussianDragon() {
        super(Nation.RUSSIAN);
    }

    @Override
    public void introduce() {
        System.out.println("Привет! Меня зовут Змей Горыныч!");
    }

    @Override
    public List<Treasure> selectToMatchAmount(int amount) {
        System.out.println("Russian");
        return null;
    }
}
