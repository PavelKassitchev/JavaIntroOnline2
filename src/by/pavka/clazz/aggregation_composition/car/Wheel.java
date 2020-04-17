package by.pavka.clazz.aggregation_composition.car;

class Wheel {

    private Car car;

    public Wheel() {
        car = null;
    }

    public Wheel(Car car) {
        this.car = car;
    }

    public void creak() {
        System.out.println("Iiiiii...");
    }

    public void detach() {
        car = null;
    }
}
