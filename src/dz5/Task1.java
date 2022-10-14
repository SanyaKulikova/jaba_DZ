package dz5;
import java.util.Arrays;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {

        //Задача 1
        //Заполните массив на N элементов случайным целыми числами и выведете максимальное,
        //минимальное и среднее арифметическое значение элементов массива

        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста введите количество элементов массива");
        int len = sc.nextInt();

        int[] arr1 = new int[len];
        int overage = 0;
        int max = arr1[0];
        int min = 100; // тут так, потому что если сделать первое значение массива до цикла его заполнения- оно будет ноль
        //и не будет элементов массива меньше ноля
        for (int index = 0; index < len; index++) {
            arr1[index] = (int) (Math.random() * 101); // пусть будут случайные числа от нуля до ста
            overage += arr1[index];
            if (arr1[index] > max) max = arr1[index];
            if (arr1[index] < min) min = arr1[index];
        }
        System.out.println(Arrays.toString(arr1));


        System.out.println("Максимальное значение элементов массива равно " + max);
        System.out.println("Минимальное значение элементов массива равно " + min);
        System.out.println("Среднее арифметическое значение элементов массива равно " + overage / len);

    }
}
