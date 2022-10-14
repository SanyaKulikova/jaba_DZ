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

        /*Scanner newSc = new Scanner(System.in); //  ввела новый сканер, так как если использовать старый -
        // программа будет думать, что первый enter(после числа элементов) - это первое слово

        String[] arr4 = new String[len];
        System.out.println("Пожалуйста введите слово");
        arr4[0] = newSc.nextLine();

        for (int index = 1; index < len; index++) {
            System.out.println("Пожалуйста введите слово");
            arr4[index] = newSc.nextLine();

            for (int i = index - 1; i >= 0; i--) {
                if (arr4[index].equals(arr4[i])) {
                    while (arr4[index].equals(arr4[i])) {
                        System.out.println("введите другое слово");
                        arr4[index] = newSc.nextLine();
                    }
                }
            }

       }
        System.out.println(Arrays.toString(arr4));*/

        // Решение от Дарьи:

        // вместо нового сканера можно просто считать Enter
        sc.nextLine();
        String[] arr4 = new String[len];

        for (int index = 0; index < len; index++) {
            // запрашиваем один раз, нет смысла дублировать код с вопросом
            System.out.println("Пожалуйста введите слово");
            String enter = sc.nextLine();

            for (int i = 0; i < arr4.length; i++) { // просо перебираем массив
                if (enter.equals(arr4[i])) { // проверяем, совпало ли введенное слово с элементом массива, если совпало
                    // дальше нет смысла проверять,  откатываем счетчик и прерываем цикл
                    index--;
                    break;
                }
                if (arr4[i] == null) { // если цикл дошел до null элемента, значит
                    // совпадений не было, можно записывать новое слово
                    arr4[i] = enter;
                    break; // прерываем цикл
                }
            }

        }
        System.out.println(Arrays.toString(arr4));

    }
}
