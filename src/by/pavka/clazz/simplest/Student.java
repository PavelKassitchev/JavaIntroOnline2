package by.pavka.clazz.simplest;

/*
* Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов).
* Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Student {

    private String surname;
    private String initials;
    private int group;
    private int performance;

    public Student(String surname, String initials, int group, int performance) {
        this.surname = surname;
        this.initials = initials;
        this.group = group;
        this.performance = performance;
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("Ivanov", "I.I", 3, 8),
                new Student("Petrov", "P.P", 1, 9),
                new Student("Pavlov", "U.P", 2, 10),
                new Student("Kuzmin", "K.L", 1, 4),
                new Student("Smirnov", "S.T", 3, 9),
                new Student("Kazakov", "L.P", 2, 7),
                new Student("Popov", "V.V", 2, 6),
                new Student("Volk", "M.P", 1, 10),
                new Student("Lisa", "N.T", 2, 5),
                new Student("Zaya", "Z.P", 3, 7)
        };

        System.out.println("Best of the best!!");

        for(Student s: students) {
            if(s.performance > 8) {
                System.out.println(s.surname + ", group " + s.group);
            }
        }
    }
}
