package by.pavka.oop.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
* Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */
public class Calendar {
    private List<Holiday> holidays;

    public Calendar() {
        holidays = new ArrayList<>();
    }

    public void addHoliday(int m, int d) {
        Holiday h = new Holiday(m, d);
        if(!holidays.contains(h)) {
            holidays.add(h);
        }
    }

    public boolean removeHoliday(int m, int d) {
        Holiday h = new Holiday(m, d);
        return holidays.remove(h);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "holidays=" + holidays +
                '}';
    }

    private class Holiday {
        private int month;
        private int dayOfMonth;

        public Holiday(int month, int dayOfMonth) {
            this.month = month;
            this.dayOfMonth = dayOfMonth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holiday holiday = (Holiday) o;
            return month == holiday.month &&
                    dayOfMonth == holiday.dayOfMonth;
        }

        @Override
        public int hashCode() {
            return Objects.hash(month, dayOfMonth);
        }

        @Override
        public String toString() {
            return dayOfMonth + "." + month + " of this year";
        }
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.addHoliday(1, 1);
        calendar.addHoliday(3, 8);
        System.out.println(calendar);
        calendar.removeHoliday(1, 1);
        System.out.println(calendar);

    }
}
