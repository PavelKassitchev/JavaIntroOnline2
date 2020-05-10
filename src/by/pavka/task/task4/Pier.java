package by.pavka.task.task4;

public class Pier implements Runnable {

    private Port port;
    private int id;

    public Pier(Port port, int id) {
        this.port = port;
        this.id = id;
    }

    public Port getPort() {
        return port;
    }


    @Override
    public String toString() {
        return "Pier No." + id;
    }

    @Override
    public void run() {
        while (true) {
            Ship ship = null;
            boolean load;
            synchronized (port) {
                load = port.commandToLoad();

                if (load) {
                    ship = port.getShipsToLoad().poll();
                    if (ship != null) {
                        System.out.println(this + " starts loading " + ship);
                        int cargo = ship.getCapacity();
                        port.reduceFutureStock(cargo);
                        port.reduceStock(cargo);
                        System.out.println("Cargo has left warehouse. Current Port Stock is " + port.getCurrentStock());
                    }
                } else {
                    ship = port.getShipsToUnload().poll();
                    if (ship != null) {
                        System.out.println(this + " starts unloading " + ship);
                        int cargo = ship.getLoad();
                        port.addFutureStock(cargo);
                    }
                }
            }

            if (load && ship != null) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ship.setLoad(ship.getCapacity());
                System.out.println(this + " has loaded " + ship);
                continue;
            }
            if (!load && ship != null) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ship.setLoad(0);
                System.out.println(this + " has unloaded " + ship);
                synchronized (port) {
                    port.addStock(ship.getCapacity());
                    System.out.println("Cargo has been placed in warehouse. Current Port Stock is " + port.getCurrentStock());
                }

            }

        }
    }

}
