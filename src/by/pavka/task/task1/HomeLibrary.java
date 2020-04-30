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

import by.pavka.task.task1.book.BookEntry;
import by.pavka.task.task1.book.Catalog;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class HomeLibrary {

    public static final String END_SESSION = "END";

    private static Properties authentication = new Properties();
    private static File authData = new File("auth.txt");
    private static FileReader fileReader;
    private static FileWriter fileWriter;

    private static File catalogPath = new File("catalog.txt");
    private static FileReader catalogReader;


    static {
        try {
            authData.createNewFile();
            fileReader = new FileReader(authData);
            fileWriter = new FileWriter(authData, true);
            authentication.load(fileReader);
            catalogPath.createNewFile();
            catalogReader = new FileReader(catalogPath);
            String catalogString = "";
            BufferedReader br = new BufferedReader(catalogReader);
            String line;
            while((line = br.readLine()) != null) catalogString += line;

            Catalog catalog = Catalog.getInstance();
            if (catalogString != null && !catalogString.isEmpty()) {

                BookEntry[] books = new Gson().fromJson(catalogString, BookEntry[].class);

                catalog.setBooks(new ArrayList(Arrays.asList(books)));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {

        Dialog dialog = new Dialog(authentication, fileWriter);
        dialog.session(END_SESSION);
        exit();

    }



    private static void exit() {
        System.out.println("Good-bye");

        try {
            if (Catalog.getInstance().isModified()) {
                String catalogString = new Gson().toJson(Catalog.getInstance().getBooks());
                FileWriter catalogWriter = new FileWriter(catalogPath);
                catalogWriter.write(catalogString);
                catalogWriter.flush();
            }
            fileWriter.close();
            fileReader.close();
            catalogReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getAuthentication() {
        return authentication;
    }

}
