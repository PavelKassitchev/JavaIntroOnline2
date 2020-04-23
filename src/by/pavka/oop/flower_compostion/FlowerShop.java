package by.pavka.oop.flower_compostion;

import by.pavka.oop.flower_compostion.decor.Asparagus;
import by.pavka.oop.flower_compostion.decor.Band;
import by.pavka.oop.flower_compostion.flower.Clove;
import by.pavka.oop.flower_compostion.flower.Flower;
import by.pavka.oop.flower_compostion.flower.Rose;
import by.pavka.oop.flower_compostion.flower.Tulip;
import static by.pavka.oop.flower_compostion.Color.*;
import static by.pavka.oop.flower_compostion.flower.Flower.*;

import java.util.Map;

/*
* Создать консольное приложение, удовлетворяющее следующим требованиям:

•	Корректно спроектируйте и реализуйте предметную область задачи.

•	Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.

•	Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.

•	для проверки корректности переданных данных можно применить регулярные выражения.

•	Меню выбора действия пользователем можно не реализовывать, используйте заглушку.

•	Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().


Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции

(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы и упаковка.


 */
public class FlowerShop {


    public static void main(String[] args) {

        Bouquet.BouquetBuilder builder = Bouquet.getBuilder();
        builder.addFlower(new Tulip(-6, RED), new Rose(TOP_QUALITY, RED));
        builder.removeFlower(new Tulip(LOW_QUALITY, RED));
        builder.addFlower(new Rose(MEDIUM_QUALITY, YELLOW));
        builder.removeFlower(new Rose(MEDIUM_QUALITY, YELLOW)).addFlower(new Rose(LOW_QUALITY, VIOLET));
        builder.addFlower(new Rose(LOW_QUALITY, VIOLET), new Clove(MEDIUM_QUALITY, YELLOW)).addDecor(new Asparagus()).addDecor(new Band(GREEN)).wrap();
    }
}
