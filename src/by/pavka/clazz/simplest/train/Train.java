package by.pavka.clazz.simplest.train;

import java.util.Arrays;

/*
* Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
* Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам поездов.
* Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
* Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления
 */
public class Train {

    private String destination;
    private int number;
    private DepTime time;

    public Train(String destination, int number, DepTime time) {
        this.destination = destination;
        this.number = number;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Train number " + number + " leaving at " + time + " for " + destination;
    }

    public static void main(String[] args) {
        Train[] trains = new Train[] {
               new Train("Minsk", 55, new DepTime(11, 59)),
               new Train("Minsk", 2, new DepTime(9, 05)),
               new Train("London", 155, new DepTime(20, 00)),
               new Train("Moscow", 99, new DepTime(19, 10)),
               new Train("Abakan", 1, new DepTime(5, 15)),

        };
        searchByNumber(trains, 99);
        searchByNumber(trains, 90);
        sortByDestinations(trains);
        sortByNumbers(trains);
    }

    public static Train[] sortByNumbers(Train[] trains) {
        int len = trains.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                if(trains[i].number > trains[j].number) {
                    Train temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(trains));
        return trains;
    }

    public static Train[] sortByDestinations(Train[] trains) {
        int len = trains.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                if(trains[i].destination.compareTo(trains[j].destination) > 0) {
                    Train temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                }
                else if(trains[i].destination.compareTo(trains[j].destination) == 0) {
                    if(trains[j].time.isEarlier(trains[i].time)) {
                        Train temp = trains[i];
                        trains[i] = trains[j];
                        trains[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(trains));
        return trains;
    }

    public static void searchByNumber(Train[] trains, int num) {
        for(Train t: trains) {
            if(t.number == num) {
                System.out.println(t);
                return;
            }
        }
        System.out.println("There is no train with such a number");
    }

}


