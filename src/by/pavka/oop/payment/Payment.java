package by.pavka.oop.payment;

import java.util.ArrayList;
import java.util.List;

/*
* Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */
public class Payment {

    private List<Product> products;

    private int total;

    public Payment() {
        products = new ArrayList<>();
        total = 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Payment to the total amount of " + total + " for " + products;
    }

    public void changeProductQuantity(String name, int price, int quantity) {
        int change = quantity;
        List<Product> copy = new ArrayList<>(products);
        for(Product p: copy) {
            if(p.name == name && p.unitPrice == price) {
                if(p.quantity + quantity > 0) {
                    p.quantity += quantity;
                    total += price * quantity;
                    return;
                }
                change += p.quantity;
                total -= p.quantity * p.unitPrice;
                products.remove(p);

            }
        }
        if(change <= 0) return;
        products.add(new Product(name, price, change));
        total += price * change;

    }

    public class Product {

        private String name;
        private int unitPrice;
        private int quantity;

        public Product(String name, int unitPrice, int quantity) {
            this.name = name;
            if(unitPrice > 0) this.unitPrice = unitPrice;
            if(quantity > 0) this.quantity = quantity;
        }

        @Override
        public String toString() {
            return name + ": " + quantity + " units at Price " + unitPrice;
        }
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.changeProductQuantity("Salt", 1, 10);
        System.out.println(payment);
        payment.changeProductQuantity("Bread", 4, 1);
        System.out.println(payment);
        payment.changeProductQuantity("Salt", 1, -1);
        System.out.println(payment);
        payment.changeProductQuantity("Bread", 4, -2);
        System.out.println(payment);

    }
}
