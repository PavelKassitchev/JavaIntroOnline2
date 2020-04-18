package by.pavka.oop.payment;

import java.util.List;

/*
* Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */
public class Payment {

    private List<Product> products;

    private int total;

    private class Product {

        private String name;
        private int unitPrice;
        private int quantity;


    }
}
