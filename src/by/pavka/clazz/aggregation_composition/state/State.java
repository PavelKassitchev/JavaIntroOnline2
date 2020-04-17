package by.pavka.clazz.aggregation_composition.state;

import java.util.ArrayList;
import java.util.List;

/*
*  Создать объект класса Государство, используя классы Область, Район, Город.
* Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */
public class State {

    private String name;
    private City capital;
    private List<Region> regions;
    private double square;

    public State(String name, Region... regions) {
        this.name = name;
        setRegions(regions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City cptl) {

        if(capital != null) {
            capital.setState(null);
        }
        cptl.setState(this);
        capital = cptl;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(Region... regs) {

        if(regions != null) {
            for(Region oldRegion: regions) {
                oldRegion.setState(null);
            }
        }
        regions = new ArrayList<>();
        double square = 0;
        for(Region newRegion: regs) {
            newRegion.setState(this);
            regions.add(newRegion);
            square += newRegion.getSquare();
        }
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void printCapital() {
        System.out.println("The Capital of the State is " + capital.getName());
    }

    public void printNumberOfRegions() {
        System.out.println("The number of regions is " + regions.size());
    }

    public void printSquare() {
        System.out.println("The square of the State is " + square + " sq.km");
    }

    public void printCenters() {
        System.out.println("The region centers are: ");
        for(Region r: regions) {
            System.out.println(r.getCenter().getName());
        }
    }

    public static void main(String[] args) {
        City minsk = new City("Minsk");
        City grodno = new City("Grodno");
        City brest = new City("Brest");
        City gomel = new City("Gomel");

        District borisovsky = new District("Borisovsky", 260);
        District slutsky = new District("Slutsky", 200);
        District logoysky = new District("Logoysky", 300);
        District lidsky = new District("Lidsky", 220);
        District berezovsky = new District("Berezovsky", 100);
        District kobrinsky = new District("Kobrinsky", 330);
        District svetlogorsky = new District("Svetlogorsky", 150);
        District mozyrsky = new District("Mozyrsky", 210);

        Region minskaia = new Region("Minskaia", borisovsky, slutsky, logoysky);
        minskaia.setCenter(minsk);
        System.out.println("Minskaia oblast, " + minskaia.getSquare() + " sq.km, Center is " + minskaia.getCenter().getName());

        Region grodnenskaia = new Region("Grodnenskaia", lidsky);
        grodnenskaia.setCenter(grodno);

        Region brestskaia = new Region("Brestskaia", berezovsky, kobrinsky);
        brestskaia.setCenter(brest);

        Region gomelskaia = new Region("Gomelskaia", svetlogorsky, mozyrsky);
        gomelskaia.setCenter(gomel);

        State belarus = new State("Belarus", minskaia, brestskaia, grodnenskaia, gomelskaia);
        belarus.setCapital(minsk);
        System.out.println(minsk.getName() + " is center of " + minsk.getRegion().getName() + " and " + minsk.getState().getName());

        belarus.printCapital();
        belarus.printNumberOfRegions();
        belarus.printSquare();
        belarus.printCenters();
    }

}

