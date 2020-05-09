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

    public void load(Ship ship) {
        port.reduceStock(ship.getCapacity());
        ship.setLoad(ship.getCapacity());
    }
    public void unload(Ship ship) {
        port.addStock(ship.getLoad());
        ship.setLoad(0);
    }

    @Override
    public String toString() {
        return "Pier No. " + id;
    }

    @Override
        public void run() {
            while(true) {
                System.out.println(this + " is ready to work");

                if(port.commandToLoad()) {
                    Ship ship = port.getShipsToLoad().poll();
                    if(ship != null) {
                        System.out.println(this + " starts loading " + ship);
                        port.reduceStock(ship.getCapacity());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(this + " has loaded " + ship);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else {
                    Ship ship = port.getShipsToUnload().poll();
                    if(ship != null) {
                        System.out.println(this + " starts unloading " + ship);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(this + " has unloaded " + ship);
                        port.addStock(ship.getLoad());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }

}
