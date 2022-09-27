package dz3;

import java.util.Scanner;

//Задача на использование любого цикла
//Пользователь загадывает число в диапазоне от [2 до 100]
//Программа пытается его угадать (используйте метод бинарного поиска, т.е деление отрезка на 2).
//Программа может задавать пользователю вопросы: Число равно ...?, Число больше ...? и в зависимоти от ответа пользователя принимать решения.
//Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА


public class Task3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста загадайте целое число в диапозоне [2;100]");
        int hum = in.nextInt();


        for (int a = 2, b = 100; true;) {
            int comp = (a + b) / 2;
            System.out.println("Вы загадли число " + comp + " ?");
            int hum1 = in.nextInt();
            if (hum1 == 1) {
                System.out.println("Ура! Эта программа провидеца!");
                break;
            } else {
                System.out.println("Загаданное вами число больше?");
                hum1 = in.nextInt();
                if (hum1 == 1) {
                    a = (a + b) / 2;
                    b = b;
                } else {
                    a = a;
                    b = (a + b) / 2;
                }
            }





        }

    }
}
