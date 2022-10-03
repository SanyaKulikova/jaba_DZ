package dz5;
import java.util.Arrays;
import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        //Задача 5
        //Задать массив. Отрицательные элементы массива перенести в новый массив.
        // Размер массива должен быть равен количеству отрицательных элементов.

        int[] arr = {2, 4, -4, 5, -3, -100, 100};
        int len = 0;
        String lane = "";
        StringBuilder sb = new StringBuilder();
        for (int elementValue: arr) {
            if (elementValue < 0) {
                len++;
                sb.append(elementValue).append(" ");
            }
        }
        System.out.println(len);

        // никто не сказал, что это не может быть стринговый массив))
        String concatString = sb.toString();
        String[] newArr = new String[len];
        newArr = concatString.split(" ");
        System.out.println(Arrays.toString(newArr));




    }
}
