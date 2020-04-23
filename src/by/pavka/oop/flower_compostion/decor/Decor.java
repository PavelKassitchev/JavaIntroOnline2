package by.pavka.oop.flower_compostion.decor;

import by.pavka.oop.flower_compostion.Color;

import java.util.Objects;

public abstract class Decor {

    private Color color;
    private int price;

    public Decor(Color color, int price) {
        this.color = color;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Decor)) return false;
        if(o.getClass() != getClass()) return false;
        Decor decor = (Decor) o;
        return color == decor.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, price);
    }

    @Override
    public String toString() {
        return "Decor " + getClass().getSimpleName() +
                " color=" + color +
                " and price=" + price;
    }
}
