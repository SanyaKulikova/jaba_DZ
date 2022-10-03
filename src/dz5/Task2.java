package dz5;
import java.util.Arrays;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {

        //Задача 2
        //Создайте массив из чётных чисел [2;20] и выведите элементы
        // массива в консоль в обратном порядке (20 18 16 ... 4 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста введите количество элементов массива");
        int len = sc.nextInt();

        int[] arr2 = new int[len];

        //  Сначала я подумала, что нужен массив из случайных чисел в диапозоне [2;20]
        for (int index = 0; index < len; index++) {
            int a = (int) (Math.random() * (20 - 2 +1) + 2);
            if (a % 2 == 0) arr2[index] = a;
            else arr2[index] = a + 1;
        }
        System.out.println(Arrays.toString(arr2));

        for (int index = len - 1; index >= 0; index--) {
            System.out.print(arr2[index] + " ");
        }
        System.out.println();


        //
        int[] arr3 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int len2 = arr3.length;
        System.out.println(Arrays.toString(arr3));
        for (int index2 = len2-1; index2 >= 0; index2--) {
            System.out.print(arr3[index2] + " ");
        }

    }
}