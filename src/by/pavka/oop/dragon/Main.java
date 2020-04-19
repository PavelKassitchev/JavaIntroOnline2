package by.pavka.oop.dragon;

import java.util.Scanner;

/*
* Создать консольное приложение, удовлетворяющее следующим требованиям:
•	Приложение должно быть объектно-, а не процедурно-ориентированным.
•	Каждый класс должен иметь отражающее смысл название и информативный состав.
•	Наследование должно применяться только тогда, когда это имеет смысл.
•	При кодировании должны быть использованы соглашения об оформлении кода java code convention.
•	Классы должны быть грамотно разложены по пакетам.
•	Консольное меню должно быть минимальным.
•	Для хранения данных можно использовать файлы.

Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
* Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.


 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Dragon dragon = null;
//        String error = "";
//        int choice = -1;
//        Scanner scanner = new Scanner(System.in);
//        while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
//            System.out.println(error);
//            System.out.println("Choose your Dragon!");
//            System.out.println("For German Dragon print '1'");
//            System.out.println("For German Russian print '2'");
//            System.out.println("For Chinese Dragon print '3'");
//            System.out.println("To exit the program print '0'");
//            System.out.println(">");
//            error = "You input is incorrect, try again..." + '\n';
//            if(scanner.hasNextInt()) choice = scanner.nextInt();
//            else {
//                scanner.nextLine();
//                continue;
//            }
//        }
        int choice = processInput("Choose your Dragon", "To exit the program", "For German Dragon", "For Russian Dragon", "For Chinese Dragon");

        switch(choice) {
            case 0:
                System.out.println("It is a pity. I wish you talked to one of our dragons. But...");
                return;

            case 1:
                dragon = new GermanDragon();
                break;
            case 2:
                dragon = new RussianDragon();
                break;
            case 3:
                dragon = new ChineseDragon();
                break;

        }

        dragon.introduce();
        dragon.fillInTreasury();
        //dragon.showTreasures();
        dragon.selectTheMostExpensive();
    }

    private static int processInput(String... choices) {
        int choice = -1;
        String error = "";
        int max = choices.length;
        while(choice < 0 || choice >= max - 1) {
            System.out.println(choices[0]);
            for(int i = 1; i < max; i++) {
                System.out.println(choices[i] + " print '" + (i-1) + "'");
            }
            System.out.println(">");
            error = "You input is incorrect, try again..." + '\n';
            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            else {
                scanner.nextLine();
                continue;
            }
        }
       return choice;
    }


}
