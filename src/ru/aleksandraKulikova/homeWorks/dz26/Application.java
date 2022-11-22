package ru.aleksandraKulikova.homeWorks.dz26;

public class Application {
    public static void main(String[] args) {
        Account account01 = new Account(101, 30_000 );
        Account account02 = new Account(111, 4_000 );
        Account account03 = new Account(1111, 2 );

        Bank vtb = new Bank();
        vtb.transferMoney(account02, account01, 1);
        vtb.transferMoney(account01, account02, 31_000);
        vtb.transferMoney(account03, account01, 1);
        vtb.transferMoney(account02, account01, 5_000);


        System.out.println(account01.getBalance());
        System.out.println(account02.getBalance());
        System.out.println(account03.getBalance());


    }
}
