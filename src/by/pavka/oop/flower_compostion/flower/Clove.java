package by.pavka.oop.flower_compostion.flower;

import by.pavka.oop.flower_compostion.Color;

public class Clove extends Flower {

    public static final int STANDARD_PRICE = 15;

    public Clove(int quality, Color color) {
        super(quality, color);
    }

    @Override
    public int getPrice() {
        int quality = getQuality();
        switch(quality) {
            case Flower.TOP_QUALITY:
                return (int)Math.round(STANDARD_PRICE * 1.2);
            case Flower.LOW_QUALITY:
                return (int)Math.round(STANDARD_PRICE * 0.8);
            default:
                return STANDARD_PRICE;
        }
    }
}
