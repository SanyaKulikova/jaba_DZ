package dz3;

import java.util.Scanner;

//Задача на WHILE
//Считать с консоли количество тарелок и моющего средства.
//Моющее средство расходуется из расчета 0.5 на 1 тарелку (за один раз расходуется 0.5 стредства и 1 тарелка).
//В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
//После цыкла вывести сколько тарелок и моющего средства осталось.

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество тарелок (целое положительное число)");
        int plates = in.nextInt();
        System.out.println("Введите объем моющего средства (положительное число)");
        double soap = in.nextDouble();

        while (plates > 0) {
            if (soap < 0.5) {
                System.out.println("Моющего средства не хватает");
                break;
            }
            soap = soap - 0.5;
            plates --;
            System.out.println(soap);
        }
        System.out.println("Осталось" + " " + plates + " тарелок и " + soap + " моющего средства");
    }
}
