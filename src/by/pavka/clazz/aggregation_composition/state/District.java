package by.pavka.clazz.aggregation_composition.state;

class District {

    private String name;
    private Region region;
    private double square;

    public District(String name, double square) {
        this.name = name;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}
