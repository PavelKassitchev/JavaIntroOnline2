package by.pavka.task.task4;

/*
* Попробуйте решить данную задачу хотя бы на 50%.

Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент

в	порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта.
* В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у причала или разгружаться.

 */

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Port {

    private Pier[] piers;
    //Ships on raid
    private int maxShipsOnRaid;
    private Queue<Ship> shipsToLoad;
    private Queue<Ship> shipsToUnload;

    private int capacity;
    private int currentStock;
    private int futureStock;


    public Port(int numberOfPiers, int maxShipsOnRaid, int capacity, int initialStock) {

        shipsToLoad = new ArrayBlockingQueue<>(maxShipsOnRaid);
        shipsToUnload = new ArrayBlockingQueue<>(maxShipsOnRaid);
        this.capacity = capacity;
        currentStock = initialStock > capacity? capacity: initialStock;
        futureStock = currentStock;

        piers = new Pier[numberOfPiers];
        for(int i = 0; i < numberOfPiers; i++) {
            piers[i] = new Pier(this, i + 1);
            System.out.println(piers[i] + " has been built");
            new Thread(piers[i]).start();
            System.out.println(piers[i] + " has began to work");
        }

    }

    public Queue<Ship> getShipsToLoad() {
        return shipsToLoad;
    }

    public Queue<Ship> getShipsToUnload() {
        return shipsToUnload;
    }

    public synchronized int getCurrentStock() {
        return currentStock;
    }

    public synchronized void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getFutureStock() {
        return futureStock;
    }

    public void setFutureStock(int futureStock) {
        this.futureStock = futureStock;
    }

    public synchronized void addStock(int add) {
        currentStock += add;
    }

    public synchronized void reduceStock(int reduce) {
        currentStock -= reduce;
    }

    public synchronized void addFutureStock(int add) {
        futureStock += add;
    }

    public synchronized void reduceFutureStock(int reduce) {
        futureStock -= reduce;
    }


    public boolean commandToLoad() {
        Random random = new Random();

        int nextCargoToLoad = 0;
        int nextCargoToUnload = 0;
        if(!shipsToLoad.isEmpty()) nextCargoToLoad = shipsToLoad.peek().getCapacity();
        if(!shipsToUnload.isEmpty()) nextCargoToUnload = shipsToUnload.peek().getLoad();

        if(currentStock > capacity - nextCargoToUnload || futureStock > capacity - nextCargoToUnload) return true;
        if(currentStock < nextCargoToLoad || futureStock < nextCargoToLoad) return false;

        if(futureStock >= capacity / 2 && shipsToLoad.size() > shipsToUnload.size()) return true;
        if(futureStock <= capacity / 2 && shipsToLoad.size() < shipsToLoad.size()) return false;

        return random.nextBoolean();
    }

    public void generateShips() {
        Random random = new Random();
        while(true) {

            if (random.nextBoolean()) {

                Ship ship = new Ship(10 + random.nextInt(10));
                synchronized (this) {
                    shipsToLoad.offer(ship);
                    System.out.println("New " + ship + " came to load, total quantity to load is " + shipsToLoad.size() +
                            ", total quantity to unload is " + shipsToUnload.size());
                }

            } else {

                Ship ship = new Ship(10 + random.nextInt(10), true);
                synchronized (this) {
                    shipsToUnload.offer(ship);
                    System.out.println("New " + ship + "  came to unload, total quantity to unload is " + shipsToUnload.size() +
                            ", total quantity to load is " + shipsToLoad.size());
                }

            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Port port = new Port(3, 5, 100, 30);
        port.generateShips();
    }
}
