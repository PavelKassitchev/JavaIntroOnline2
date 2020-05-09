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
    private int stock;

    public Port(int numberOfPiers, int maxShipsOnRaid, int capacity, int initialStock) {

        shipsToLoad = new ArrayBlockingQueue<>(maxShipsOnRaid);
        shipsToUnload = new ArrayBlockingQueue<>(maxShipsOnRaid);
        this.capacity = capacity;
        this.stock = initialStock > capacity? capacity: initialStock;

        piers = new Pier[numberOfPiers];
        for(int i = 0; i < numberOfPiers; i++) {
            piers[i] = new Pier(this, i + 1);
            new Thread(piers[i]).start();
        }

    }

    public Queue<Ship> getShipsToLoad() {
        return shipsToLoad;
    }

    public Queue<Ship> getShipsToUnload() {
        return shipsToUnload;
    }

    public synchronized int getStock() {
        return stock;
    }

    public synchronized void setStock(int stock) {
        this.stock = stock;
    }

    public synchronized void addStock(int add) {
        stock += add;
    }

    public synchronized void reduceStock(int reduce) {
        stock -= reduce;
    }

    public synchronized boolean commandToLoad() {
        Random random = new Random();
        //TODO
        return random.nextBoolean();
    }

    public void generateShips() {
        Random random = new Random();
        while(true) {
            if(random.nextBoolean()) {
                shipsToLoad.offer(new Ship(10));
            }
            else shipsToUnload.offer(new Ship(10, true));

            System.out.println("Ships to load - " + shipsToLoad.size());
            System.out.println("Ships to unload - " + shipsToUnload.size());
            System.out.println("Port stock = " + stock);

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
