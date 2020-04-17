package by.pavka.clazz.simplest.airport;

class Airline {

    private String destination;
    private int flight;
    private String type;
    private DepartureTime time;
    private int weekDay;

    public Airline(String destination, int flight, String type, DepartureTime time, int weekDay) {
        this.destination = destination;
        this.flight = flight;
        this.type = type;
        this.time = time;
        this.weekDay = weekDay;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DepartureTime getTime() {
        return time;
    }

    public void setTime(DepartureTime time) {
        this.time = time;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return destination + " " + time + " " + weekDay + " " + "Flight " + flight;
    }
}
