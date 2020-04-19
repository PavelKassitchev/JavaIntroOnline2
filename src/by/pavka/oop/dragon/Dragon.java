package by.pavka.oop.dragon;

import java.util.Arrays;
import java.util.List;

public abstract class Dragon {

    private Treasury treasury;

    public Dragon(Nation nation) {
        treasury = new Treasury(nation);
    }

    public void fillInTreasury() {
        treasury.init();
    }

    public void showTreasures() {
        String report = Arrays.toString(treasury.getTreasures());
        System.out.println(report);
    }

    public Treasure selectTheMostExpensive() {
        Treasure expensive = treasury.getTreasures()[99];
        System.out.println("The most expensive item of my collection is " + expensive);
        return expensive;
    }

    public abstract void introduce();

    public abstract List<Treasure> selectToMatchAmount(int amount);

    private int getWealth() {
        int wealth = treasury.getAmount();
        return wealth;
    }
}
