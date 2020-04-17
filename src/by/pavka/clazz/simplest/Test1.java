package by.pavka.clazz.simplest;

/*
* Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
* Добавьте метод, который находит сумму значений этих переменных, и метод, который находит наибольшее значение из этих двух переменных
 */
public class Test1 {
    private int first;
    private int second;

    public Test1(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

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

    public static void main(String[] args) {
        Test1 t = new Test1(4, 5);
        t.printFirst();
        t.printSecond();
        t.mutateSecond(-2);
        t.printSecond();
        System.out.println(t.findMax());
    }
}
