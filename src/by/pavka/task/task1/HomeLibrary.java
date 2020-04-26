package by.pavka.task.task1;
/*
* Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.


Общие требования к заданию:

•	Система учитывает книги как в электронном, так и в бумажном варианте.

•	Существующие роли: пользователь, администратор.

•	Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.

•	Администратор может модифицировать каталог.

•	*При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям

•	**При просмотре каталога желательно реализовать постраничный просмотр

•	***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на e-mail.

•	Каталог книг хранится в текстовом файле.

•	Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде

 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class HomeLibrary {

    public static void main(String[] args) throws IOException {
        File auth = new File("AUTH");
        auth.mkdirs();
        File data = new File(auth + "\\data.txt");
        Properties properties = new Properties();
        FileWriter fileWriter = null;

        try{
            data.createNewFile();
            //properties.load(new FileReader(data));
            properties.setProperty("play", "once");
            fileWriter = new FileWriter(data);
            properties.store(fileWriter, null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User("Paul", "pavka", "123456");
        System.out.println(user);
        properties.setProperty(user.getName(), String.valueOf(user.getPassHash()));
        properties.store(fileWriter, "O");
    }
}
