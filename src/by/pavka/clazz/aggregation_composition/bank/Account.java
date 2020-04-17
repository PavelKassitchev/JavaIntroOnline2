package by.pavka.clazz.aggregation_composition.bank;

public class Account {

    private int number;
    private boolean isBlocked;
    private Client client;
    private int amount;

    public Account(int number, int amount, boolean isBlocked) {
        this.number = number;
        this.isBlocked = isBlocked;
        this.amount = amount;
    }

    public Account(int number) {
        this(number, 0, false);
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean block) {
        isBlocked = block;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Acc.No. " + number + ", available amount " + amount + ", blocked = " + isBlocked;
    }
}
