package by.pavka.clazz.aggregation_composition.state;

import java.util.ArrayList;
import java.util.List;

class Region {

    private String name;
    private State state;
    private City center;
    private List<District> districts;
    private double square;

    public Region(String name, District... districts) {
        this.name = name;
        setDistricts(districts);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCenter() {
        return center;
    }

    public void setCenter(City cntr) {

        if(center != null) {
            center.setRegion(null);
        }
        cntr.setRegion(this);
        center = cntr;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(District... dists) {


        if(districts != null) {
            for(District oldDistrict: districts) {
                oldDistrict.setRegion(null);
            }
        }

        districts = new ArrayList<>();
        double square = 0;
        for(District newDistrict: dists) {
            districts.add(newDistrict);
            square += newDistrict.getSquare();
            newDistrict.setRegion(this);
        }
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

}
