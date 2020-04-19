package by.pavka.oop.dragon.zoo;

import by.pavka.oop.dragon.nation.Nation;
import by.pavka.oop.dragon.treasure.Treasure;

import java.util.*;

public class RussianDragon extends Dragon {

    public RussianDragon() {
        super(Nation.RUSSIAN);
    }

    @Override
    public void introduce() {
        System.out.println("Привет! Меня зовут Змей Горыныч!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Пока!");
    }

    @Override
    public List<Treasure> selectToMatchAmount(int amount) {

        System.out.println("Wait a little...");
        List<Treasure> treasuresToMatch = new ArrayList<>();
        ArrayList<Treasure> copy = new ArrayList(Arrays.asList(getTreasures()));
        int leftAmount = amount;
        Date date = new Date();
        Random random = new Random();
        Date current = new Date();
        while(leftAmount > 0 && (current.getTime() - date.getTime() < 5000)) {

            int index = random.nextInt(copy.size());
            if(copy.get(index).getPrice() < leftAmount) {
                treasuresToMatch.add(copy.get(index));
                leftAmount -= copy.get(index).getPrice();
                copy.remove(index);
            }
            current = new Date();
        }
        System.out.println("Is it okay to offer a collection to the amount of " + (amount - leftAmount) + "?");
        System.out.println(treasuresToMatch);
        if(amount - leftAmount > 0) {
            System.out.println("This is the best I can do");
        }
        return treasuresToMatch;
    }
}
