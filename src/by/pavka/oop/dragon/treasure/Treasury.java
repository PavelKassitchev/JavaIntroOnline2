package by.pavka.oop.dragon.treasure;

import by.pavka.oop.dragon.nation.Nation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Treasury {

    private Treasure[] treasures = new Treasure[100];
    private Nation nation;

    public Treasury(Nation nation) {
        this.nation = nation;
    }

    public void init() {
        List<TreasureType> list = TreasureType.getNationalTreasureTypes(nation);
        Random random = new Random();
        for(int i = 0; i < treasures.length; i++) {
            int index = random.nextInt(list.size());
            TreasureType type = list.get(index);
            treasures[i] = new Treasure(type);
        }
        Arrays.sort(treasures);
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public int getAmount() {
        int sum = 0;
        for(Treasure t: treasures) {
            sum += t.getPrice();
        }
        return sum;
    }
}
