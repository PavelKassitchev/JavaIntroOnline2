package by.pavka.clazz.simplest.airport;

class DepartureTime {
    private int hours;
    private int minutes;

    public DepartureTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        String h = String.valueOf(hours);
        if(hours < 10) h = "0" + h;
        String m = String.valueOf(minutes);
        if(minutes < 10) m = "0" + minutes;
        return h + ":" + m;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isLater(DepartureTime other) {
        if(hours > other.hours) return true;
        if(minutes > other.minutes) return true;
        return false;
    }
}
