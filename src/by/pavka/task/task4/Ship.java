package by.pavka.task.task4;


public class Ship {

    private static int counter;
    private int capacity;
    private int load;
    private int id;

    public Ship(int capacity) {
        this(capacity, false);
    }

    public Ship(int capacity, boolean loaded) {
        this.capacity = capacity;
        if(loaded) load = capacity;
        else load = 0;
        id = ++counter;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Ship{" + "id=" + id +
                ", capacity=" + capacity +
                ", load=" + load +
                '}';
    }
}
