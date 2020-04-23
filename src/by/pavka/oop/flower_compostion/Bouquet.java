package by.pavka.oop.flower_compostion;

import by.pavka.oop.flower_compostion.decor.Asparagus;
import by.pavka.oop.flower_compostion.decor.Decor;
import by.pavka.oop.flower_compostion.flower.Flower;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bouquet {

    private Map<Flower, Integer> flowers;
    private Set<Decor> decors;

    private Bouquet() {

    }

    public static BouquetBuilder getBuilder() {
        return new Bouquet().new BouquetBuilder();
    }

    public class BouquetBuilder {

        private BouquetBuilder() {
            flowers = new HashMap<>();
            decors = new HashSet<>();
        }

        public BouquetBuilder addFlower(Flower... flower) {
            for(Flower f: flower) {
                if (f.getQuality() == Flower.TOP_QUALITY || f.getQuality() == Flower.MEDIUM_QUALITY || f.getQuality() == Flower.LOW_QUALITY) {
                    if (flowers.containsKey(f)) {
                        int i = flowers.get(f);
                        flowers.put(f, i + 1);
                    }
                    else {
                        flowers.put(f, 1);
                    }
                }
                else {
                    System.out.println(f + " Such a quality level doesn't exist");
                }
            }
            return this;
        }

        public BouquetBuilder removeFlower(Flower... flower) {
            for(Flower f: flower) {
                if(flowers.containsKey(f)) {
                    int i = flowers.get(f);
                    if(i > 1) {
                        flowers.put(f, i + 1);
                    }
                    else {
                        flowers.remove(f);
                    }
                }
            }
            return this;
        }

        public BouquetBuilder addDecor(Decor decor) {
            decors.add(decor);
            return this;
        }

        public BouquetBuilder removeDecor(Decor decor) {
            decors.remove(decor);
            return this;
        }

        private int getSize() {
            int size = 0;
            for(int q: flowers.values()) {
                size += q;
            }
            return size;
        }

        public boolean isEven() {
            if(getSize() % 2 == 0) return true;
            return false;
        }

        public boolean isClassic() {

            if(flowers.isEmpty()) return false;

            Flower[] flwr = flowers.keySet().toArray(new Flower[0]);
            Class clazz = flwr[0].getClass();
            for(Flower f: flwr) {
                if(f.getClass() != clazz) return false;
            }

            return true;

        }

        public int getPrice() {
            int sum = 0;
            for(Map.Entry<Flower, Integer> entry: flowers.entrySet()) {
                sum += (entry.getKey().getPrice() * entry.getValue());
            }
            for(Decor d: decors) {
                sum += d.getPrice();
            }
            return sum;
        }

        public Bouquet wrap() {
            System.out.println("The Bouquet is ready. It is even = " + isEven() + ", it contains only one sort of flowers = " + isClassic());
            System.out.println(flowers);
            System.out.println(decors);
            System.out.println("Price is " + getPrice());

            return Bouquet.this;
        }
    }
}
