package ru.aleksandraKulikova.homeWorks.dz17.transactions;

import java.util.Objects;

public class Account {
    private String number;
    private long balance;

    public Account(String number, long balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (balance != account.balance) return false;
        return Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        return result;
    }
}
