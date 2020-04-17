package by.pavka.clazz.aggregation_composition.bank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
* Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно
 */
public class Client {
    private List<Account> accounts;

    public Client(List<Account> accounts) {
        this.accounts = accounts;
        for(Account acc: accounts) {
            acc.setClient(this);
        }
    }

    public Client() {
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        if(this.accounts != null) {
            for(Account old: this.accounts) {
                old.setClient(null);
            }
        }
        this.accounts = accounts;
        for(Account acc: accounts) {
            acc.setClient(this);
        }
    }


    public List<Account> sortByNumber() {
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        System.out.println(accounts);
        return accounts;
    }

    public static void main(String[] args) {
        Account a1 = new Account(145);
        Account a2 = new Account(155);
        Account a3 = new Account(105);
        Account a4 = new Account(45);

        List<Account> accs = new ArrayList<>();
        accs.add(a1);
        accs.add(a2);
        accs.add(a3);
        accs.add(a4);

        Client client = new Client(accs);

        client.sortByNumber();
    }
}

