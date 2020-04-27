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
import java.util.Date;
import java.util.Properties;

public class HomeLibrary {

    public static final String END_SESSION = "END";
    public static final String END_APP = "EXIT";

    private static Properties authentication = new Properties();
    private static File authData = new File("auth.txt");
    private static FileReader fileReader;
    private static FileWriter fileWriter;


    static {
        try {
            authData.createNewFile();
            fileReader = new FileReader(authData);
            fileWriter = new FileWriter(authData, true);
            authentication.load(fileReader);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {

        boolean finished = false;
        Dialog dialog = new Dialog(authentication);
        dialog.session(END_SESSION);
        exit();

    }



    private static void exit() {
        System.out.println("Good-bye");

        try {
            authentication.store(fileWriter, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
