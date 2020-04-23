package by.pavka.oop.flower_compostion.flower;

import by.pavka.oop.flower_compostion.Color;

public class Rose extends Flower {

    public static final int STANDARD_PRICE = 20;

    public Rose(int quality, Color color) {
        super(quality, color);
    }

    @Override
    public int getPrice() {
        int quality = getQuality();
        switch(quality) {
            case Flower.TOP_QUALITY:
                return (int)Math.round(STANDARD_PRICE * 1.3);
            case Flower.LOW_QUALITY:
                return (int)Math.round(STANDARD_PRICE * 0.7);
            default:
                return STANDARD_PRICE;
        }
    }
}
