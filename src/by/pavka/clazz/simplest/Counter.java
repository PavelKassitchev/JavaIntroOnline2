package by.pavka.clazz.simplest;
/*
* Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в заданном диапазоне.
* Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
* Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние.
* Написать код, демонстрирующий все возможности класса
 */

public class Counter {

    private int max;
    private int current;

    public Counter() {
        max = 100;
        current = 0;
    }

    public Counter(int max, int current) {

        if(max < 0 || current < 0 || current > max) {
            this.max = 0;
            this.current = 0;
        }

        else {
            this.max = max;
            this.current = current;
        }
    }

    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public void increase() {

        if(current < max){
            current++;
        }
    }

    public void decrease() {
        if(current > 0) {
            current--;
        }
    }

    public static void main(String[] args) {

        Counter counter1 = new Counter();
        System.out.println(counter1.getMax());
        System.out.println(counter1.getCurrent());
        counter1.increase();
        counter1.increase();
        counter1.decrease();
        System.out.println(counter1.getCurrent());

        Counter counter2 = new Counter(2, 1);
        System.out.println(counter2.getCurrent());
        counter2.increase();
        counter2.increase();
        System.out.println(counter2.getCurrent());
        counter2.decrease();
        System.out.println(counter2.getCurrent());
        counter2.decrease();
        System.out.println(counter2.getCurrent());
        counter2.decrease();
        System.out.println(counter2.getCurrent());
    }
}
