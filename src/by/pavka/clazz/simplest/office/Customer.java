package by.pavka.clazz.simplest.office;

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
        return '\n' + surname + " " + name + " " + patronymic + '\n' +
                "Card No. " + cardNumber + '\n' + "Account: " + account + '\n';
    }
}
