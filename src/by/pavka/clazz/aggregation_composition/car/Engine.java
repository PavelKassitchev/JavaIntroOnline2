package by.pavka.clazz.aggregation_composition.car;

class Engine {

    private Car car;

    public Engine() {
        car = null;
    }

    public Engine(Car car) {
        this.car = car;
    }

    public void start() {
        System.out.println("dr..dr..drrrrrr");
    }

}
