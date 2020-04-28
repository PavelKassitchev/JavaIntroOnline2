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

import com.google.gson.Gson;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class HomeLibrary {

    public static final String END_SESSION = "END";
    public static final String END_APP = "EXIT";

    private static Properties authentication = new Properties();
    private static File authData = new File("auth.txt");
    private static FileReader fileReader;
    private static FileWriter fileWriter;

    private static File catalogPath = new File("catalog.txt");
    private static FileReader catalogReader;
    private static FileWriter catalogWriter;


    static {
        try {
            authData.createNewFile();
            fileReader = new FileReader(authData);
            fileWriter = new FileWriter(authData, true);
            authentication.load(fileReader);

            System.out.println(catalogPath.createNewFile() + " " + catalogPath.length());

            catalogReader = new FileReader(catalogPath);
            //catalogWriter = new FileWriter(catalogPath);
//            int reader = catalogReader.read();
//            System.out.println(reader);
//            Scanner catScanner = new Scanner(catalogReader);
//            String catalogString = "";
//            while(catScanner.hasNextLine()) {
//                catalogString += catScanner.nextLine();
//            }
            String catalogString = "";
            BufferedReader br = new BufferedReader(catalogReader);
            String line;
            while((line = br.readLine()) != null) catalogString += line;

            System.out.println("From File " + catalogString);
            Catalog catalog = Catalog.getInstance();
            if (catalogString != null && !catalogString.isEmpty()) {

                BookEntry[] books = new Gson().fromJson(catalogString, BookEntry[].class);

                catalog.setBooks(Arrays.asList(books));
            }
            catalogWriter = new FileWriter(catalogPath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {

        boolean finished = false;
        Dialog dialog = new Dialog(authentication, fileWriter);
        dialog.session(END_SESSION);
        exit();

    }



    private static void exit() {
        System.out.println("Good-bye");

        try {
            //authentication.store(fileWriter, null);
            String catalogString = new Gson().toJson(Catalog.getInstance().getBooks());
            System.out.println(catalogString);
            catalogWriter.write(catalogString);
            catalogWriter.flush();
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
