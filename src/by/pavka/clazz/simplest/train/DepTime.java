package by.pavka.clazz.simplest.train;

class DepTime {

    private int hours;
    private int minutes;

    public DepTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isEarlier(DepTime other) {
        if(hours < other.hours) return true;
        if(minutes < other.minutes) return true;
        return false;
    }
}
