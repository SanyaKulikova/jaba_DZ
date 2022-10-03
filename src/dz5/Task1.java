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
        for (int index = 0; index < len; index++) {
            arr1[index] = (int) (Math.random() * 101); // пусть будут случайные числа от нуля до ста
        }
        System.out.println(Arrays.toString(arr1));

        int overage = 0;
        int max = arr1[0];
        int min = arr1[0];
        for (int elementValue: arr1) {
            //System.out.println(elementValue);
            overage += elementValue;
            if (elementValue > max) max = elementValue;
            if (elementValue < min) min = elementValue;
        }
        System.out.println("Максимальное значение элементов массива равно " + max);
        System.out.println("Минимальное значение элементов массива равно " + min);
        System.out.println("Среднее арифметическое значение элементов массива равно " + overage / len);

    }
}
