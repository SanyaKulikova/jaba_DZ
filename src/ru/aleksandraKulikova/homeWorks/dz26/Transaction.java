package ru.aleksandraKulikova.homeWorks.dz26;

public class Transaction implements Runnable{
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    // TODO перевод денежных средств со счета src на счет dst в количестве money
    @Override
    public void run() {
        if (this.src.getBalance() >= money){
            synchronized (src) {
                src.pay(money);
            }
            synchronized (dst) {
                dst.receive(money);
            }

        } else System.out.println("На вашем счету не достаточно средств");
    }
}
