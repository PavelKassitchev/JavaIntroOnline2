package by.pavka.oop.text_file;
/*
* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.

 */

public class TextFile extends File<String> {

    private TextFile(String name) {
        setName(name);
    }

    public static TextFile createTextFile(String name) {
        return new TextFile(name);
    }

    public void rename(String newName) {
        setName(newName);
    }

    @Override
    public void printContent() {
        System.out.println(getContent());
    }

    @Override
    public <T> void addContent(T addition) {
        setContent(getContent() + addition);
    }

    public static void main(String[] args) {
        Directory root = new Directory("root");
        System.out.println(root);
        root.addFile(createTextFile("First"));
        System.out.println(root);
        root.addChild(new Directory("child"));
        System.out.println(root);
        Directory in = new Directory("in");
        root.addChild(in);
        System.out.println(root);
        File file = createTextFile("second");
        in.addFile(file);
        System.out.println(root);
        in.removeFile(file);
        System.out.println(root);
    }
}
