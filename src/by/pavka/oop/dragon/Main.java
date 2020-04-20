package by.pavka.oop.dragon;

import by.pavka.oop.dragon.zoo.ChineseDragon;
import by.pavka.oop.dragon.zoo.Dragon;
import by.pavka.oop.dragon.zoo.GermanDragon;
import by.pavka.oop.dragon.zoo.RussianDragon;

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

        System.out.println("This application allows you to select a Dragon among three sorts of them and check their treasuries following the instructions below");
        System.out.println();

        int choice = processInput("First choose your Dragon", "To exit the program", "For German Dragon", "For Russian Dragon", "For Chinese Dragon");

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

        int choice2 = -1;

        while (choice2 != 0) {
            choice2 = processInput("Choose what you want me to do", "For saying good-by in my native language", "For showing my treasury", "For showing my most expensive treasure",
                    "For selecting treasures that match the amount you will chose");

            switch (choice2) {
                case 0:
                    dragon.sayGoodBye();
                    return;
                case 1:
                    dragon.showTreasures();
                    break;
                case 2:
                    dragon.selectTheMostExpensive();
                    break;
                case 3:
                    int amount = processAmount(dragon);
                    dragon.selectToMatchAmount(amount);
            }
        }


    }

    private static int processInput(String... choices) {
        int choice = -1;
        String error = "";
        int max = choices.length;
        while(choice < 0 || choice >= max - 1) {
            System.out.println(error);
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

    private static int processAmount(Dragon dragon) {
        int amount = 0;
        boolean okAmount = false;
        String error = "";
        while(!okAmount) {
            System.out.println(error);
            System.out.println("Choose the amount you want my treasures to match");
            System.out.println(">");
            if(!scanner.hasNextInt()) {
                error = "Your input is incorrent, you should chose an integer";
                scanner.nextLine();
                continue;
            }
            else {
                amount = scanner.nextInt();
                if(amount < dragon.getTreasures()[0].getPrice()) {
                    error = "This is less than the cheapest item im my treasury";
                    continue;
                }
                if(amount > dragon.getWealth()) {
                    error = "Not so much... Choose a more realistic amount";
                    continue;
                }
                okAmount = true;
            }
        }
        return amount;
    }


}
