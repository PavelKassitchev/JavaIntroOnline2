package by.pavka.oop.flower_compostion.flower;

import by.pavka.oop.flower_compostion.Color;
import by.pavka.oop.flower_compostion.flower.Flower;

public class Tulip extends Flower {

    public static final int STANDARD_PRICE = 10;

    public Tulip(int quality, Color color) {
        super(quality, color);
    }

    @Override
    public int getPrice() {
        int quality = getQuality();
        switch(quality) {
            case Flower.TOP_QUALITY:
                return (int)Math.round(STANDARD_PRICE * 1.1);
            case Flower.LOW_QUALITY:
                return (int)Math.round(STANDARD_PRICE * 0.9);
                default:
                    return STANDARD_PRICE;
        }
    }
}
