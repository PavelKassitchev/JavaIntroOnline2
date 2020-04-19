package by.pavka.oop.dragon.zoo;

import by.pavka.oop.dragon.nation.Nation;
import by.pavka.oop.dragon.treasure.Treasure;

import java.util.List;

public class ChineseDragon extends Dragon {

    public ChineseDragon() {
        super(Nation.CHINESE);
    }

    @Override
    public void introduce() {
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Nihao...");
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mahao bahao ChineseDragon");
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Zàijiàn");
    }

    @Override
    public List<Treasure> selectToMatchAmount(int amount) {
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lao Tzu says...");
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Don't try to implement this method...");
        return null;
    }


}
