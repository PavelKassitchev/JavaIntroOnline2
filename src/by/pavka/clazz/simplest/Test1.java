package by.pavka.clazz.simplest;

/*
* Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
* Добавьте метод, который находит сумму значений этих переменных, и метод, который находит наибольшее значение из этих двух переменных
 */
public class Test1 {
    private int first;
    private int second;

    public void printFirst() {
        System.out.println("first = " + first);
    }
    public void printSecond() {
        System.out.println("second = " + second);
    }
    public void mutateFirst(int delta) {
        first += delta;
    }
    public void mutateSecond(int delta) {
        second += delta;
    }
    public int sum() {
        return first + second;
    }
    public int findMax() {
        return first > second? first: second;
    }
}
