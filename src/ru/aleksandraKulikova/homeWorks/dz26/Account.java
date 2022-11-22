package ru.aleksandraKulikova.homeWorks.dz26;

public class Account {
    private int id; // unique
    private int balance; // доступные средства на аккаунте

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void pay(int money){
        this.balance -= money;
    }

    public void receive (int money){
        this.balance += money;
    }
}
