package by.pavka.clazz.simplest;
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

    }

    public List<Customer> alphabethicList() {
        List<Customer> cust = Arrays.asList(customers);

        return cust;
    }
}

class Customer {

    private String id;
    private String surname;
    private String name;
    private String patronymic;

    private int cardNumber;
    private int account;

    public Customer(String id, String surname, String name, String patronymic, int cardNumber, int account) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + '\n' +
                "Card No. " + cardNumber + '\n' + "Account: " + account + '\n' + '\n';
    }
}