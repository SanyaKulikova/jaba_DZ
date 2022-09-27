package dz3;

import java.util.Scanner;

//Задача на использование любого цикла
//Программа загадывает число в диапазоне [1;9]
//Пользователь вводит число с клавиатуры
//Программа в зависимости от введенного числа выводит в консоль следующее:
//"загаданное число больше"
//"загаданное число меньше"
//"Вы угадали" (программа завершает работу)
//Если введен 0, выввести "выход из программы" (программа завершает работу)

public class Task2 {
    public static void main(String[] args) {

        double comp = Math.floor(Math.random() * (9 - 1 + 1)) + 1;
        // [0,1) * (max - min +1) = [0;max - min + 1)
        // [0; max - min + 1) + min = [min; max+1) -- вот и наш интрвал
        // функция Math.floor округляет число в меньшую сторону до ближайшего целого значения
        //System.out.println(comp);

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Пожалуйста введите целое число в диапозоне [1;9]");
            int hum = in.nextInt();
            if (hum == 0) {
                System.out.println("Выход из программы");
                break;
            } else if (hum > comp) {
                System.out.println("Ваше число больше загаданного");
            } else if (hum < comp) {
                System.out.println("Ваше число меньше загаданного");
            } else if (hum == comp) {
                System.out.println("Поздравляю! Вы угадали!");
                break;
            }
        }

    }
}
