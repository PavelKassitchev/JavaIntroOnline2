package by.pavka.oop.dragon.treasure;

import java.util.Random;

public class Treasure implements Comparable<Treasure> {

    private TreasureType treasureType;
    private int price;

    public Treasure(TreasureType treasureType) {
        this.treasureType = treasureType;
        Random random = new Random();
        price = treasureType.MIN_PRICE + random.nextInt(treasureType.MAX_PRICE - treasureType.MIN_PRICE + 1);
    }

    @Override
    public String toString() {
        return "Treasure " + treasureType + " of price=" + price + '\n';
    }

    public TreasureType getTreasureType() {
        return treasureType;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Treasure o) {
        return price - o.getPrice();
    }
}
