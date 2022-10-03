package dz5;
import java.util.Arrays;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {

        // Задача 3
        //Задать массив на N слов. В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
        // (добавлять новое слово в массив можно только, если в нем его еще нет).
        // В итоге в массиве будут только уникальные слова.
        //
        //Выход из программы по слову exit (слово 'exit' в массив не добавлять) или если массив заполнен.
        // Перед завершением программы, вывести получившийся массив в консоль


        //НЕ ПОЛУЧАЕТСЯ(
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста введите количество элементов массива");
        int len = sc.nextInt();

        Scanner newSc = new Scanner(System.in); //  ввела новый сканер, так как если использовать старый -
        // программа будет думать, что первый enter(после числа элементов) - это первое слово
        String[] arr4 = new String[len];
        System.out.println("Пожалуйста введите слово");
        arr4[0] = newSc.nextLine();

        for (int index = 1; index < len; index++) {
            System.out.println("Пожалуйста введите слово");
            arr4[index] = newSc.nextLine();

            for (int i = index - 1; i >= 0; i--) {
                if (arr4[i].equals(arr4[index])) {
                    while (arr4[i].equals(arr4[index])) {
                        System.out.println("введите другое слово");
                        arr4[i] = newSc.nextLine();
                    }
                } else break;
            }

        }
        System.out.println(Arrays.toString(arr4));
    }
}
