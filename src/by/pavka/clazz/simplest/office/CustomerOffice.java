package by.pavka.clazz.simplest.office;
/*
* 	Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString().
* Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.

Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomerOffice {

    private Customer[] customers;

    public CustomerOffice(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return Arrays.toString(customers);
    }

    public static void main(String[] args) {
        Customer[] custs = new Customer[]{
                new Customer("id-1", "Ivanov", "Ivan", "Ivanovich", 55, 1000897),
                new Customer("id-2", "Petrov", "Petr", "Petrovich", 505, 100899),
                new Customer("id-3", "Sidorov", "Sidor", "Sidorovich", 51, 1897),
                new Customer("id-4", "Ivanov", "Ivan", "Gavrilovich", 5, 17),
                new Customer("id-5", "Ivanov", "Pavel", "Ivanovich", 5509, 1022),

        };

        CustomerOffice office = new CustomerOffice(custs);
        office.alphabeticList();
        office.byCardNumber(0, 56);
    }

    public List<Customer> alphabeticList() {
        List<Customer> cust = Arrays.asList(customers);
        Comparator<Customer> comparator = Comparator.comparing(customer -> customer.getSurname());
        comparator = comparator.thenComparing(customer -> customer.getName());
        comparator = comparator.thenComparing(customer -> customer.getPatronymic());

        cust.sort(comparator);
        System.out.println(cust);

        return cust;
    }

    public List<Customer> byCardNumber(int start, int end) {
        List<Customer> cust = new ArrayList<>();
        for(Customer c: customers) {
            if(start <= c.getCardNumber() && c.getCardNumber() <= end) {
                cust.add(c);
            }
        }
        System.out.println(cust);

        return cust;
    }
}

