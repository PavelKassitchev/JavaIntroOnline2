package by.pavka.oop.dragon.zoo;

import by.pavka.oop.dragon.nation.Nation;
import by.pavka.oop.dragon.treasure.Treasure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GermanDragon extends Dragon {

    public GermanDragon() {
        super(Nation.GERMAN);
    }

    @Override
    public void introduce() {
        System.out.println("Guten Tag! Ich bin ein GermanDragon von Nibelung");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Auf Wiedersehen!");
    }

    @Override
    public List<Treasure> selectToMatchAmount(int amount) {

        List<Treasure> selected = new ArrayList<>();
        Treasure[] treasures = getTreasures();
        int sum = 0;

        Date date = new Date();
        Date current = new Date();

        while (current.getTime() - date.getTime() < 3000) {
            for (int i = treasures.length - 1; i >= 0; i--) {
                current = new Date();
                int j = 0;
                int k = 0;
                sum = treasures[i].getPrice();
                if (sum == amount) {
                    fillList(selected, treasures, i, j, k);
                    System.out.println(selected);
                    return selected;
                }
                if (sum > amount) continue;


                for (j = 0; j < i; j++) {
                    k = 1;
                    sum += treasures[j].getPrice();
                    if (sum == amount) {
                        fillList(selected, treasures, i, j, k);
                        System.out.println(selected);
                        return selected;
                    }
                    if (sum > amount) break;

                    for (k = 1; k < i - j - 1; k++) {
                        sum += treasures[j + k].getPrice();
                        if (sum == amount) {
                            fillList(selected, treasures, i, j, k);
                            System.out.println(selected);
                            return selected;
                        }
                        if (sum > amount) break;
                    }
                }
            }
        }
        System.out.println("I can't collect treasures exactly for this amount");
        return null;
    }

    private void fillList(List<Treasure> list, Treasure[] treasures, int i, int j, int k) {
        list.add(treasures[i]);
        if(k == 0) return;
        for(int index = j; index <= j + k; index++) {
            list.add(treasures[index]);
        }
        int sum = 0;
        for(Treasure t: list) sum += t.getPrice();
        System.out.println("Sum is " + sum);


    }


}
