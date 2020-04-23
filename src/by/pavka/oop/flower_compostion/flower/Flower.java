package by.pavka.oop.flower_compostion.flower;

import by.pavka.oop.flower_compostion.Color;

import java.util.Objects;

public abstract class Flower {

    public static final int TOP_QUALITY = 1;
    public static final int MEDIUM_QUALITY = 2;
    public static final int LOW_QUALITY = 3;


    private int quality;
    private Color color;
    private int price;

    public Flower(int quality, Color color) {
        this.quality = quality;
        this.color = color;
    }

    public int getQuality() {
        return quality;
    }

    public Color getColor() {
        return color;
    }

    public abstract int getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        if(o.getClass() != getClass()) return false;
        Flower flower = (Flower) o;
        return quality == flower.quality &&
                price == flower.price &&
                color == flower.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality, color, price);
    }

    @Override
    public String toString() {
        return "Flower " + getClass().getSimpleName() +
                " quality=" + quality +
                " and color=" + color +
                " and price is " + getPrice() + ".";
    }
}
