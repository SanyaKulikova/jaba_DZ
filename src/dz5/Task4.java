package dz5;
import java.util.Arrays;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {

        // Задача 4
        // Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.
        // Предложение для поска длинного слова: "в предложении все слова разной длины"
        // (самостоятельно найти метод преобразования строки в массив строк).

        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста введите предложение, в котором все слова разной длины");
        String line0 = sc.nextLine();
        // как сделать правильную проверку на длину слов???


        String[] arr = line0.split(" "); // метод для создания массива из строки
        // в скобках - разделитель
        System.out.println(Arrays.toString(arr));

        String maxLength = arr[0];
        for (String elementValue: arr) {
            if (elementValue.length() > maxLength.length()) {
                maxLength = elementValue;
            }
        }
        System.out.println(maxLength);

    }
}
