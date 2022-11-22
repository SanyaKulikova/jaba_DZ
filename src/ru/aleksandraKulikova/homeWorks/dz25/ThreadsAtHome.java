package ru.aleksandraKulikova.homeWorks.dz25;

// Дана коллекция: CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();.

//Необходимо реализовать следующий функционал:
//один дополнительный поток получает строки от пользователя их добавляет их в коллекцию strings
//другой дополнительный поток приостанавливает работу на 30 секунд, после чего записывает в файл минимальную по размеру строку из коллекции strings (для определения минимальной строки использовать Stream API). После записи в файл строку необходимо удалить из коллекции.
//Лямбда выражения для реализации метода run не использовать.


import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadsAtHome {
    public static void main(String[] args) {


        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        Handler<String> handler = new Handler<>();

        FirstThread thread01 = new FirstThread(strings);
        SecondThread thread02 = new SecondThread(strings);


         /*Thread thread01 = new Thread( () -> { // использую лямбда выражения потому что не понимаю
             // как добавлять в коллекцию, если в run нельзя передавать
             // а если создавать коллекцию у run в отдельном классе, то это будет уже не общая коллекция
             Scanner scanner = new Scanner(System.in);
             int a = 6;
             while ( a > 0) {
                 System.out.println("Введите строку");
                 String string = scanner.nextLine();
                 strings.add(string);
                 a--;
             }
         });*/

         /*Thread thread02 = new Thread( () -> {
             try {
                 Thread.sleep(30_000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             String minBySize = strings.stream()
                     .min((s1, s2) -> s1.length() - s2.length())
                     .get();
             handler.writeToFile(minBySize);
             strings.remove(minBySize);
         });*/

        thread01.start();
        thread02.start();

        try {
            thread01.join(); // без аргументов - бесконечное ожидание
            thread02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(strings);
        String result = handler.readFromFile();
        System.out.println(result);





    }

}
