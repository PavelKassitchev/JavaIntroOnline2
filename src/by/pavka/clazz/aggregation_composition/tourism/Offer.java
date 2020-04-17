package by.pavka.clazz.aggregation_composition.tourism;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.)
* для оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок
 */
public class Offer {

    private RelaxType relaxType;
    private Transport transport;
    private Meals meals;

    private String destination;

    private int duration;

    private int price;

    public RelaxType getRelaxType() {
        return relaxType;
    }

    public Transport getTransport() {
        return transport;
    }

    public Meals getMeals() {
        return meals;
    }

    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public Offer(RelaxType relaxType, Transport transport, Meals meals, String destination, int duration, int price) {
        this.relaxType = relaxType;
        this.transport = transport;
        this.meals = meals;
        this.destination = destination;
        this.duration = duration;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Type: " + relaxType + ", destination: " + destination + ", transport: " + transport + ", meals: " + meals + ", duration: " + duration + ", price: " + price;
    }

    public static List<Offer> sortByPrice(List<Offer> offers) {
        offers.sort(new Comparator<Offer>() {
            @Override
            public int compare(Offer o1, Offer o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        System.out.println(offers);
        return offers;
    }

    public static List<Offer> filterType(List<Offer> offers, RelaxType type) {
        List<Offer> ofType = new ArrayList<>();
        for(Offer o: offers) {
            if(o.getRelaxType() == type) {
                ofType.add(o);
            }
        }
        System.out.println(ofType);
        return ofType;
    }

    public static List<Offer> filterDestination(List<Offer> offers, String dest) {
        List<Offer> ofDest = new ArrayList<>();
        for(Offer o: offers) {
            if(o.getDestination().equals(dest)) {
                ofDest.add(o);
            }
        }
        System.out.println(ofDest);
        return ofDest;
    }



    public static List<Offer> filterDuration(List<Offer> offers, int min, int max) {
        List<Offer> ofDuration = new ArrayList<>();
        for(Offer o: offers) {
            if(o.getDuration() >= min && o.getDuration() <= max) {
                ofDuration.add(o);
            }
        }
        System.out.println(ofDuration);
        return ofDuration;
    }

    public static List<Offer> filterPrice(List<Offer> offers, int maxPrice) {
        List<Offer> ofPrice = new ArrayList<>();
        for(Offer o: offers) {
            if(o.getPrice() <= maxPrice) {
                ofPrice.add(o);
            }
        }
        System.out.println(ofPrice);
        return ofPrice;
    }

    public static void main(String[] args) {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer(RelaxType.BEACH, Transport.AIR, Meals.BREAKFAST, "Yalta", 12, 888));
        offers.add(new Offer(RelaxType.EXCURSION, Transport.AIR, Meals.BREAKFAST, "Krakow", 6, 1088));
        offers.add(new Offer(RelaxType.BEACH, Transport.SELF, Meals.FULL, "Braslav", 14, 900));
        offers.add(new Offer(RelaxType.MEDICAL, Transport.BUS, Meals.BREAKFAST, "Naroch", 20, 1000));
        offers.add(new Offer(RelaxType.MEDICAL, Transport.BUS, Meals.BREAKFAST, "Naroch", 8, 500));

        sortByPrice(offers);
        filterDestination(offers, "Naroch");
    }
}
