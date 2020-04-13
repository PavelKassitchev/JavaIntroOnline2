package by.pavka.clazz.simplest;

/*
*
* Составьте описание класса для представления времени. Предусмотрте возможности установки времени и изменения его отдельных полей (час, минута, секунда)
*  с проверкой допустимости вводимых значений. В случае недопустимых значений полей поле устанавливается в значение 0.
* Создать методы изменения времени на заданное количество часов, минут и секунд.
 */
public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(hours < 0 || hours > 23) {
            this.hours = 0;
            return;
        }
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if(minutes < 0 || minutes > 59) {
            this.minutes = 0;
            return;
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if(seconds < 0 || seconds > 59) {
            this.seconds = 0;
            return;
        }
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String h = String.valueOf(hours);
        if(hours < 10) h = "0" + h;
        String m = String.valueOf(minutes);
        if(minutes < 10) m = "0" + minutes;
        String s = String.valueOf(seconds);
        if(seconds < 10) s = "0" + seconds;
        return h + ":" + m + ":" + s;
    }

    public void changeHours(int delta) {
        int newHours = (hours + delta) % 24;
        if(newHours < 0) newHours = 24 + newHours;
        setHours(newHours);
    }

    public void changeMinutes(int delta) {
        int newMinutes = (minutes + delta) % 60;
        int newHours = hours + (minutes + delta) / 60;
        if(newMinutes < 0) {
            newHours--;
            newMinutes = 60 + newMinutes;
        }
        setHours(newHours);
        setMinutes(newMinutes);
    }

    public void changeSeconds(int delta) {
        int newSeconds = (seconds + delta) % 60;
        int deltaMinutes = (seconds + delta) / 60;
        if(newSeconds < 0) {
            deltaMinutes--;
            newSeconds = 60 + newSeconds;
        }
        changeMinutes(deltaMinutes);
        setSeconds(newSeconds);
    }

    public static void main(String[] args) {
        Time time = new Time();
        time.changeHours(-50);
        System.out.println(time);
        time.setMinutes(34);
        time.changeMinutes(-40);
        System.out.println(time);
        time.changeMinutes(70);
        System.out.println(time);
        time.changeSeconds(-3670);
        System.out.println(time);
    }

}
