package ru.aleksandraKulikova.homeWorks.dz25;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class FirstThread extends Thread {
    // чтобы передавать коллекции и тд потоку - используем свойства и конструктор
    private CopyOnWriteArrayList<String> strings;

    public FirstThread(CopyOnWriteArrayList<String> strings) {
        this.strings = strings;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        int a = 6;
        while ( a > 0) {
            System.out.println("Введите строку");
            String string = scanner.nextLine();
            strings.add(string);
            a--;
        }
    }
}
