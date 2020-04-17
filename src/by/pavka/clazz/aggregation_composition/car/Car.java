package by.pavka.clazz.aggregation_composition.car;

/*
* Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля
 */
public class Car {

    private String makeAndModel;
    private int tankCapacity;
    private int fuelLevel;
    private Engine engine;
    private Wheel[] wheels;

    public Car(String makeAndModel) {
        this.makeAndModel = makeAndModel;
        if("Lada Vesta".equals(makeAndModel)) {
            tankCapacity = 65;
        }
        else tankCapacity = 55;
        fuelLevel = tankCapacity / 5;
        engine = new Engine(this);
        wheels = new Wheel[] {new Wheel(this), new Wheel(this), new Wheel(this), new Wheel(this)};
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void run() {
        engine.start();
        for(Wheel w: wheels) {
            w.creak();
        }
        System.out.println("Boom!");
    }

    public void fill(int fuel) {
        System.out.println("Initial level is " + fuelLevel + ", max is " + tankCapacity);
        int finalLevel = fuelLevel + fuel;
        if(finalLevel <= tankCapacity) {
            fuelLevel = finalLevel;
        }
        else {
            fuelLevel = tankCapacity;
        }
        System.out.println("Now the level is " + fuelLevel);
    }

    public void changeWheel(int number) {
        if(number > 0 && number < 5) {
            wheels[number - 1].detach();
            wheels[number - 1] = new Wheel(this);
            System.out.println("Wheel " + number + " changed");
        }
    }

    public void printName() {
        System.out.println("It was " + makeAndModel);
    }

    public static void main(String[] args) {
        Car car = new Car("Volkswagen Jetta");
        car.fill(15);
        car.changeWheel(1);
        car.run();
        car.printName();
    }


}

